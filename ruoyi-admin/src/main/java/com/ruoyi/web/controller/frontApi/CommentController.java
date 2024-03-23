package com.ruoyi.web.controller.frontApi;


import com.ruoyi.web.domain.MuseumComment;
import com.ruoyi.web.service.IMuseumCommentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.ruoyi.common.core.domain.petFront.APIResponse;
import com.ruoyi.common.core.domain.petFront.ResponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

import static com.ruoyi.common.utils.PageUtils.startPage;

@Api(tags = "评论模块")
@RestController
@RequestMapping("/v1/comment")
public class CommentController {

    private final static Logger logger = LoggerFactory.getLogger(CommentController.class);

    @Autowired
    IMuseumCommentService service;


    // 商品的所有评论
    @ApiOperation(value = "获取商品的评论列表")
    @RequestMapping(value = "/listThingComments", method = RequestMethod.GET)
    public APIResponse listThingComments(MuseumComment museumComment) {
        startPage();
        List<MuseumComment> list = service.selectMuseumCommentList(museumComment);
        return new APIResponse(ResponseCode.SUCCESS, "查询成功", list);
    }

    // 用户的所有评论
    @ApiOperation(value = "获取用户所有评论")
    @RequestMapping(value = "/listUserComments", method = RequestMethod.GET)
    public APIResponse listUserComments(String userId) {
        MuseumComment museumComment = new MuseumComment();
        museumComment.setCommentUserId(Long.parseLong(userId));
        List<MuseumComment> list = service.selectMuseumCommentList(museumComment);
        return new APIResponse(ResponseCode.SUCCESS, "查询成功", list);
    }

    @ApiOperation(value = "创建评论")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @Transactional
    public APIResponse create(MuseumComment comment) throws IOException {
        service.insertMuseumComment(comment);
        return new APIResponse(ResponseCode.SUCCESS, "创建成功");
    }

    //    @Access(level = AccessLevel.ADMIN)
    @ApiOperation(value = "后台删除评论")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public APIResponse delete(String ids) {
        System.out.println("ids===" + ids);
        // 批量删除
        String[] arr = ids.split(",");
        for (String id : arr) {
            service.selectMuseumCommentByCommentId(Integer.parseInt(id));
        }
        return new APIResponse(ResponseCode.SUCCESS, "删除成功");
    }

    //    @Access(level = AccessLevel.ADMIN)
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @Transactional
    public APIResponse update(MuseumComment comment) throws IOException {
        service.updateMuseumComment(comment);
        return new APIResponse(ResponseCode.SUCCESS, "更新成功");
    }

    @RequestMapping(value = "/like", method = RequestMethod.POST)
    @Transactional
    public APIResponse like(String id) throws IOException {
        MuseumComment commentBean = service.selectMuseumCommentByCommentId(Integer.parseInt(id));
        int likeCount = commentBean.getCommentLikeCount() + 1;
        commentBean.setCommentLikeCount(likeCount);
        service.updateMuseumComment(commentBean);
        return new APIResponse(ResponseCode.SUCCESS, "更新成功");
    }

}
