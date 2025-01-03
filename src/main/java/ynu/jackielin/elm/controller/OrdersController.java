package ynu.jackielin.elm.controller;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ynu.jackielin.elm.dto.request.OrdersRO;
import ynu.jackielin.elm.service.OrdersService;

@RestController
@RequestMapping("/api/orders")
public class OrdersController {

    @Resource
    OrdersService ordersService;

    @PostMapping("/create-orders")
    public Long createOrders(@RequestBody OrdersRO ro) {
        return ordersService.createOrders(ro);
    }
}
