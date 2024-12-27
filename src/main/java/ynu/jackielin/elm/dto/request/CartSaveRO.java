package ynu.jackielin.elm.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CartSaveRO {
    Long userId;
    Long businessId;
    Long foodId;
}
