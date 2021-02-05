package com.example.onlinstudy.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "myinfo")
public class MyInfo {

    @Id
    @Column(name = "main_id",nullable = false)
    private String mainid;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "create_time")
    private String createTime;

    @Column(name = "create_user")
    private String createUser;

    @Column(name = "pinglun")
    private Integer pinglun;

    @Column(name = "dianzan")
    private Integer dianzan;

    @Column(name = "update_time")
    private String updateTime;
}
