package com.ruoyi.web.controller.frontApi;

//import com.gk.study.common.APIResponse;
//import com.gk.study.common.ResponeCode;
//import com.gk.study.entity.Classification;
//import com.gk.study.permission.Access;
//import com.gk.study.permission.AccessLevel;
//import com.gk.study.service.ClassificationService;

import com.ruoyi.common.core.domain.petFront.APIResponse;
import com.ruoyi.common.core.domain.petFront.ResponseCode;
import com.ruoyi.web.domain.MuseumCategory;
import com.ruoyi.web.service.IMuseumCategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
/**
 * @author lengqin1024(微信)
 * @email net936@163.com
 */
@Api(tags = "分类模块")
@RestController
@RequestMapping("/v1/classification")
public class CategoryFrontController {

    private final static Logger logger = LoggerFactory.getLogger(CategoryFrontController.class);

//    @Autowired
//    ClassificationService service;


    @Autowired
    IMuseumCategoryService museumCategoryService;

    @ApiOperation(value = "获取类型列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public APIResponse list(MuseumCategory museumCategory){
        List<MuseumCategory> list =  museumCategoryService.selectMuseumCategoryList(museumCategory);
        return new APIResponse(ResponseCode.SUCCESS, "查询成功", list);
    }

//    @Access(level = AccessLevel.ADMIN)
    @ApiOperation(value = "后台创建类型")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @Transactional
    public APIResponse create(MuseumCategory classification) throws IOException {
        museumCategoryService.insertMuseumCategory(classification);
        return new APIResponse(ResponseCode.SUCCESS, "创建成功");
    }

//    @Access(level = AccessLevel.ADMIN)
    @ApiOperation(value = "后台删除类型")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public APIResponse delete(String ids){
        System.out.println("ids===" + ids);
        // 批量删除
        String[] arr = ids.split(",");
        for (String id : arr) {
            museumCategoryService.deleteMuseumCategoryByCategoryId(Integer.parseInt(id));
        }
        return new APIResponse(ResponseCode.SUCCESS, "删除成功");
    }

//    @Access(level = AccessLevel.ADMIN)
    @ApiOperation(value = "后台更新类型")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @Transactional
    public APIResponse update(MuseumCategory classification) throws IOException {
        museumCategoryService.updateMuseumCategory(classification);
        return new APIResponse(ResponseCode.SUCCESS, "更新成功");
    }

}
