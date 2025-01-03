package ynu.jackielin.elm.service;

import com.baomidou.mybatisplus.extension.service.IService;
import ynu.jackielin.elm.dto.request.CartListRO;
import ynu.jackielin.elm.dto.request.CartSaveRO;
import ynu.jackielin.elm.dto.request.CartUpdateRO;
import ynu.jackielin.elm.dto.response.CartQuantityVO;
import ynu.jackielin.elm.dto.response.CartVO;
import ynu.jackielin.elm.entity.po.Cart;
import ynu.jackielin.elm.utils.Pair;

import java.util.List;
import java.util.Map;

public interface CartService extends IService<Cart> {

    List<CartVO> listCart(CartListRO ro);

    Integer saveCart(CartSaveRO ro);

    Integer updateCart(CartUpdateRO ro);

    Integer removeCart(CartSaveRO ro);

    List<CartQuantityVO> getCartQuantity(Long userId);

    Map<Long, Pair<Long, Integer>> getCartMap(Long userId, Long businessId);

    Integer deleteByCartId(Long cartId);
}
