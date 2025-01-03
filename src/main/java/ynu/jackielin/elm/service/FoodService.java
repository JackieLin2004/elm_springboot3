package ynu.jackielin.elm.service;

import com.baomidou.mybatisplus.extension.service.IService;
import ynu.jackielin.elm.dto.response.FoodVO;
import ynu.jackielin.elm.entity.po.Food;

import java.util.List;

public interface FoodService extends IService<Food> {

    List<FoodVO> listFoodByBusinessId(Long businessId);

    FoodVO getFoodByFoodId(Long foodId);
}
