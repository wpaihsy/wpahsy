package com.example.onlinstudy.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "user")
public class User {

    @Id
    @Column(name = "id",nullable = false)
    private String id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "sex")
    private String sex;

    @Column(name = "age")
    private Integer age;

    @Column(name = "phonenum")
    private String phonenum;

    @Column(name = "email")
    private String email;

    @Column(name = "qianming")
    private String qianming;

    @Column(name = "tips")
    private String tips;

    @Column(name = "createtime")
    private String createtime;

    @Column(name = "updatetime")
    private String updatetime;

    @Column(name = "status")
    private Integer status;

}
