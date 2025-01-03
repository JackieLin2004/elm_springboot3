package ynu.jackielin.elm.entity.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@TableName("orders")
@AllArgsConstructor
@NoArgsConstructor
public class Orders {
    @TableId(type = IdType.AUTO)
    Long orderId;
    @TableField("userId")
    Long userId;
    @TableField("businessId")
    Long businessId;
    @TableField("orderDate")
    String orderDate;
    @TableField("orderTotal")
    Double orderTotal;
    @TableField("daId")
    Long daId;
    @TableField("orderState")
    Integer orderState;
}
