package ynu.jackielin.elm.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import ynu.jackielin.elm.entity.po.Cart;

@Mapper
public interface CartMapper extends BaseMapper<Cart> {
}