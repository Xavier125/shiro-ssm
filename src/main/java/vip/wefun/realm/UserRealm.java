package vip.wefun.realm;

import org.apache.shiro.SecurityUtils;
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
import vip.wefun.pojo.User;
import vip.wefun.service.PermissionService;
import vip.wefun.service.UserService;

import java.util.HashSet;
import java.util.Set;

public class UserRealm extends AuthorizingRealm {
    @Autowired
    private UserService userServiceImpl;
    @Autowired
    private PermissionService permissionServiceImpl;


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println( "================授权======================" );
        User user = (User) principals.getPrimaryPrincipal();
//        Set<String> permissionList = permissionServiceImpl.getPermissionByUserId( user.getId() );
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addStringPermission( "menu:list" );
        System.out.println( info.getStringPermissions() );
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println( "================认证======================" );
        String username = token.getPrincipal().toString();
        User user = userServiceImpl.getUserByUsername( username );
        System.out.println( getName() );
        System.out.println( user );
        return new SimpleAuthenticationInfo( user, user.getPassword(), ByteSource.Util.bytes( user.getSalt() ), getName() );
    }
}
