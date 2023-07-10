package com.register.shiro;

import com.register.model.pojo.LoginUser;
import com.register.model.pojo.Permission;
import com.register.model.pojo.Role;
import com.register.service.LoginUserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

public class MyRealm extends AuthorizingRealm {

    @Autowired
    private LoginUserService loginUserService;

    /**
     * 授权
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String lu = principalCollection.getPrimaryPrincipal().toString();
        LoginUser loginUser = loginUserService.getPermission(lu);
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        for (Role role : loginUser.getRole()) {
            info.addRole(role.getRoleName());
            for (Permission permission : role.getPermissions()) {
                info.addStringPermission(permission.getPermissionName());
            }
        }
        return info;
    }

    /**
     * 认证
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        if (!StringUtils.hasText(authenticationToken.getPrincipal().toString())) {
            return null;
        }
        String lu = authenticationToken.getPrincipal().toString();
        LoginUser loginUser = loginUserService.getLoginUser(lu);
        if (loginUser == null) {
            return null;
        } else {
            SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(loginUser.getLoginUser(), loginUser.getPassword(), ByteSource.Util.bytes(loginUser.getSalt()), this.getName());
            return info;
        }
    }
}
