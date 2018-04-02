package com.mall.service;

import com.mall.common.ServerResponse;
import com.mall.vo.CartVo;

/**
 * Created by ouyangyaoxu on 2018/4/2.
 * Desc:
 */
public interface ICartService {

    ServerResponse<CartVo> add(Integer userId,Integer productId,Integer count);
    ServerResponse<CartVo> update(Integer userId,Integer productId,Integer count);
    ServerResponse<CartVo> deleteProduct(Integer userId,String productIds);
    ServerResponse<CartVo> selectOrUnSelect (Integer userId,Integer productId,Integer checked);
    ServerResponse<Integer> getCartProductCount(Integer userId);
    ServerResponse<CartVo> list(Integer userId);


}
