package ynu.jackielin.elm.entity.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@TableName("business")
@AllArgsConstructor
public class Business {
    @TableId(type = IdType.AUTO)
    Long businessId;
    @TableField("businessName")
    String businessName;
    @TableField("businessAddress")
    String businessAddress;
    @TableField("businessExplain")
    String businessExplain;
    @TableField("businessImg")
    String businessImg;
    @TableField("orderTypeId")
    Integer orderTypeId;
    @TableField("startPrice")
    Double startPrice;
    @TableField("deliveryPrice")
    Double deliveryPrice;
    @TableField("remarks")
    String remarks;
}
