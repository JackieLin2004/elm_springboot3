package ynu.jackielin.elm.entity.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@TableName("cart")
@AllArgsConstructor
public class Cart {
    @TableId(type = IdType.AUTO)
    Long cartId;
    @TableField("foodId")
    Long foodId;
    @TableField("businessId")
    Long businessId;
    @TableField("userId")
    Long userId;
    @TableField("quantity")
    Integer quantity;
}
