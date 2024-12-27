package ynu.jackielin.elm.service;

import com.baomidou.mybatisplus.extension.service.IService;
import ynu.jackielin.elm.dto.request.CartListRO;
import ynu.jackielin.elm.dto.request.CartSaveRO;
import ynu.jackielin.elm.dto.request.CartUpdateRO;
import ynu.jackielin.elm.dto.response.CartVO;
import ynu.jackielin.elm.entity.po.Cart;

import java.util.List;

public interface CartService extends IService<Cart> {

    List<CartVO> listCart(CartListRO ro);

    Integer saveCart(CartSaveRO ro);

    Integer updateCart(CartUpdateRO ro);

    Integer removeCart(CartSaveRO ro);
}
