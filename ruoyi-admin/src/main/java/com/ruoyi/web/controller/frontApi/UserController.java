package com.ruoyi.web.controller.frontApi;

import com.ruoyi.common.core.domain.petFront.APIResponse;
import com.ruoyi.common.core.domain.petFront.ResponseCode;
//import com.gk.study.entity.User;
//import com.gk.study.permission.Access;
//import com.gk.study.permission.AccessLevel;
//import com.gk.study.service.UserService;
import com.ruoyi.web.domain.MuseumUser;
import com.ruoyi.web.service.IMuseumUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * @author caravn99(微信)
 * @email keloid9000@gmail.com
 */

@Api(tags = "前台用户模块")
@RestController
@RequestMapping("/v1/user")
public class UserController {

    private final static Logger logger = LoggerFactory.getLogger(UserController.class);

    String salt = "abcd1234";

    @Autowired
    IMuseumUserService userService;

    @Value("${ruoyi.profile}")
    private String uploadPath;


    @ApiOperation(value = "获取用户细节信息")
    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public APIResponse detail(String userId) {
        MuseumUser user = userService.selectMuseumUserByUserId(Long.parseLong(userId));
        return new APIResponse(ResponseCode.SUCCESS, "查询成功", user);
    }


    // 普通用户登录
    @ApiOperation(value = "前台用户登录")
    @RequestMapping(value = "/userLogin", method = RequestMethod.POST)
    public APIResponse userLogin(MuseumUser user) {
        user.setUserPassword(DigestUtils.md5DigestAsHex((user.getUserPassword() + salt).getBytes()));
        // 通过用户名和密码查找用户信息
//        MuseumUser responseUser =  userService.getUserInfoByUserName(user);

        List<MuseumUser> museumUsers = userService.selectMuseumUserList(user);

        if (museumUsers.size() != 0) {
            return new APIResponse(ResponseCode.SUCCESS, "查询成功", museumUsers.get(0));
        } else {
            return new APIResponse(ResponseCode.FAIL, "用户名或密码错误");
        }
    }

    // 普通用户注册
    @ApiOperation(value = "用户注册")
    @RequestMapping(value = "/userRegister", method = RequestMethod.POST)
    @Transactional
    public APIResponse userRegister(MuseumUser user) throws IOException {

        if (!StringUtils.isEmpty(user.getUserName())
                && !StringUtils.isEmpty(user.getUserPassword())
                && !StringUtils.isEmpty(user.getUserRePassword())) {
            // 查重
            if (userService.selectMuseumUserList(user).size() != 0) {
                return new APIResponse(ResponseCode.FAIL, "用户名重复");
            }
            // 验证密码
            if (!user.getUserPassword().equals(user.getUserRePassword())) {
                return new APIResponse(ResponseCode.FAIL, "密码不一致");
            }
            String md5Str = DigestUtils.md5DigestAsHex((user.getUserPassword() + salt).getBytes());
            // 设置密码
            user.setUserPassword(md5Str);
            md5Str = DigestUtils.md5DigestAsHex((user.getUserName() + salt).getBytes());

            // 设置token
            user.setUserToken(md5Str);

//            String avatar = saveAvatar(user);
//            if(!StringUtils.isEmpty(avatar)) {
//                user.setUserAvatar(avatar);
//            }
            // 设置角色
//            user.setRole(String.valueOf(MuseumUser.NormalUser));
            // 设置状态
//            user.setStatus("0");
            // 获取当前时间
//            user.setCreateTime(String.valueOf(System.currentTimeMillis()));

            userService.insertMuseumUser(user);
            return new APIResponse(ResponseCode.SUCCESS, "创建成功");
        }
        return new APIResponse(ResponseCode.FAIL, "创建失败");
    }


//    }


    //    @Access(level = AccessLevel.LOGIN)
    @ApiOperation(value = "更新用户信息")
    @RequestMapping(value = "/updateUserInfo", method = RequestMethod.POST)
    @Transactional
    public APIResponse updateUserInfo(MuseumUser user) throws IOException {
        MuseumUser tmpUser = userService.selectMuseumUserByUserId(user.getUserId());
        if (tmpUser.getRole().equals(String.valueOf(MuseumUser.NormalUser))) {
            // username和password不能改，故置空
            user.setUserName(null);
            user.setUserPassword(null);
//            user.setRole(String.valueOf(User.NormalUser));
            String avatar = saveAvatar(user);
            if (!StringUtils.isEmpty(avatar)) {
                user.setUserAvatar(avatar);
            }
            userService.updateMuseumUser(user);
            return new APIResponse(ResponseCode.SUCCESS, "更新成功");
        } else {
            return new APIResponse(ResponseCode.FAIL, "非法操作");
        }
    }

