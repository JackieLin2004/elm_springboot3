package ynu.jackielin.elm.service;

import com.baomidou.mybatisplus.extension.service.IService;
import ynu.jackielin.elm.dto.response.BusinessVO;
import ynu.jackielin.elm.entity.po.Business;

import java.util.List;

public interface BusinessService extends IService<Business> {

    List<Integer> getAllCategories();

    List<BusinessVO> getRecommendBusiness();

    List<BusinessVO> listBusinessByOrderTypeId(Integer orderTypeId);

    BusinessVO listBusinessByBusinessId(Long businessId);

    Double getDeliveryPriceByBusinessId(Long businessId);
}
