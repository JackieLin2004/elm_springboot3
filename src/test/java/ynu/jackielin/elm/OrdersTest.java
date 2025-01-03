package ynu.jackielin.elm;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import ynu.jackielin.elm.dto.request.OrdersRO;
import ynu.jackielin.elm.service.OrdersService;

@SpringBootTest
public class OrdersTest {

    @Resource
    OrdersService ordersService;

    OrdersRO ro = new OrdersRO(1L, 1L, 100.0);

    @Test
    void test1() {
        System.out.println(ordersService.createOrders(ro));
    }

    @Test
    void test2() {
        System.out.println(ordersService.getOrdersBusinessInfo(5L));
    }

    @Test
    void test3() {
        ordersService.getOrdersFoodInfo(5L).forEach(System.out::println);
    }
}
