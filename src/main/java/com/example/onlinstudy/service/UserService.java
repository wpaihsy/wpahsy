package com.example.onlinstudy.service;

import com.example.onlinstudy.dao.UserDAO;
import com.example.onlinstudy.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    UserDAO userDAO;

    public List<User> findAll(){
        return userDAO.findAll();
    }

    /**
     * 注册
     * @param user
     */
    public void register(User user){
        String id = String.valueOf(UUID.randomUUID());
        user.setId(id);
        String username = user.getUsername();
        String password = user.getPassword();
        user.setUsername(username);
        user.setPassword(password);
        System.out.println("id为："+id);
        Date date = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String time = dateFormat.format(date);
        System.out.println("时间："+time);
        user.setCreatetime(time);
        user.setUpdatetime(time);
        user.setStatus(1);
        userDAO.save(user);
    }

    /**
     * 通过姓名查找
     * @param username
     * @return
     */
    public List<User> findByName(String username){
        return userDAO.findByUsername(username);
    }

    /**
     * 用户登录
     * @param username
     * @param password
     * @return
     */
    public List<User> login(String username,String password){
        return userDAO.findByUsernameAndPassword(username,password);
    }

    public void updateUser(User user){
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyy-MM-dd hh:mm:ss");
        String time = dateFormat.format(date);
        user.setUpdatetime(time);
        userDAO.save(user);
    }

}
