package ynu.jackielin.elm.dto.response;

import lombok.Data;

@Data
public class AccountVO {
    Long userId;
    String userName;
    Integer userSex;
    String email;
    String userImg;
}
