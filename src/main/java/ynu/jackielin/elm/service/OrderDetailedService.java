package ynu.jackielin.elm.service;

import com.baomidou.mybatisplus.extension.service.IService;
import ynu.jackielin.elm.entity.po.OrderDetailed;

import java.util.Map;

public interface OrderDetailedService extends IService<OrderDetailed> {

    Integer saveInOrderDetailed(Long orderId, Long foodId, Integer quantity);

    boolean addInOrderDetailed(Long userId, Long businessId, Long orderId);

    Map<Long, Integer> getFoodInfoByOrderId(Long orderId);
}
