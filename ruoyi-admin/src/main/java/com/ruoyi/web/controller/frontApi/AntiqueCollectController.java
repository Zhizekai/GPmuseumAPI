package com.ruoyi.web.controller.frontApi;

//import com.gk.study.common.APIResponse;
//import com.gk.study.common.ResponeCode;
//import com.gk.study.entity.ThingCollect;
//import com.gk.study.permission.Access;
//import com.gk.study.permission.AccessLevel;
import com.ruoyi.common.core.domain.petFront.APIResponse;
import com.ruoyi.common.core.domain.petFront.ResponseCode;
import com.ruoyi.web.domain.MuseumAntique;
import com.ruoyi.web.domain.MuseumCollect;
import com.ruoyi.web.service.IMuseumAntiqueService;
import com.ruoyi.web.service.IMuseumCollectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/v1/thingCollect")
public class AntiqueCollectController {

    private final static Logger logger = LoggerFactory.getLogger(AntiqueCollectController.class);

    @Autowired
    IMuseumCollectService thingCollectService;

    @Autowired
    IMuseumAntiqueService thingService;

    /* 用户收藏*/
//    @Access(level = AccessLevel.LOGIN)
    @RequestMapping(value = "/collect", method = RequestMethod.POST)
    @Transactional
    public APIResponse collect(MuseumCollect thingCollect) throws IOException {



        if(thingCollectService.selectMuseumCollectList(thingCollect).size() != 0){
            return new APIResponse(ResponseCode.SUCCESS, "您已收藏过了");
        }else {
            thingCollectService.insertMuseumCollect(thingCollect);
            thingService.addCollectCount(Integer.parseInt(thingCollect.getAntiqueId().toString()));
        }
        return new APIResponse(ResponseCode.SUCCESS, "收藏成功");
    }

    /* 用户取消收藏*/
//    @Access(level = AccessLevel.LOGIN)
    @RequestMapping(value = "/unCollect", method = RequestMethod.POST)
    @Transactional
    public APIResponse unCollect(String collectId) throws IOException {
        thingCollectService.deleteMuseumCollectByCollectId(Long.parseLong(collectId));
        return new APIResponse(ResponseCode.SUCCESS, "取消收藏成功");
    }

    /* 获取用户收藏列表*/
    @RequestMapping(value = "/getUserCollectList", method = RequestMethod.GET)
    @Transactional
    public APIResponse getUserCollectList(String userId) throws IOException {


        MuseumCollect museumCollect = new MuseumCollect();
        museumCollect.setUserId(Long.parseLong(userId));

        // 获取用户收藏列表
        List<MuseumAntique> lists = thingCollectService.selectCollectionByUserId(Long.parseLong(userId));
        return new APIResponse(ResponseCode.SUCCESS, "获取成功", lists);
    }
}
