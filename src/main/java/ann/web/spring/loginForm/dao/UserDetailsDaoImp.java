package ann.web.spring.loginForm.dao;

import ann.web.spring.loginForm.entity.User;
import com.mysql.cj.xdevapi.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class UserDetailsDaoImp implements UserDetailsDao{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public User findUserByUsername(String name) {
        return sessionFactory.getCurrentSession().get(User.class, name);
    }
}
