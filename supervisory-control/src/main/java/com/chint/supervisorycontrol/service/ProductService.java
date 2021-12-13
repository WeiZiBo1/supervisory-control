package com.chint.supervisorycontrol.service;

import com.alibaba.fastjson.JSONObject;
import com.chint.supervisorycontrol.constants.ResponseMessage;
import com.chint.supervisorycontrol.vo.productVO.ListProductsVO;
import com.chint.supervisorycontrol.vo.productVO.RemoveProductsVO;
import com.chint.supervisorycontrol.vo.productVO.UpdateProductsVO;

/**
 * @author zhouying3
 */
public interface ProductService {

    /**
     * 产品列表
     * @param vo “产品列表”
     * @return success
     */
    ResponseMessage<JSONObject> listProducts(ListProductsVO vo);

    /**
     * 更新产品
     * @param vo “更新产品”
     * @return success
     */
    ResponseMessage<JSONObject> updateProducts(UpdateProductsVO vo);


    /**
     * 删除产品
     * @param vo “删除产品”
     * @return success
     */
    ResponseMessage<JSONObject> removeProducts(RemoveProductsVO vo);
}
