package ynu.jackielin.elm.service;

import com.baomidou.mybatisplus.extension.service.IService;
import ynu.jackielin.elm.entity.po.AccountRole;

public interface AccountRoleService extends IService<AccountRole> {

    AccountRole findRIDByUID(long uid);

    boolean registerAccountRole(long uid);
}
