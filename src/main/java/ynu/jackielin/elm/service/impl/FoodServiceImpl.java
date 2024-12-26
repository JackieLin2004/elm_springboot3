package ynu.jackielin.elm.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import ynu.jackielin.elm.dto.response.FoodVO;
import ynu.jackielin.elm.entity.po.Food;
import ynu.jackielin.elm.mapper.FoodMapper;
import ynu.jackielin.elm.service.FoodService;
import ynu.jackielin.elm.utils.Proxy;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FoodServiceImpl extends ServiceImpl<FoodMapper, Food> implements FoodService {

    /**
     * 根据商家ID查询食品列表
     *
     * @param businessId 商家ID，不能为空
     * @return 食品列表，列表中的元素是FoodVO对象
     * @throws IllegalArgumentException 如果businessId为空，则抛出此异常
     */
    @Override
    public List<FoodVO> listFoodByBusinessId(Long businessId) {
        if (businessId == null) {
            throw new IllegalArgumentException("Business ID cannot be null");
        }
        QueryWrapper<Food> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("businessId", businessId);
        List<Food> foods = baseMapper.selectList(queryWrapper);
        return foods.stream()
                .map(Proxy::food2VO)
                .collect(Collectors.toList());
    }
}
