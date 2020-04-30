package com.JustWe.controller;

import com.JustWe.exception.UserNotExistException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

/**
 * 页面跳转
 */
@Controller
public class MainPageController {

    Logger logger = LoggerFactory.getLogger(getClass());


    @RequestMapping("/hello")
    @ResponseBody
    public String helloWorld(@RequestParam(required=false) String user) {
        if(StringUtils.equals("aaa", user)) {
            throw new UserNotExistException();
        }
        return "helloWorld";
    }


    /**
     * 登陆
     *
     * @return
     */
    @RequestMapping({"/", "/login"})
    public String toLogin() {
        return "login";
    }


    /**
     * 测试thymeleaf模板功能
     *
     * @param map
     * @return
     */
    @RequestMapping("/success")
    public String success(Map<String, Object> map) {
        //classpath:/templates/success.html
        map.put("hello", "<h1>你好</h1>");
        map.put("users", Arrays.asList("zhangsan", "lisi", "wangwu"));
        return "success";
    }



}
