package com.mall.service;

import com.mall.common.ServerResponse;
import com.mall.pojo.User;
import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;

import javax.jws.soap.SOAPBinding;

/**
 * Created by ouyangyaoxu on 2018/3/24.
 */
public interface IUserService {

    ServerResponse<User> login(String username, String password);

    ServerResponse<String> register(User user);

    ServerResponse<String> checkValid(String value,String type);

}
