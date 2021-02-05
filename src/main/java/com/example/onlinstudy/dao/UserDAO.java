package com.example.onlinstudy.dao;

import com.example.onlinstudy.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

@Mapper
public interface UserDAO  extends JpaRepository<User,String >, JpaSpecificationExecutor<User> {

    /**
     * 通过用户名查找
     * @param username
     * @return
     */
    List<User> findByUsername(String username);

    /**
     * 用户登录
     * @param username
     * @param password
     * @return
     */
    List<User> findByUsernameAndPassword(String username,String password);

}
