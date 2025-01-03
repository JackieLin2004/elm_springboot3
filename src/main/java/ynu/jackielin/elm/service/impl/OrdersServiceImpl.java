package ynu.jackielin.elm.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import ynu.jackielin.elm.dto.request.OrdersRO;
import ynu.jackielin.elm.dto.response.BusinessVO;
import ynu.jackielin.elm.dto.response.FoodVO;
import ynu.jackielin.elm.dto.response.OrdersBusinessVO;
import ynu.jackielin.elm.dto.response.OrdersFoodVO;
import ynu.jackielin.elm.entity.po.Orders;
import ynu.jackielin.elm.mapper.OrdersMapper;
import ynu.jackielin.elm.service.BusinessService;
import ynu.jackielin.elm.service.FoodService;
import ynu.jackielin.elm.service.OrderDetailedService;
import ynu.jackielin.elm.service.OrdersService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders> implements OrdersService {

    @Resource
    OrderDetailedService orderDetailedService;

    @Resource
    BusinessService businessService;

    @Resource
    FoodService foodService;

    /**
     * 创建订单
     * 该方法负责根据提供的订单信息创建一个新的订单记录在数据库中
     * 如果插入成功，返回新创建的订单的订单ID；如果失败，则返回null
     *
     * @param ro 包含订单相关信息的记录对象，如用户ID、商家ID和总价格
     * @return 成功创建订单后返回订单ID，否则返回null
     */
    @Override
    public Long createOrders(OrdersRO ro) {
        Orders order = new Orders();
        order.setUserId(ro.getUserId());
        order.setBusinessId(ro.getBusinessId());
        order.setOrderTotal(ro.getTotalPrice());
        order.setOrderState(0);
        order.setDaId(1L);
        order.setOrderDate(LocalDateTime.now().toString());
        int insertResult = baseMapper.insert(order);
        if (insertResult > 0) {
            // 插入进行明细表
            Long orderId = order.getOrderId();
            if (orderDetailedService.addInOrderDetailed(ro.getUserId(), ro.getBusinessId(), orderId)) {
                return orderId;
            } else return null;
        } else return null;
    }

    /**
     * 获取订单的业务信息
     * 该方法用于根据订单ID获取订单的详细商家信息，包括商家名称、配送费用和订单总价
     * 它首先根据订单ID获取订单信息，然后根据业务ID获取商家详细信息，并最终组合这些信息返回
     *
     * @param orderId 订单ID，用于查询订单和相关业务信息
     * @return OrdersBusinessVO 返回一个包含业务名称、配送费用和订单总价的订单业务信息对象
     */
    @Override
    public OrdersBusinessVO getOrdersBusinessInfo(Long orderId) {
        Orders orders = getById(orderId);
        BusinessVO businessVO = businessService.listBusinessByBusinessId(orders.getBusinessId());
        return new OrdersBusinessVO(businessVO.getBusinessName(),
                businessVO.getDeliveryPrice(), orders.getOrderTotal());
    }

    /**
     * 根据订单ID获取订单中的食品信息
     * 此方法从订单详情中提取食品信息，并将其格式化为一个包含食品详情和数量的列表
     * @param orderId 订单ID，用于查询订单中的食品信息
     * @return 返回一个OrdersFoodVO对象列表，每个对象包含食品名称、图片、价格和数量
     */
    @Override
    public List<OrdersFoodVO> getOrdersFoodInfo(Long orderId) {
        List<OrdersFoodVO> ordersFoodVOList = new ArrayList<>();
        Map<Long, Integer> foodMapInfo = orderDetailedService.getFoodInfoByOrderId(orderId);

        for (Map.Entry<Long, Integer> entry : foodMapInfo.entrySet()) {
            Long foodId = entry.getKey();
            Integer quantity = entry.getValue();
            FoodVO foodVO = foodService.getFoodByFoodId(foodId);
            if (foodVO != null) {
                OrdersFoodVO ordersFoodVO = new OrdersFoodVO();
                ordersFoodVO.setFoodName(foodVO.getFoodName());
                ordersFoodVO.setFoodImg(foodVO.getFoodImg());
                ordersFoodVO.setFoodPrice(foodVO.getFoodPrice());
                ordersFoodVO.setQuantity(quantity);
                ordersFoodVOList.add(ordersFoodVO);
            }
        }
        return ordersFoodVOList;
    }
}
