package com.ruoyi.web.controller.frontApi;

//import com.gk.study.common.APIResponse;
//import com.gk.study.common.ResponeCode;
//import com.gk.study.entity.Tag;
//import com.gk.study.permission.Access;
import com.ruoyi.common.core.domain.petFront.APIResponse;
import com.ruoyi.common.core.domain.petFront.ResponseCode;
import com.ruoyi.web.domain.MuseumTag;
import com.ruoyi.web.service.IMuseumTagService;
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
@Api(tags = "标签模块")
@RestController
@RequestMapping("/v1/tag")
public class TagController {

    private final static Logger logger = LoggerFactory.getLogger(TagController.class);

    @Autowired
    IMuseumTagService service;

    @ApiOperation(value = "获取标签列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public APIResponse list(MuseumTag museumTag){
        List<MuseumTag> list =  service.selectMuseumTagList(museumTag);

        return new APIResponse(ResponseCode.SUCCESS, "查询成功", list);
    }

//    @Access(level = AccessLevel.ADMIN)
    @ApiOperation(value = "后台创建标签")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @Transactional
    public APIResponse create(MuseumTag tag) throws IOException {
        service.insertMuseumTag(tag);
        return new APIResponse(ResponseCode.SUCCESS, "创建成功");
    }

//    @Access(level = AccessLevel.ADMIN)
    @ApiOperation(value = "后台删除标签")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public APIResponse delete(String ids){
        System.out.println("ids===" + ids);
        // 批量删除
        String[] arr = ids.split(",");
        for (String id : arr) {
            service.deleteMuseumTagByTagId(Long.parseLong(id));
        }
        return new APIResponse(ResponseCode.SUCCESS, "删除成功");
    }

//    @Access(level = AccessLevel.ADMIN)
    @ApiOperation(value = "后台更新标签")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @Transactional
    public APIResponse update(MuseumTag tag) throws IOException {
        service.updateMuseumTag(tag);
        return new APIResponse(ResponseCode.SUCCESS, "更新成功");
    }

}
