package ynu.jackielin.elm.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.security.core.userdetails.UserDetailsService;
import ynu.jackielin.elm.dto.request.ConfirmResetRO;
import ynu.jackielin.elm.dto.request.EmailRegisterRO;
import ynu.jackielin.elm.dto.request.EmailResetRO;
import ynu.jackielin.elm.dto.response.AccountVO;
import ynu.jackielin.elm.entity.po.Account;

public interface AccountService extends IService<Account>, UserDetailsService {

    Account findAccountByUsernameOrEmail(String text);

    String registerEmailVerifyCode(String type, String email, String ip);

    String registerEmailAccount(EmailRegisterRO ro);

    String resetConfirm(ConfirmResetRO ro);

    String resetEmailAccountPassword(EmailResetRO ro);

    AccountVO getAccountByUserId(Long userId);
}
