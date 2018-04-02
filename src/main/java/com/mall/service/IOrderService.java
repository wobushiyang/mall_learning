package com.mall.service;

import com.github.pagehelper.PageInfo;
import com.mall.common.ServerResponse;
import com.mall.vo.OrderVo;

/**
 * Created by ouyangyaoxu on 2018/4/2.
 * Desc:
 */
public interface IOrderService {

    ServerResponse<PageInfo> manageOrderList(Integer userId, int pageNum, int pageSize);

    ServerResponse<OrderVo> manageDetail(Long orderNo);

    ServerResponse<PageInfo> manageSearch(Long orderNo, int pageNum, int pageSize);

    ServerResponse<String> manageSendGoods(Long orderNo);
}