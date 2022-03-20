package ann.web.spring.loginForm.service;

import ann.web.spring.loginForm.dao.UserDetailsDao;
import ann.web.spring.loginForm.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

public class UserDetailsServiceImp implements UserDetailsService{
    @Autowired
    private UserDetailsDao userDetailsDao;

    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(String name) {
        User user = userDetailsDao.findUserByUsername(name);
        org.springframework.security.core.userdetails.User.UserBuilder builder = null;
        if(user != null){
            builder = org.springframework.security.core.userdetails.User.withUsername(name);
            builder.disabled(!user.isEnabled());
            builder.password(user.getPassword());
            String[] authorities = user.getAuthorities()
                    .stream().map(a -> a.getAuthority()).toArray(String[]::new);

            builder.authorities(authorities);
        } else {
            throw new UsernameNotFoundException("User not found.");
        }
        return builder.build();
    }
}
