package ynu.jackielin.elm.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrdersBusinessVO {
    String businessName;
    Double deliveryPrice;
    Double totalPrice;
}
