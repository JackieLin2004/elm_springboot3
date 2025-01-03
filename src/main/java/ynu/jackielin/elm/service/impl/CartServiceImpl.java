package ynu.jackielin.elm.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import ynu.jackielin.elm.dto.request.CartListRO;
import ynu.jackielin.elm.dto.request.CartSaveRO;
import ynu.jackielin.elm.dto.request.CartUpdateRO;
import ynu.jackielin.elm.dto.response.CartQuantityVO;
import ynu.jackielin.elm.dto.response.CartVO;
import ynu.jackielin.elm.entity.po.Cart;
import ynu.jackielin.elm.mapper.CartMapper;
import ynu.jackielin.elm.service.CartService;
import ynu.jackielin.elm.utils.Proxy;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CartServiceImpl extends ServiceImpl<CartMapper, Cart> implements CartService {

    @Resource
    CartMapper cartMapper;

    /**
     * 根据用户ID和商家ID查询购物车列表
     *
     * @param ro 包含用户ID和商家ID的请求对象
     * @return 购物车列表的视图对象列表
     * @throws IllegalArgumentException 如果用户ID或商家ID为空
     */
    @Override
    public List<CartVO> listCart(CartListRO ro) {
        if (ro == null || ro.getUserId() == null || ro.getBusinessId() == null) {
            throw new IllegalArgumentException("User ID and Business ID cannot be null");
        }
        QueryWrapper<Cart> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userId", ro.getUserId())
                .eq("businessId", ro.getBusinessId());
        List<Cart> carts = baseMapper.selectList(queryWrapper);
        return carts.stream()
                .map(Proxy::cart2VO)
                .collect(Collectors.toList());
    }

    /**
     * 保存购物车信息
     *
     * @param ro 包含用户ID、商家ID和食品ID的请求对象
     * @return 插入操作影响的行数
     * @throws IllegalArgumentException 如果用户ID、商家ID或食品ID为空
     */
    @Override
    public Integer saveCart(CartSaveRO ro) {
        if (ro == null || ro.getUserId() == null || ro.getBusinessId() == null || ro.getFoodId() == null) {
            throw new IllegalArgumentException("User ID, Business ID, and Food ID cannot be null");
        }
        Cart cart = new Cart(null, ro.getFoodId(), ro.getBusinessId(), ro.getUserId(), 1);
        return baseMapper.insert(cart);
    }

    /**
     * 更新购物车信息
     *
     * @param ro 包含用户ID、商家ID、食品ID和数量的请求对象
     * @return 更新操作影响的行数
     * @throws IllegalArgumentException 如果用户ID、商家ID、食品ID或数量为空，或者数量为负数
     */
    @Override
    public Integer updateCart(CartUpdateRO ro) {
        if (ro == null || ro.getUserId() == null || ro.getBusinessId() == null || ro.getFoodId() == null || ro.getQuantity() == null) {
            throw new IllegalArgumentException("User ID, Business ID, Food ID, and Quantity cannot be null");
        }
        if (ro.getQuantity() < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative");
        }
        UpdateWrapper<Cart> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("userId", ro.getUserId())
                .eq("businessId", ro.getBusinessId())
                .eq("foodId", ro.getFoodId())
                .set("quantity", ro.getQuantity());
        return baseMapper.update(null, updateWrapper);
    }

    /**
     * 从购物车中移除商品
     *
     * @param ro 包含用户ID、商家ID和食品ID的请求对象
     * @return 删除操作影响的行数
     * @throws IllegalArgumentException 如果用户ID、商家ID或食品ID为空
     */
    @Override
    public Integer removeCart(CartSaveRO ro) {
        if (ro == null || ro.getUserId() == null || ro.getBusinessId() == null || ro.getFoodId() == null) {
            throw new IllegalArgumentException("User ID, Business ID, and Food ID cannot be null");
        }
        QueryWrapper<Cart> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userId", ro.getUserId())
                .eq("businessId", ro.getBusinessId())
                .eq("foodId", ro.getFoodId());
        return baseMapper.delete(queryWrapper);
    }

    /**
     * 根据用户ID获取购物车商品数量信息
     * 此方法通过调用cartMapper的getCartQuantityByUserId方法来获取用户购物车的商品数量信息
     * 主要用于在用户界面展示购物车商品总数，以便用户了解购物车内的商品情况
     *
     * @param userId 用户ID，用于查询特定用户的购物车商品数量信息
     * @return 返回一个CartQuantityVO对象列表，每个对象包含特定用户购物车的商品数量信息
     */
    @Override
    public List<CartQuantityVO> getCartQuantity(Long userId) {
        return cartMapper.getCartQuantityByUserId(userId);
    }
}
