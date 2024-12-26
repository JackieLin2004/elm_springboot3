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
}
