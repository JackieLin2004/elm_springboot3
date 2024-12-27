package ynu.jackielin.elm;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import ynu.jackielin.elm.service.AccountService;

@SpringBootTest
public class AccountTest {

    @Resource
    AccountService accountService;

    @Test
    void test1(){
        System.out.println(accountService.getAccountByUserId(1L));
    }
}
