package com.example.onlinstudy.controller;

import com.example.onlinstudy.entity.MyInfo;
import com.example.onlinstudy.service.MyInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping
public class MyInfoController {
    @Resource
    MyInfoService myInfoService;

    @ResponseBody
    @RequestMapping("/add")
    public void addInfo(HttpServletRequest request,MyInfo myInfo){
        System.out.println("传过来的数据是："+myInfo.getTitle()+myInfo.getContent());
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        myInfo.setCreateUser(username);
        System.out.println("用户名："+username);
        myInfoService.addInfo(myInfo);
    }

    /**
     * 查找所有数据
     * @return
     */
    @ResponseBody
    @RequestMapping("/showList")
    public List<MyInfo> showList(){
        return myInfoService.findAll();
    }

    @ResponseBody
    @RequestMapping("/showInfo")
    public List<MyInfo> showInfo(HttpServletRequest request,HttpSession session){
        session = request.getSession();
        String username = (String) session.getAttribute("username");
        return myInfoService.findByCreateUser(username);
    }

    @ResponseBody
    @RequestMapping("/updateInfo")
    public void updateInfo(HttpServletRequest request,MyInfo myInfo){
        System.out.println("修改的信息为："+myInfo.getMainid()+","+myInfo.getTitle()+","+myInfo.getContent());
        HttpSession session = request.getSession();
        String createUser = (String) session.getAttribute("username");
        myInfo.setCreateUser(createUser);
        System.out.println("登录用户名为："+createUser);
        myInfoService.updateInfo(myInfo);
    }

    @RequestMapping("/findById/{mainid}")
    @ResponseBody
    public Optional<MyInfo> findById(HttpServletRequest request,@PathVariable("mainid")String mainid){
        HttpSession session = request.getSession();
        session.setAttribute("mainid",mainid);
        String id = (String) session.getAttribute("mainid");
        System.out.println("传到后台的id为："+id);
        return myInfoService.findById(mainid);
    }

    /**
     * 删除信息
     * @param mainid
     */
    @ResponseBody
    @RequestMapping("/deleteById/{mainid}")
    public void delete(@PathVariable("mainid")String mainid){
        System.out.println("传过来的id为："+mainid);
        myInfoService.deleteById(mainid);
    }

    @ResponseBody
    @RequestMapping("/getSession")
    public List getSession(HttpServletRequest request,HttpSession session){
        session = request.getSession();
        String username = (String) session.getAttribute("username");
        String mainid = (String) session.getAttribute("mainid");
        List list = new ArrayList();
        list.add(mainid);
        list.add(username);
        System.out.println("session中有："+list.get(0)+list.get(1));
        return list;
    }

    @RequestMapping("/addInfo")
    public String addInfo(){
        return "addInfo";
    }

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @RequestMapping("/details")
    public String details(){
        return "details";
    }
}
