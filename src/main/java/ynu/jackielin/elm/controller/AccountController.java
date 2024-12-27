package ynu.jackielin.elm.controller;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ynu.jackielin.elm.dto.response.AccountVO;
import ynu.jackielin.elm.service.AccountService;

@RestController
@RequestMapping("/api/account")
public class AccountController {

    @Resource
    AccountService accountService;

    @GetMapping("/get-account-by-userId")
    public AccountVO getAccountByUserId(Long userId) {
        return accountService.getAccountByUserId(userId);
    }
}
