package ynu.jackielin.elm;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import ynu.jackielin.elm.service.FoodService;

@SpringBootTest
public class FoodTest {
    @Resource
    FoodService foodService;

    @Test
    void test1(){
        foodService.listFoodByBusinessId(1L).forEach(System.out::println);
    }
}
