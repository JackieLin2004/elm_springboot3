package ynu.jackielin.elm.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import ynu.jackielin.elm.entity.po.Orders;

@Mapper
public interface OrdersMapper extends BaseMapper<Orders> {
}
