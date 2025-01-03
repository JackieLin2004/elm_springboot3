package ynu.jackielin.elm.service;

import com.baomidou.mybatisplus.extension.service.IService;
import ynu.jackielin.elm.dto.request.OrdersRO;
import ynu.jackielin.elm.entity.po.Orders;

public interface OrdersService extends IService<Orders> {

    Long createOrders(OrdersRO ro);
}
