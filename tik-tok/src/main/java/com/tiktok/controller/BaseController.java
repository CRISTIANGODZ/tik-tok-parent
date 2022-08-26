package com.tiktok.controller;

import com.tiktok.pojo.User;
import com.tiktok.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @auther DyingZhang
 * @Create 2022-08-26 12:00
 * @Discriptioon
 * 基础接口：
 *      视频流接口       /douyin/feed --> GET
 *      用户注册接口     /douyin/user/register --> POST
 *      用户登录接口     /douyin/user/login --> GET
 *      添加用户信息*    /douyin/add/userInfo --> POST
 *      查询用户信息     /douyin/user --> GET
 *      视频投稿         /douyin/publish/action --> POST
 *      发布列表         /douyin/publish/list --> GET
 *
 *     -跳转到用户注册页面/douyin/to/registe --> GET
 *     -跳转到用户登录页面/douyin/to/login -->GET
 *
 */
@Controller
public class BaseController {

    @Autowired
    private BaseServiceImpl baseService;

    /**
     * 用户注册接口：
     * 添加新用户
     * /douyin/user/register --> POST
     */
    @RequestMapping(value = "/douyin/user/register", method = RequestMethod.POST)
    public String userRegisterController(User user){
        baseService.registeUser(user);
        return "success";
    }

    /**
     * 用户登录接口
     */
    @RequestMapping(value = "/douyin/user/login", method = RequestMethod.GET)
    public String userLoginController(User user, Model model){
        Integer userId = baseService.getLogin(user);
        if (userId.equals(null)){
            System.out.println(1/0);
        } else {
            String token = user.getUserEmail() + user.getUserPassword();
            model.addAttribute(token);
            model.addAttribute(userId);
        }
        return "success";
    }

    /**
     * 查询用户信息
     */
    @RequestMapping("/douyin/user/{userId}")
    public String queryUserInformation(@PathVariable("userId") Integer userId, Model model){
        User user = baseService.queryUserInformation(userId);
        model.addAttribute(user);
        return "userInformation";
    }

    /**
     * 跳转到用户注册页面
     */
    @RequestMapping(value = "/douyin/to/regist",method = RequestMethod.GET)
    public String toUserRegister(){
        return "register";
    }

    /**
     * 跳转到用户登录界面
     */
    @RequestMapping("/douyin/to/login")
    public String toUserLogin(){
        return "login";
    }



}
