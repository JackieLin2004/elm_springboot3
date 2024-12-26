package ynu.jackielin.elm.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import ynu.jackielin.elm.entity.po.Business;
import ynu.jackielin.elm.mapper.BusinessMapper;
import ynu.jackielin.elm.service.BusinessService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BusinessServiceImpl extends ServiceImpl<BusinessMapper, Business> implements BusinessService {

    /**
     * 获取所有的点餐分类
     *
     * @return 一个包含所有订单类型ID的列表，列表中的元素是唯一且有序的
     */
    @Override
    public List<Integer> getAllCategories() {
        QueryWrapper<Business> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("orderTypeId");
        List<Object> orderTypeIds = baseMapper.selectObjs(queryWrapper);
        return orderTypeIds.stream()
                .map(obj -> (Integer) obj).distinct().sorted(Integer::compareTo).collect(Collectors.toList());
    }
}
