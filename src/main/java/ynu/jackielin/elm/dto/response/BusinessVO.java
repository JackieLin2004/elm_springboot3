package ynu.jackielin.elm.dto.response;

import lombok.Data;

@Data
public class BusinessVO {
    Long businessId;
    String businessName;
    String businessExplain;
    String businessImg;
    Double startPrice;
    Double deliveryPrice;
}
