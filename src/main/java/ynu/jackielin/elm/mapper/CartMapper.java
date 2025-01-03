package ynu.jackielin.elm.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import ynu.jackielin.elm.dto.response.CartQuantityVO;
import ynu.jackielin.elm.entity.po.Cart;

import java.util.List;

@Mapper
public interface CartMapper extends BaseMapper<Cart> {

    @Select("SELECT businessId, SUM(quantity) as quantity " +
            "FROM cart " +
            "WHERE userId = #{userId} " +
            "GROUP BY businessId")
    List<CartQuantityVO> getCartQuantityByUserId(Long userId);
}
