package com.JustWe.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Map;

/**
 * 页面跳转
 */
@Controller
public class PageController {

    Logger logger = LoggerFactory.getLogger(getClass());

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
