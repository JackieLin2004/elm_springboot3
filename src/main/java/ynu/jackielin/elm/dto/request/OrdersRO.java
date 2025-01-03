package ynu.jackielin.elm.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrdersRO {
    Long userId;
    Long businessId;
    double totalPrice;
}
