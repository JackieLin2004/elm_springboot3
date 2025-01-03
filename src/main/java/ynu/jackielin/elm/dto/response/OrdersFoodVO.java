package ynu.jackielin.elm.dto.response;

import lombok.Data;

@Data
public class OrdersFoodVO {
    String foodName;
    String foodImg;
    Double foodPrice;
    Integer quantity;
}
