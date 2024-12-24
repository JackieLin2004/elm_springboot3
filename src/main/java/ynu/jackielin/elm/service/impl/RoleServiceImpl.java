package ynu.jackielin.elm.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import ynu.jackielin.elm.entity.po.Role;
import ynu.jackielin.elm.mapper.RoleMapper;
import ynu.jackielin.elm.service.RoleService;

@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {
    @Override
    public Role findRoleByRID(long rid) {
        return this.query()
                .eq("roleId", rid)
                .one();
    }
}
