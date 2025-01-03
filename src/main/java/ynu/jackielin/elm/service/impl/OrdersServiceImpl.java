package ynu.jackielin.elm.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import ynu.jackielin.elm.dto.request.OrdersRO;
import ynu.jackielin.elm.entity.po.Orders;
import ynu.jackielin.elm.mapper.OrdersMapper;
import ynu.jackielin.elm.service.OrderDetailedService;
import ynu.jackielin.elm.service.OrdersService;

import java.time.LocalDateTime;

@Service
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders> implements OrdersService {

    @Resource
    OrderDetailedService orderDetailedService;

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
}
