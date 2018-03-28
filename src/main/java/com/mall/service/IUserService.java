package com.mall.service;

import com.mall.common.ServerResponse;
import com.mall.pojo.User;
/**
 * Created by ouyangyaoxu on 2018/3/24.
 */
public interface IUserService {

    ServerResponse<User> login(String username, String password);

    ServerResponse<String> register(User user);

    ServerResponse<String> checkValid(String value,String type);

    ServerResponse<String> selectQuestion(String username);

    ServerResponse<String> checkAnswer(String username,String question,String answer);

    ServerResponse<String> forgetResetPassword(String username,String passwordNew,String forgetToken);

    ServerResponse<String> resetPassword(String passwordOld,String passwordNew,User user);

    ServerResponse<User> updateInfomation(User user);

    ServerResponse checkAdminRole(User user);
}
