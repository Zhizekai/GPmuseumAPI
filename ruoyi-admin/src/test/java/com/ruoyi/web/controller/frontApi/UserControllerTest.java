package com.ruoyi.web.controller.frontApi;

import com.ruoyi.web.domain.MuseumUser;
import com.ruoyi.web.service.IMuseumUserService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserControllerTest {

    @Autowired
    IMuseumUserService museumUserService;

    @Test
    void userLogin() {


        MuseumUser museumUser = new MuseumUser();
        museumUser.setUserName("dd");
        List<MuseumUser> museumUsers = museumUserService.selectMuseumUserList(museumUser);
//        MuseumUser responseUser = museumUsers.get(0);
        System.out.println(museumUsers.size());  //0
    }
}