package ynu.jackielin.elm.controller;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ynu.jackielin.elm.dto.response.BusinessVO;
import ynu.jackielin.elm.service.BusinessService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/business")
public class BusinessController {

    @Resource
    BusinessService businessService;

    @GetMapping("/get-all-categories")
    public Map<Integer, String> getAllCategories() {
        List<Integer> categories = businessService.getAllCategories();
        Map<Integer, String> categoryMap = getCategoryMap();
        Map<Integer, String> result = new HashMap<>();
        for (Integer category : categories) {
            if (categoryMap.containsKey(category)) {
                result.put(category, categoryMap.get(category));
            }
        }
        return result;
    }

    @GetMapping("/get-recommend-business")
    public List<BusinessVO> getRecommendBusiness() {
        return businessService.getRecommendBusiness();
    }

    @GetMapping("/get-business-by-orderTypeId")
    public List<BusinessVO> listBusinessByOrderTypeId(@RequestParam Integer orderTypeId) {
        return businessService.listBusinessByOrderTypeId(orderTypeId);
    }

    @GetMapping("/get-business-by-businessId")
    public BusinessVO listBusinessByBusinessId(@RequestParam Long businessId) {
        return businessService.listBusinessByBusinessId(businessId);
    }

    @GetMapping("/get-delivery-price")
    public Double getDeliveryPriceByBusinessId(Long businessId) {
        return businessService.getDeliveryPriceByBusinessId(businessId);
    }

    /**
     * 获取点餐分流ID和类型名称的映射
     *
     * @return 一个包含订单类型ID和类型名称的映射
     */
    private Map<Integer, String> getCategoryMap() {
        Map<Integer, String> categoryMap = new HashMap<>();
        categoryMap.put(1, "美食");
        categoryMap.put(2, "早餐");
        categoryMap.put(3, "跑腿代购");
        categoryMap.put(4, "汉堡披萨");
        categoryMap.put(5, "甜品饮品");
        categoryMap.put(6, "速食简餐");
        categoryMap.put(7, "地方小吃");
        categoryMap.put(8, "米粉面馆");
        categoryMap.put(9, "包子粥铺");
        categoryMap.put(10, "炸鸡炸串");
        return categoryMap;
    }
}
