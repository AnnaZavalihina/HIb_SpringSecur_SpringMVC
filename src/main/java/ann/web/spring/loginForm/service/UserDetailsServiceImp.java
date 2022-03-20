package ann.web.spring.loginForm.service;

import ann.web.spring.loginForm.dao.UserDetailsDao;
import org.springframework.beans.factory.annotation.Autowired;

public class UserDetailsServiceImp implements UserDetailsService{
    @Autowired
    private UserDetailsDao userDetailsDao;

    @Override
    public void loadUserByUsername(String name) {

    }
}
