package com.example.onlinstudy.service;

import com.example.onlinstudy.dao.MyInfoDao;
import com.example.onlinstudy.entity.MyInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MyInfoService {
    @Autowired
    MyInfoDao myInfoDao;

    public void addInfo(MyInfo myInfo){
        final int count = 0;
        String id = String.valueOf(UUID.randomUUID());
        myInfo.setMainid(id);
        Date date = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String time = dateFormat.format(date);
        myInfo.setCreateTime(time);
        myInfo.setUpdateTime(time);
        myInfo.setPinglun(count);
        myInfo.setDianzan(count);
        myInfoDao.save(myInfo);
    }

    public List<MyInfo> findAll(){
        return myInfoDao.findAll();
    }

    public void updateInfo(MyInfo myInfo){
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyy-MM-dd hh:mm:ss");
        String time = dateFormat.format(date);
        myInfo.setUpdateTime(time);
        myInfoDao.save(myInfo);
    }

    public Optional<MyInfo> findById(String id){
        return myInfoDao.findById(id);
    }

    public List<MyInfo> findByCreateUser(String username){
        return myInfoDao.findByCreateUser(username);
    }

    public void deleteById(String mainid){
        myInfoDao.deleteById(mainid);
    }
}
