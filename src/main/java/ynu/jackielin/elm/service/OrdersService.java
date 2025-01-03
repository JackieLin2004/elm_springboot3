package ynu.jackielin.elm.service;

import com.baomidou.mybatisplus.extension.service.IService;
import ynu.jackielin.elm.dto.request.OrdersRO;
import ynu.jackielin.elm.dto.response.OrdersBusinessVO;
import ynu.jackielin.elm.dto.response.OrdersFoodVO;
import ynu.jackielin.elm.entity.po.Orders;

import java.util.List;

public interface OrdersService extends IService<Orders> {

    Long createOrders(OrdersRO ro);

    OrdersBusinessVO getOrdersBusinessInfo(Long orderId);

    List<OrdersFoodVO> getOrdersFoodInfo(Long orderId);
}
