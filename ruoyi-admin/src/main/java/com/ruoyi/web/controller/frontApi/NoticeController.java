package com.ruoyi.web.controller.frontApi;

//import com.gk.study.common.APIResponse;
//import com.gk.study.common.ResponeCode;
//import com.gk.study.entity.Notice;
//import com.gk.study.permission.Access;
//import com.gk.study.permission.AccessLevel;
//import com.gk.study.service.NoticeService;
import com.ruoyi.web.domain.MuseumNotice;
import com.ruoyi.web.service.IMuseumNoticeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import com.ruoyi.common.core.domain.petFront.APIResponse;
import com.ruoyi.common.core.domain.petFront.ResponseCode;
@Api(tags = "站内消息模块")
@RestController
@RequestMapping("/v1/notice")
public class NoticeController {

    private final static Logger logger = LoggerFactory.getLogger(NoticeController.class);

    @Autowired
    IMuseumNoticeService service;

    @ApiOperation(value = " 获取消息列表")
    @GetMapping(value = "/list")
    public APIResponse list(MuseumNotice museumNotice){
        List<MuseumNotice> list =  service.selectMuseumNoticeList(museumNotice);
        return new APIResponse(ResponseCode.SUCCESS, "查询成功", list);
    }

//    @Access(level = AccessLevel.ADMIN)
    @ApiOperation(value = "后台创建站内消息")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @Transactional
    public APIResponse create(MuseumNotice notice) throws IOException {
        service.insertMuseumNotice(notice);
        return new APIResponse(ResponseCode.SUCCESS, "创建成功");
    }

//    @Access(level = AccessLevel.ADMIN)
    @ApiOperation(value = "后台删除站内消息")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public APIResponse delete(String ids){
        System.out.println("ids===" + ids);
        // 批量删除
        String[] arr = ids.split(",");
        for (String id : arr) {
            service.deleteMuseumNoticeByNoticeId(Long.parseLong(id));
        }
        return new APIResponse(ResponseCode.SUCCESS, "删除成功");
    }

//    @Access(level = AccessLevel.ADMIN)
    @ApiOperation(value = "后台更新站内消息")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @Transactional
    public APIResponse update(MuseumNotice notice) throws IOException {
        service.updateMuseumNotice(notice);
        return new APIResponse(ResponseCode.SUCCESS, "更新成功");
    }

}
