package com.ruoyi.web.controller.frontApi;

import com.github.pagehelper.PageInfo;
import com.ruoyi.web.domain.MuseumAntique;
import com.ruoyi.web.service.IMuseumAntiqueService;
import com.ruoyi.common.core.domain.petFront.APIResponse;
import com.ruoyi.common.core.domain.petFront.ResponseCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import static com.ruoyi.common.utils.PageUtils.startPage;

@Api(tags = "前台古董模块")
@RestController
@RequestMapping("/v1/thing")
public class AntiqueFrontController {

    private final static Logger logger = LoggerFactory.getLogger(AntiqueFrontController.class);

    @Autowired
    IMuseumAntiqueService museumAntiqueService;

    @Value("${ruoyi.profile}")
    private String uploadPath;

    // 前台获取古董列表
    @ApiOperation("获取前台古董列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public APIResponse list(MuseumAntique museumAntique) {
        System.out.println("获取参数");
        // 开启分页，并且获取排序方式
        startPage();
        List<MuseumAntique> museumAntiques = museumAntiqueService.selectMuseumAntiqueList(museumAntique);
        APIResponse apiResponse = new APIResponse(ResponseCode.SUCCESS, "查询成功", museumAntiques);
        apiResponse.setTotal(new PageInfo(museumAntiques).getTotal());

        // 需要传入分页信息
        return apiResponse;
    }

    @ApiOperation("获取前台古董详情")
    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public APIResponse detail(String antiqueId) {
        MuseumAntique thing = museumAntiqueService.selectMuseumAntiqueByAntiqueId(Integer.parseInt(antiqueId));
        return new APIResponse(ResponseCode.SUCCESS, "查询成功", thing);
    }

    //    @Access(level = AccessLevel.ADMIN)
    @ApiOperation("后台新增古董")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @Transactional
    public APIResponse create(MuseumAntique thing) throws IOException {
        String url = saveThing(thing);  // 保存照片
        if (!StringUtils.isEmpty(url)) {
            thing.setAntiqueImg(url);
        }

        museumAntiqueService.insertMuseumAntique(thing);
        return new APIResponse(ResponseCode.SUCCESS, "创建成功");
    }

    //    @Access(level = AccessLevel.ADMIN)
    @ApiOperation("后台删除古董")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public APIResponse<String> delete(String ids) {
        System.out.println("ids===" + ids);
        // 批量删除
        String[] arr = ids.split(",");
        for (String id : arr) {
            museumAntiqueService.deleteMuseumAntiqueByAntiqueId(Integer.parseInt(id));
        }
        return new APIResponse(ResponseCode.SUCCESS, "删除成功");
    }

    //    @Access(level = AccessLevel.ADMIN)
    @ApiOperation("后台更新古董")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @Transactional
    public APIResponse update(MuseumAntique thing) throws IOException {
        System.out.println(thing);
        String url = saveThing(thing);
        if (!StringUtils.isEmpty(url)) {
            thing.setAntiqueImg(url);
        }

        museumAntiqueService.updateMuseumAntique(thing);
        return new APIResponse(ResponseCode.SUCCESS, "更新成功");
    }

    /* 保存图片并且返回图片文件名*/
    public String saveThing(MuseumAntique thing) throws IOException {
        MultipartFile file = thing.getAntiqueImgFile();
        String newFileName = null;
        if (file != null && !file.isEmpty()) {

            // 存文件
            String oldFileName = file.getOriginalFilename();
            String randomStr = UUID.randomUUID().toString();
            newFileName = randomStr + oldFileName.substring(oldFileName.lastIndexOf("."));
            String filePath = uploadPath + File.separator + "image" + File.separator + newFileName;
            File destFile = new File(filePath);
            if (!destFile.getParentFile().exists()) {
                destFile.getParentFile().mkdirs();
            }
            file.transferTo(destFile);
        }
        if (!StringUtils.isEmpty(newFileName)) {
            thing.setAntiqueImg(newFileName);
        }
        return newFileName;
    }

}
