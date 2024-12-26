package ynu.jackielin.elm.controller;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ynu.jackielin.elm.dto.response.FoodVO;
import ynu.jackielin.elm.service.FoodService;

import java.util.List;

@RestController
@RequestMapping("/api/food")
public class FoodController {

    @Resource
    FoodService foodService;

    @GetMapping("/list-food-by-BusinessId")
    public List<FoodVO> listFoodByBusinessId(Long businessId) {
        return foodService.listFoodByBusinessId(businessId);
    }
}
