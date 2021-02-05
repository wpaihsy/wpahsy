package com.example.onlinstudy.dao;

import com.example.onlinstudy.entity.MyInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

@Mapper
public interface MyInfoDao extends JpaRepository<MyInfo,String >, JpaSpecificationExecutor<MyInfo> {

    List<MyInfo> findByCreateUser(String username);
}
