package com.mall.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mall.common.ServerResponse;
import com.mall.dao.ShippingMapper;
import com.mall.pojo.Shipping;
import com.mall.service.IShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ouyangyaoxu on 2018/3/30.
 * Desc:
 */
@Service("iShippingService")
public class ShippingServiceImpl implements IShippingService {
    private static final String TAG = "ShippingServiceImpl";

    @Autowired
    private ShippingMapper shippingMapper;

    public ServerResponse add(Integer userId, Shipping shipping) {
        if (shipping == null) {
            return ServerResponse.createByErrorMessage("地址参数错误");
        }
        shipping.setUserId(userId);
        int rowCount = shippingMapper.insert(shipping);
        if (rowCount > 0) {
            return ServerResponse.createBySuccessMessage("添加地址成功");
        }
        return ServerResponse.createBySuccessMessage("添加地址失败");
    }


    public ServerResponse delete(Integer userId, Integer shippingId) {
        if (userId == null || shippingId == null) {
            return ServerResponse.createByErrorMessage("参数错误");
        }
        int rowCount = shippingMapper.deleteByShippingIdUserId(userId, shippingId);
        if (rowCount > 0) {
            return ServerResponse.createBySuccessMessage("删除地址成功");
        }
        return ServerResponse.createBySuccessMessage("删除地址失败");
    }

    public ServerResponse update(Integer userId, Shipping shipping) {
        if (userId == null || shipping == null) {
            return ServerResponse.createByErrorMessage("地址参数错误");
        }
        shipping.setUserId(userId);
        int rowCount = shippingMapper.updateByShipping(shipping);
        if (rowCount > 0) {
            return ServerResponse.createBySuccessMessage("更新地址成功");
        }
        return ServerResponse.createBySuccessMessage("更新地址失败");
    }

    public ServerResponse<Shipping> select(Integer userId, Integer shippingId) {
        if (userId == null || shippingId == null) {
            return ServerResponse.createByErrorMessage("参数错误");
        }
        Shipping shipping = shippingMapper.selectByUserIdShippingId(userId, shippingId);
        if (shipping != null) {
            return ServerResponse.createBySuccessMessage("查询地址成功");
        }
        return ServerResponse.createBySuccessMessage("查询地址失败");
    }

    public ServerResponse<PageInfo> list(Integer userId, Integer pageNum, Integer pageSize) {
        if (userId == null || pageNum == null || pageSize == null) {
            return ServerResponse.createByErrorMessage("参数错误");
        }
        PageHelper.startPage(pageNum,pageSize);
        List<Shipping> shippingList = shippingMapper.selectListByUserId(userId);
        PageInfo pageInfo = new PageInfo(shippingList);
        return ServerResponse.createBySuccess(pageInfo);
    }


}