    /* 用户修改密码*/
//    @Access(level = AccessLevel.LOGIN)
    @ApiOperation(value = "更新密码")
    @RequestMapping(value = "/updatePwd", method = RequestMethod.POST)
    @Transactional
    public APIResponse updatePwd(String userId, String password, String newPassword) throws IOException {
        MuseumUser user = userService.selectMuseumUserByUserId(Long.parseLong(userId));
        if (user.getRole().equals(String.valueOf(MuseumUser.NormalUser))) {
            String md5Pwd = DigestUtils.md5DigestAsHex((password + salt).getBytes());
            if (user.getUserPassword().equals(md5Pwd)) {
                user.setUserPassword(DigestUtils.md5DigestAsHex((newPassword + salt).getBytes()));
                userService.updateMuseumUser(user);
            } else {
                return new APIResponse(ResponseCode.FAIL, "原密码错误");
            }
            return new APIResponse(ResponseCode.SUCCESS, "更新成功");
        } else {
            return new APIResponse(ResponseCode.FAIL, "非法操作");
        }

    }

    /* 后台查询用户列表*/
//    @RequestMapping(value = "/list", method = RequestMethod.GET)
//    public APIResponse list(String keyword){
//        List<MuseumUser> list =  userService.getUserList(keyword);
//        return new APIResponse(ResponeCode.SUCCESS, "查询成功", list);
//    }


    // 后台用户登录
//    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    public APIResponse login(MuseumUser user){
//        user.setPassword(DigestUtils.md5DigestAsHex((user.getPassword() + salt).getBytes()));
//        MuseumUser responseUser =  userService.getAdminUser(user);
//        if(responseUser != null) {
//            return new APIResponse(ResponeCode.SUCCESS, "查询成功", responseUser);
//        }else {
//            return new APIResponse(ResponeCode.FAIL, "用户名或密码错误");
//        }
//    }

    //    @Access(level = AccessLevel.ADMIN)
//    @RequestMapping(value = "/create", method = RequestMethod.POST)
//    @Transactional
//    public APIResponse create(User user) throws IOException {
//
//        if (!StringUtils.isEmpty(user.getUsername()) || !StringUtils.isEmpty(user.getPassword())) {
//            // 查重
//            if(userService.getUserByUserName(user.getUsername()) != null) {
//                return new APIResponse(ResponseCode.FAIL, "用户名重复");
//            }
//            String md5Str = DigestUtils.md5DigestAsHex((user.getPassword() + salt).getBytes());
//            // 设置密码
//            user.setPassword(md5Str);
//            md5Str = DigestUtils.md5DigestAsHex((user.getUsername() + salt).getBytes());
//            // 设置token
//            user.setToken(md5Str);
//            user.setCreateTime(String.valueOf(System.currentTimeMillis()));
//
//            String avatar = saveAvatar(user);
//            if(!StringUtils.isEmpty(avatar)) {
//                user.avatar = avatar;
//            }
//            userService.createUser(user);
//            return new APIResponse(ResponseCode.SUCCESS, "创建成功");
//        }
//        return new APIResponse(ResponseCode.FAIL, "创建失败");
//    }

//    @Access(level = AccessLevel.ADMIN)
//    @RequestMapping(value = "/delete", method = RequestMethod.POST)
//    public APIResponse delete(String ids){
//        System.out.println("ids===" + ids);
//        // 批量删除
//        String[] arr = ids.split(",");
//        for (String id : arr) {
//            userService.deleteUser(id);
//        }
//        return new APIResponse(ResponseCode.SUCCESS, "删除成功");
//    }

//    @Access(level = AccessLevel.ADMIN)
//    @RequestMapping(value = "/update", method = RequestMethod.POST)
//    @Transactional
//    public APIResponse update(MuseumUser user) throws IOException {
//        // update不能修改密码，故置空
//        user.setPassword(null);
//        String avatar = saveAvatar(user);
//        if(!StringUtils.isEmpty(avatar)) {
//            user.avatar = avatar;
//        }
//        userService.updateUser(user);
//        System.out.println(user);
//        return new APIResponse(ResponseCode.SUCCESS, "更新成功");

    public String saveAvatar(MuseumUser user) throws IOException {
        MultipartFile file = user.getUserAvatarFile();
        String newFileName = null;
        if (file != null && !file.isEmpty()) {

            // 存文件
            String oldFileName = file.getOriginalFilename();
            String randomStr = UUID.randomUUID().toString();
            newFileName = randomStr + oldFileName.substring(oldFileName.lastIndexOf("."));
            String filePath = uploadPath + File.separator + "avatar" + File.separator + newFileName;
            File destFile = new File(filePath);
            if (!destFile.getParentFile().exists()) {
                destFile.getParentFile().mkdirs();
            }
            file.transferTo(destFile);
        }
        if (!StringUtils.isEmpty(newFileName)) {
            user.setUserAvatar(newFileName);
        }
        return newFileName;
    }
}
