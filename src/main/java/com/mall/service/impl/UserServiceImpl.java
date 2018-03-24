package com.mall.service.impl;

import com.mall.common.Const;
import com.mall.common.ServerResponse;
import com.mall.dao.UserMapper;
import com.mall.pojo.User;
import com.mall.service.IUserService;
import com.mall.util.MD5Util;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ouyangyaoxu on 2018/3/24.
 */
@Service("iUserService")
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public ServerResponse<User> login(String username, String password) {
        int resultCount = userMapper.checkUsername(username);
        if (resultCount == 0) {
            return ServerResponse.createByErrorMessage("用户不存在");
        }
        String md5Password = MD5Util.MD5EncodeUtf8(password);
        User user = userMapper.selectLogin(username, md5Password);
        if (user == null) {
            return ServerResponse.createByErrorMessage("密码错误");
        }
        user.setPassword(StringUtils.EMPTY);
        return ServerResponse.createBySuccess("登陆成功", user);
    }

    @Override
    public ServerResponse<String> register(User user) {
        ServerResponse<String> response = this.checkValid(user.getUsername(), Const.USERNAME);
        if (!response.isSuccess()) {
            return response;
        }
        response = this.checkValid(user.getEmail(), Const.EMAIL);
        if(!response.isSuccess()){
            return response;
        }
        user.setRole(Const.Role.ROLE_CUSTOMER);
        //MD5加密
        user.setPassword(MD5Util.MD5EncodeUtf8(user.getPassword()));
        int resultCount = userMapper.insert(user);
        if (resultCount == 0) {
            return ServerResponse.createByErrorMessage("注册失败");
        }
        return ServerResponse.createBySuccessMessage("注册成功");
    }


    @Override
    public ServerResponse<String> checkValid(String value, String type) {
        if (org.apache.commons.lang3.StringUtils.isNotBlank(type)) {
            if (Const.USERNAME.equals(value)) {
                int resultCount = userMapper.checkUsername(value);
                if (resultCount > 0) {
                    return ServerResponse.createByErrorMessage("用户已存在");
                }
            }
            if (Const.EMAIL.equals(value)) {
                int resultCount = userMapper.checkEmail(value);
                if (resultCount > 0) {
                    return ServerResponse.createByErrorMessage("email已存在");
                }
            }
        } else {
            return ServerResponse.createByErrorMessage("参数错误");
        }
        return ServerResponse.createBySuccessMessage("校验成功");
    }



}
