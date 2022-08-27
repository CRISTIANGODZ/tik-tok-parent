package com.tiktok.controller;

import com.tiktok.pojo.User;
import com.tiktok.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

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
 *     -跳转到用户登录页面/douyin/to/login --> GET
 *     -跳转到上传视频页面/douyin/to/publish --> GET
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
     * 视频投稿接口
     * @return
     */
    @RequestMapping(value = "/douyin/publish/action", method = RequestMethod.POST)
    public String VideoContributionController(MultipartFile video, HttpSession session) throws IOException {
        //获取文件名
        String originalFilename = video.getOriginalFilename();
        //随机生成新的文件名
        String fileSuffixName = originalFilename.substring(originalFilename.lastIndexOf("."));
        String uuid = UUID.randomUUID().toString();
        String realFileName = uuid + fileSuffixName;
        //获取ServletContext对象
        ServletContext servletContext = session.getServletContext();
        //获取当前工程的真实路径
        String videoRespority = servletContext.getRealPath("userRespority/videoRespority");
        //创建videoRespority所对应的File对象
        File file = new File(videoRespority);
        if (!file.exists()){
            file.mkdir();
        }
        //得到最终路径
        String finalPath = videoRespority + File.separator + realFileName;
        //上传文件
        video.transferTo(new File(finalPath));
        return "success";
    }

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
