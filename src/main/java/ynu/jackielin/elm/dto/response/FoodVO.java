package ynu.jackielin.elm.dto.response;

import lombok.Data;

@Data
public class FoodVO {
    Long foodId;
    String foodName;
    String foodExplain;
    String foodImg;
    Double foodPrice;
}
