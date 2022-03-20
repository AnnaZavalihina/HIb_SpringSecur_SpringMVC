package ann.web.spring.loginForm.dao;

import ann.web.spring.loginForm.entity.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDetailsDaoImp implements UserDetailsDao{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public User findUserByUsername(String name) {
        return sessionFactory.getCurrentSession().get(User.class,name);
    }
}
