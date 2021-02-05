package com.example.onlinstudy.controller;

import com.example.onlinstudy.entity.User;
import com.example.onlinstudy.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping
public class UserController {

    @Resource
    UserService userService;

    /**
     * 展示所有人员信息
     * @return
     */
    @ResponseBody
    @RequestMapping("/findAll")
    public List<User> findAll(){
        return userService.findAll();
    }

    @RequestMapping("/doregister")
    public String doRegister(User user){
        System.out.println("传过来的值为："+user.getUsername()+user.getPassword());
        String username = user.getUsername();
        int count = findUser(username);
        if (count == 0){
            System.out.println("没有该用户的信息，可以注册！");
            userService.register(user);
            return "login";
        } else {
            System.out.println("此用户已经存在！");
            return "register";
        }
    }

    @RequestMapping("/doLogin")
    public String doLogin(HttpServletRequest request,User user){
        String username = user.getUsername();
        String password = user.getPassword();
        System.out.println("登录用户："+username+password);
        int count = findUser(username);
        if (count == 1){
            System.out.println("登录成功！");
            HttpSession session = request.getSession();
            session.setAttribute("username",username);
            return "redirect:/list";
        } else {
            System.out.println("登录失败！");
            return "redirect:/error";
        }
    }

    /**
     * 注册时判断用户名有没有重复
     * @param username
     * @return
     */
    @ResponseBody
    @RequestMapping("/findUser/{username}")
    public int findUser(@PathVariable("username")String username){
        List<User> list = findByUserName(username);
        return list.size();
    }

    @ResponseBody
    @RequestMapping("/findByUsername/{username}")
    public List<User> findByUserName(@PathVariable("username")String username){
        List<User> list = userService.findByName(username);
        return list;
    }

    @RequestMapping("/updateUser")
    public String updateUser(User user){
        String username = user.getUsername();
        System.out.println("更新的用户名为："+username+user.getCreatetime());
        userService.updateUser(user);
        return "redirect:/personal";
    }

    @RequestMapping("/register")
    public String register(){
        return "register";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/suc")
    public String success(){
        return "suc";
    }

    @RequestMapping("/personal")
    public String personal(){
        return "personal";
    }

    @RequestMapping("/list")
    public String list(){
        return "list";
    }
}
