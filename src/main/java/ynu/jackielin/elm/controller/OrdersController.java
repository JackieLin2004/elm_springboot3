package ynu.jackielin.elm.controller;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import ynu.jackielin.elm.dto.request.OrdersRO;
import ynu.jackielin.elm.dto.response.OrdersBusinessVO;
import ynu.jackielin.elm.dto.response.OrdersFoodVO;
import ynu.jackielin.elm.service.OrdersService;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrdersController {

    @Resource
    OrdersService ordersService;

    @PostMapping("/create-orders")
    public Long createOrders(@RequestBody OrdersRO ro) {
        return ordersService.createOrders(ro);
    }

    @GetMapping("/get-business-info")
    public OrdersBusinessVO getBusinessInfo(Long orderId) {
        return ordersService.getOrdersBusinessInfo(orderId);
    }

    @GetMapping("/get-food-info")
    public List<OrdersFoodVO> getFoodInfo(Long orderId) {
        return ordersService.getOrdersFoodInfo(orderId);
    }
}
