package com.mall.service;

import com.mall.common.ServerResponse;

/**
 * Created by ouyangyaoxu on 2018/3/28.
 * Desc:
 */
public interface ICategoryService {

    ServerResponse addCategory(String catagoryName, Integer parentId);

}
