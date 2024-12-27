package ynu.jackielin.elm.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CartListRO {
    Long userId;
    Long businessId;
}
