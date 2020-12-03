package com.codingyoo.service.Impl;

import com.codingyoo.dao.UserDao;
import com.codingyoo.pojo.UserInfo;
import com.codingyoo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = null;
        try {
            userInfo = userDao.findByUsername(username);
        }catch (Exception e){
            e.printStackTrace();
        }
        //把自己的对象封装成userdetails
        User user = new User(userInfo.getUsername(),"{noop}"+userInfo.getPassword(),getAuthority());
        return user;
    }

    public List<SimpleGrantedAuthority>  getAuthority(){
        ArrayList<SimpleGrantedAuthority> list = new ArrayList<>();
        list.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        return list;
    }
}
