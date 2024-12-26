package ynu.jackielin.elm.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import ynu.jackielin.elm.dto.response.BusinessVO;
import ynu.jackielin.elm.entity.po.Business;
import ynu.jackielin.elm.mapper.BusinessMapper;
import ynu.jackielin.elm.service.BusinessService;
import ynu.jackielin.elm.utils.Proxy;

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

    /**
     * 获取推荐商家列表
     *
     * @return 一个包含推荐商家信息的列表，列表中的元素是按照商家ID升序排列的前6个商家
     */
    @Override
    public List<BusinessVO> getRecommendBusiness() {
        QueryWrapper<Business> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByAsc("businessId")
                .last("LIMIT 6");
        List<Business> businesses = baseMapper.selectList(queryWrapper);
        return businesses.stream()
                .map(Proxy::business2VO)
                .collect(Collectors.toList());
    }

    /**
     * 根据类型ID查询商家列表
     *
     * @param orderTypeId 订单类型ID，为0时查询所有商家
     * @return 商家列表，列表中的元素是BusinessVO对象
     */
    @Override
    public List<BusinessVO> listBusinessByOrderTypeId(Integer orderTypeId) {
        if (orderTypeId == 0) {
            List<Business> businesses = baseMapper.selectList(null);
            return businesses.stream().map(Proxy::business2VO).collect(Collectors.toList());
        } else {
            QueryWrapper<Business> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("orderTypeId", orderTypeId);
            List<Business> businesses = baseMapper.selectList(queryWrapper);
            return businesses.stream().map(Proxy::business2VO).collect(Collectors.toList());
        }
    }

    /**
     * 根据类型ID查询商家列表
     *
     * @param businessId 商家ID
     * @return 商家BusinessVO对象
     */
    @Override
    public BusinessVO listBusinessByBusinessId(Long businessId) {
        Business business = baseMapper.selectById(businessId);
        if (business == null) {
            return null;
        }
        return Proxy.business2VO(business);
    }
}
