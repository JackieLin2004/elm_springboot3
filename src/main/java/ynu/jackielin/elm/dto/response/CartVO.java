package ynu.jackielin.elm.dto.response;

import lombok.Data;

@Data
public class CartVO {
    Long cartId;
    Long foodId;
    Integer quantity;
}
