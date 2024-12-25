package ynu.jackielin.elm.entity.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@TableName("food")
@AllArgsConstructor
public class Food {
    @TableId(type = IdType.AUTO)
    Long foodId;
    @TableField("foodName")
    String foodName;
    @TableField("foodExplain")
    String foodExplain;
    @TableField("foodImg")
    String foodImg;
    @TableField("foodPrice")
    Double foodPrice;
    @TableField("businessId")
    Long businessId;
    @TableField("remarks")
    String remarks;
}
