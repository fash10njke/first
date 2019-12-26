package com.service;

import com.entity.User;
import com.entity.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDao;

    @Override
    public User getUser(String login) {
        User user = new User();
        //user.setLogin(login);
        //user.setPassword("7110eda4d09e062aa5e4a390b0a572ac0d2c0220");

        return user;
    }

    @Override
    public String encoderPassword(String password) {
        ShaPasswordEncoder encoder = new ShaPasswordEncoder();
        String encodePassword = encoder.encodePassword(password,null);
        return encodePassword;
    }

    @Override
    @Transactional
    public void add(User user) {
userDao.add(user);
    }

    @Override
    @Transactional
    public List<User> listUsers() {
        return userDao.listUsers();
    }
}