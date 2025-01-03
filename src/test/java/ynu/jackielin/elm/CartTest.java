package ynu.jackielin.elm;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import ynu.jackielin.elm.dto.request.CartListRO;
import ynu.jackielin.elm.dto.request.CartSaveRO;
import ynu.jackielin.elm.dto.request.CartUpdateRO;
import ynu.jackielin.elm.service.CartService;
import ynu.jackielin.elm.utils.Pair;

import java.util.Map;

@SpringBootTest
public class CartTest {

    @Resource
    CartService cartService;

    CartListRO cartListRO = new CartListRO(1L, 1L);

    CartSaveRO cartSaveRO = new CartSaveRO(1L, 1L, 4L);

    CartUpdateRO cartUpdateRO = new CartUpdateRO(1L, 1L, 4L, 2);

    @Test
    void test1() {
        cartService.listCart(cartListRO).forEach(System.out::println);
    }

    @Test
    void test2() {
        System.out.println(cartService.saveCart(cartSaveRO));
    }

    @Test
    void test3() {
        System.out.println(cartService.updateCart(cartUpdateRO));
    }

    @Test
    void test4() {
        CartSaveRO ro = new CartSaveRO(1L, 1L, 2L);
        System.out.println(cartService.removeCart(ro));
    }

    @Test
    void test5() {
        System.out.println(cartService.getCartQuantity(1L));
    }

    @Test
    void test6() {
        Map<Long, Pair<Long, Integer>> cartMap = cartService.getCartMap(1L, 2L);
        for (Map.Entry<Long, Pair<Long, Integer>> entry : cartMap.entrySet()) {
            Long cartId = entry.getKey();
            Pair<Long, Integer> pair = entry.getValue();
            System.out.println("Cart ID: " + cartId + ", Food ID: " + pair.getFirst() + ", Quantity: " + pair.getSecond());
        }
    }

    @Test
    void test7() {
        System.out.println(cartService.deleteByCartId(18L));
    }
}
