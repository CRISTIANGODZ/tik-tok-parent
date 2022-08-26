package com.tiktok.mapper;

import com.tiktok.pojo.UserInformation;
import org.apache.ibatis.annotations.Param;

/**
 * @auther DyingZhang
 * @Create 2022-08-26 17:49
 * @Discriptioon
 */
public interface UserInformationMapper {

    /**
     * 查询用户信息第二步
     */
    UserInformation queryUserInformationStepTwo(@Param("userId") Integer userId);

}
