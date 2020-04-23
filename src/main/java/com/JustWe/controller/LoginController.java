package com.JustWe.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {


    @PostMapping(value = "/user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password")String password,
                        Map<String, Object> map,
                        HttpSession session) {
        if(StringUtils.isNotBlank(username) && StringUtils.equals("111", password)) {
            // 登陆成功，防止表单重复提交，可以重定向到主页
            session.setAttribute("loginUser", username);
            return "redirect:/main.html";
        } else {
            // 登陆失败
            map.put("msg", "用户名或密码错误!");
            return "redirect:/login";
        }

    }


}
