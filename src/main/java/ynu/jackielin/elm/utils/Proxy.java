package ynu.jackielin.elm.utils;

import ynu.jackielin.elm.dto.response.AccountVO;
import ynu.jackielin.elm.dto.response.BusinessVO;
import ynu.jackielin.elm.dto.response.CartVO;
import ynu.jackielin.elm.dto.response.FoodVO;
import ynu.jackielin.elm.entity.po.Account;
import ynu.jackielin.elm.entity.po.Business;
import ynu.jackielin.elm.entity.po.Cart;
import ynu.jackielin.elm.entity.po.Food;

/**
 * VO对象转换工具
 */
public class Proxy {

    /**
     * 将 Business 实体类转换为 BusinessVO
     * @param business 实体类对象
     * @return 转换后的 VO 对象
     */
    public static BusinessVO business2VO(Business business) {
        if (business == null) {
            return null;
        }
        BusinessVO vo = new BusinessVO();
        vo.setBusinessId(business.getBusinessId());
        vo.setBusinessName(business.getBusinessName());
        vo.setBusinessExplain(business.getBusinessExplain());
        vo.setBusinessImg(business.getBusinessImg());
        vo.setStartPrice(business.getStartPrice());
        vo.setDeliveryPrice(business.getDeliveryPrice());
        return vo;
    }

    /**
     * 将 Food 实体类转换为 FoodVO
     * @param food 实体类对象
     * @return 转换后的 VO 对象
     */
    public static FoodVO food2VO(Food food) {
        if (food == null) {
            return null;
        }
        FoodVO vo = new FoodVO();
        vo.setFoodId(food.getFoodId());
        vo.setFoodName(food.getFoodName());
        vo.setFoodExplain(food.getFoodExplain());
        vo.setFoodImg(food.getFoodImg());
        vo.setFoodPrice(food.getFoodPrice());
        return vo;
    }

    /**
     * 将 Account 实体类转换为 AccountVO
     * @param account 实体类对象
     * @return 转换后的 VO 对象
     */
    public static AccountVO account2VO(Account account) {
        if (account == null) {
            return null;
        }
        AccountVO vo = new AccountVO();
        vo.setUserId(account.getUserId());
        vo.setUserName(account.getUserName());
        vo.setUserSex(account.getUserSex());
        vo.setEmail(account.getEmail());
        vo.setUserImg(account.getUserImg());
        return vo;
    }

    /**
     * 将 Cart 实体类转换为 CartVO
     * @param cart 实体类对象
     * @return 转换后的 VO 对象
     */
    public static CartVO cart2VO(Cart cart) {
        if (cart == null) {
            return null;
        }
        CartVO vo = new CartVO();
        vo.setCartId(cart.getCartId());
        vo.setFoodId(cart.getFoodId());
        vo.setQuantity(cart.getQuantity());
        return vo;
    }
}
