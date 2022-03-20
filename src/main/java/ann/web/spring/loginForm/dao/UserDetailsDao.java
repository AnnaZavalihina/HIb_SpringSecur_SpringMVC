package ann.web.spring.loginForm.dao;

import ann.web.spring.loginForm.entity.User;

public interface UserDetailsDao {
    User findUserByUsername(String name);
}
