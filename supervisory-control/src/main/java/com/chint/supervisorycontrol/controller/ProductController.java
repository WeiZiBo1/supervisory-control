package com.chint.supervisorycontrol.controller;

import com.alibaba.fastjson.JSONObject;
import com.chint.supervisorycontrol.constants.ResponseMessage;
import com.chint.supervisorycontrol.service.ProductService;
import com.chint.supervisorycontrol.vo.productVO.ListProductsVO;
import com.chint.supervisorycontrol.vo.productVO.RemoveProductsVO;
import com.chint.supervisorycontrol.vo.productVO.UpdateProductsVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhouying3
 */
@RestController
@RequestMapping("/product-management")
@Api(value = "产品接口", tags = "产品接口")
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;
    /**
     * 产品列表
     */
    @RequestMapping(value = "/productInfo", method = RequestMethod.GET)
    @ApiOperation(value = "产品列表", notes = "产品列表")
    public ResponseMessage<JSONObject> listProducts(ListProductsVO vo) {
        return productService.listProducts(vo);
    }

    /**
     * 更新产品
     */
    @RequestMapping(value = "/product", method = RequestMethod.PUT)
    @ApiOperation(value = "更新产品", notes = "产品列表")
    public ResponseMessage<JSONObject> updateProducts(UpdateProductsVO vo) {
        return productService.updateProducts(vo);
    }

    /**
     * 删除产品
     */
    @RequestMapping(value = "/product", method = RequestMethod.DELETE)
    @ApiOperation(value = "删除产品", notes = "产品列表")
    public ResponseMessage<JSONObject> removeProducts(RemoveProductsVO vo) {
        return productService.removeProducts(vo);
    }
}
