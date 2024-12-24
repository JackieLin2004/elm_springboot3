package ynu.jackielin.elm.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import ynu.jackielin.elm.entity.po.AccountRole;
import ynu.jackielin.elm.mapper.AccountRoleMapper;
import ynu.jackielin.elm.service.AccountRoleService;

@Service
public class AccountRoleServiceImpl extends ServiceImpl<AccountRoleMapper, AccountRole>
        implements AccountRoleService {
    @Override
    public AccountRole findRIDByUID(long uid) {
        return this.query()
                .eq("userId", uid)
                .one();
    }

    @Override
    public boolean registerAccountRole(long uid) {
        AccountRole accountRole = new AccountRole(null, uid, 2L);
        return this.save(accountRole);
    }
}
