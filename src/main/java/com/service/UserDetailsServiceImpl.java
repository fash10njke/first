package com.service;

import com.entity.User;
import com.entity.enums.UserRoleEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException{
        UserDetails userDetails;
         // с помощью нашего сервиса UserService получаем User
        for (Map.Entry<String, String> entry : UserList.getUserList().entrySet()) {
           if (entry.getKey().equals(email)){
               User user = new User();
               user.setLogin(email);
               user.setPassword(UserList.getUserList().get(email));
               Set<GrantedAuthority> roles = new HashSet();
               roles.add(new SimpleGrantedAuthority(UserRoleEnum.ADMIN.name()));
               userDetails =
                       new org.springframework.security.core.userdetails.User(user.getLogin(),
                               user.getPassword(),
                               roles);
               return userDetails;
           }
        }
        // указываем роли для этого пользователя
        // на основании полученных данных формируем объект UserDetails
        // который позволит проверить введенный пользователем логин и пароль
        // и уже потом аутентифицировать пользователя
        return null;
    }


}
