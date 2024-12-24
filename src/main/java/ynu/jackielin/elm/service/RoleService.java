package ynu.jackielin.elm.service;

import com.baomidou.mybatisplus.extension.service.IService;
import ynu.jackielin.elm.entity.po.Role;

public interface RoleService extends IService<Role> {

    Role findRoleByRID(long rid);
}
