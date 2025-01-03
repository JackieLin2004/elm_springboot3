package ynu.jackielin.elm;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import ynu.jackielin.elm.service.OrderDetailedService;

@SpringBootTest
public class OrderDetailedTest {

    @Resource
    OrderDetailedService orderDetailedService;

    @Test
    void test1() {
        System.out.println(orderDetailedService.saveInOrderDetailed(2L, 1L, 1));
    }

    @Test
    void test2() {
        System.out.println(orderDetailedService.addInOrderDetailed(1L, 2L, 2L));
    }
}
