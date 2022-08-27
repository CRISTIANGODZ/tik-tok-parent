package com.tiktok.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @auther DyingZhang
 * @Create 2022-08-27 18:18
 * @Discriptioon
 */
@Controller
public class ForwardController {

    /**
     * 跳转到用户注册页面
     */
    @RequestMapping(value = "/douyin/to/regist",method = RequestMethod.GET)
    public String toUserRegister(){
        return "register";
    }

    /**
     * 跳转到用户登录页面
     */
    @RequestMapping("/douyin/to/login")
    public String toUserLogin(){
        return "login";
    }

    /**
     * 跳转到上传视频页面
     */
    @RequestMapping("/douyin/to/publish")
    public String toPublishVideo(){
        return "publishVideo";
    }
}
