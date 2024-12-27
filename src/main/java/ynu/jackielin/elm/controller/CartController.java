package ynu.jackielin.elm.controller;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ynu.jackielin.elm.dto.request.CartListRO;
import ynu.jackielin.elm.dto.request.CartSaveRO;
import ynu.jackielin.elm.dto.request.CartUpdateRO;
import ynu.jackielin.elm.dto.response.CartVO;
import ynu.jackielin.elm.service.CartService;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Resource
    CartService cartService;

    @PostMapping("/list-cart")
    public List<CartVO> listCart(@RequestBody CartListRO ro) {
        return cartService.listCart(ro);
    }

    @PostMapping("/save-cart")
    public int saveCart(@RequestBody CartSaveRO ro) {
        return cartService.saveCart(ro);
    }

    @PostMapping("/update-cart")
    public Integer updateCart(@RequestBody CartUpdateRO ro) {
        return cartService.updateCart(ro);
    }

    @PostMapping("/remove-cart")
    public Integer removeCart(@RequestBody CartSaveRO ro) {
        return cartService.removeCart(ro);
    }
}
