package ynu.jackielin.elm;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import ynu.jackielin.elm.service.BusinessService;

@SpringBootTest
public class BusinessTest {
    @Resource
    BusinessService businessService;

    @Test
    void test1(){
        businessService.getAllCategories().forEach(System.out::println);
    }

    @Test
    void test2(){
        businessService.getRecommendBusiness().forEach(System.out::println);
    }

    @Test
    void test3(){
        businessService.listBusinessByOrderTypeId(0).forEach(System.out::println);
        businessService.listBusinessByOrderTypeId(1).forEach(System.out::println);
    }

    @Test
    void test4(){
        System.out.println(businessService.listBusinessByBusinessId(1L));
    }

    @Test
    void test5(){
        System.out.println(businessService.getDeliveryPriceByBusinessId(2L));
    }
}
