package com.chint.supervisorycontrol.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.chint.supervisorycontrol.constants.ResponseMessage;
import com.chint.supervisorycontrol.service.ProductService;
import com.chint.supervisorycontrol.vo.productVO.ListProductsVO;
import com.chint.supervisorycontrol.vo.productVO.RemoveProductsVO;
import com.chint.supervisorycontrol.vo.productVO.UpdateProductsVO;
import org.springframework.stereotype.Service;

/**
 * @author zhouying3
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Override
    public ResponseMessage<JSONObject> listProducts(ListProductsVO vo) {
        return null;
    }

    @Override
    public ResponseMessage<JSONObject> updateProducts(UpdateProductsVO vo) {
        return null;
    }

    @Override
    public ResponseMessage<JSONObject> removeProducts(RemoveProductsVO vo) {
        return null;
    }
}
