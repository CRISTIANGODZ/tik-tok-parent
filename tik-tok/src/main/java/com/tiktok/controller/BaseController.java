package com.tiktok.controller;

import com.google.gson.Gson;
import com.tiktok.pojo.User;
import com.tiktok.pojo.Video;
import com.tiktok.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
@RestController
public class BaseController {

    private static Gson gson = new Gson();
    @Autowired
    private BaseServiceImpl baseService;

    /**
     * 用户注册接口：
     * 添加新用户
     * 参数：userEmail、userPassword
     * /douyin/user/register --> POST
     */

    @RequestMapping(value = "/douyin/user/register", method = RequestMethod.POST)
    public String userRegisterController(User user){
        baseService.registeUser(user);
        //处理返回值参数
        HashMap<Object, Object> map = new HashMap<>();
        map.put("status_code",0);
        map.put("user_id",user.getUserId());//在UserMapper中实现了获取主键
        map.put("token",user.getUserEmail()+user.getUserPassword());
        String json = gson.toJson(map);
        return json;
    }

    /**
     * 用户登录接口
     * 参数：userEmail、userPassword
     */
    @RequestMapping(value = "/douyin/user/login", method = RequestMethod.GET)
    public String userLoginController(User user){
        Integer userId = baseService.getLogin(user);
        if (userId.equals(null)){
            return null;
        } else {
            HashMap<Object, Object> map = new HashMap<>();
            map.put("status_code",0);
            map.put("user_id",userId);
            map.put("token",user.getUserEmail()+user.getUserPassword());
            String json = gson.toJson(map);
            return json;
        }
    }

    /**
     * 查询用户信息
     * @param userId
     */
    @RequestMapping("/douyin/user")
    public String queryUserInformation(Integer userId){
        User user = baseService.queryUserInformation(userId);
        //处理返回值参数
        HashMap<Object, Object> map = new HashMap<>();
        map.put("status_code",0);
        map.put("user",user);
        String json = gson.toJson(map);
        return json;
    }

    /**
     * 视频投稿接口
     * @param video
     * @param videoTitle
     * @param userId
     * token(用userId代替)
     * @return
     */
    @RequestMapping(value = "/douyin/publish/action", method = RequestMethod.POST)
    public String VideoContributionController(Integer userId, String videoTitle, MultipartFile video, HttpSession session) throws IOException {
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
        //处理用户和视频的信息
        baseService.dealWithUserVideoInformation(userId,videoTitle,finalPath);
        //处理返回值参数
        HashMap<Object, Object> map = new HashMap<>();
        map.put("status_code",0);
        map.put("status_msg","上传视频成功！");
        String json = gson.toJson(map);
        return json;
    }

    /**
     * 显示视频列表
     * 参数：
     * @param userId
     * token(暂时不用)
     */
    @RequestMapping(value = "/douyin/publish/list",method = RequestMethod.GET)
    public String getPublishedVideoList(Integer userId){
        List<Video> videoList = baseService.getPublishedVideoList(userId);
        //设置返回值参数
        HashMap<Object, Object> map = new HashMap<>();
        map.put("status_code",0);
        map.put("status_msg","获取上传视频列表成功！");
        map.put("video_list",videoList);
        String json = gson.toJson(map);
        return json;
    }

    /**
     * 视频流接口
     * 参数：
     * latest_time
     * token(用user_id代替)
     */
    @RequestMapping(value = "/douyin/feed",method = RequestMethod.GET)
    public String getVideoControl(){
        List<Map<String, Object>> video = baseService.getVideo();
        //设置返回值参数
        HashMap<Object, Object> map = new HashMap<>();
        map.put("status_code",0);
        map.put("status_msg","获取视频流成功！");
        map.put("video_list",video);
        String json = gson.toJson(map);
        return json;
    }

}
