package com.mall.service;

import com.github.pagehelper.PageInfo;
import com.mall.common.ServerResponse;
import com.mall.pojo.Shipping;

/**
 * Created by ouyangyaoxu on 2018/3/30.
 * Desc:
 */
public interface IShippingService {

    ServerResponse add(Integer userId, Shipping shipping);

    ServerResponse delete(Integer userId,Integer shippingId);

    ServerResponse update(Integer userId,Shipping shipping);

    ServerResponse<Shipping> select(Integer userId,Integer shippingId);

    ServerResponse<PageInfo> list(Integer userId, Integer pageNum, Integer pageSize);

}
