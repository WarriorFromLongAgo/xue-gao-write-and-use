package com.xuegao.springsecuritydemo1.config.demo1;

import com.xuegao.springsecuritydemo1.domain.po.UserInfo;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyUserDetailService implements UserDetailsService {
    // @Autowired
    // private UserDao userDao;

    /**
     * 这里通过框架传过来的username可以在数据库查询到用户信息,用于与用户输入的密码匹配
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //查询条件
        // QueryWrapper<User> wrapper = new QueryWrapper<>();
        // wrapper.eq("username", username);
        // User user = userDao.selectOne(wrapper);

        UserInfo userInfo = null;
        if ("xuegao".equals(username)) {
            userInfo = new UserInfo();
            // userInfo.setUsername("username");
            userInfo.setPassword("password123456");
        }


        if (userInfo == null) {
            //用户不存在(实际业务在验证码发送时就校验, 这里暂时这样写)
            throw new UsernameNotFoundException("用户名不存在");
        } else {
            // 用户存在
            String password = userInfo.getPassword();
            // 赋予用户的权限 @TODO 这里也是需要数据库查询才能赋予权限,暂时写死
            List<GrantedAuthority> auths =
                    AuthorityUtils.commaSeparatedStringToAuthorityList("role");
            // 第二个参数是数据库被加密后的密码 @TODO 后期改为自定义的MD5加密(这里因为数据库数据没有加密,所以暂时不管)
            return new User(username, password, auths);
        }
    }
}
