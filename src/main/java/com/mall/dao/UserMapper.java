package com.mall.dao;

import com.mall.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.junit.runners.Parameterized;
import org.springframework.web.bind.annotation.PathVariable;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    int checkUsername(String username);

    int checkEmail(String email);

    User selectLogin(@Param("username") String username, @Param("password") String password);

}