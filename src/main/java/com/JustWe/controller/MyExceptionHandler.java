package com.JustWe.controller;

import com.JustWe.exception.UserNotExistException;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 定制错误的json数据
 *
 */
@ControllerAdvice
public class MyExceptionHandler {


    /**
     * 1、浏览器和客户端都返回json数据
     * 通过@ExceptionHandler 注解，捕获到异常UserNotExistException.class
     *
     * @param e
     * @return
     */
//    @ResponseBody
//    @ExceptionHandler(UserNotExistException.class)
//    public Map<String, Object> handleException(Exception e) {
//        Map<String, Object> map = new HashMap<>();
//        map.put("code", "user.NotExist");
//        map.put("message", e.getMessage());
//        return map;
//    }


    /**
     * 2、转发到/error进行自适应响应效果处理
     *
     * @param e
     * @return
     */
    @ExceptionHandler(UserNotExistException.class)
    public String handleException(Exception e, HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        // 传入我们自己的错误状态码 4xx 5xx，否则不会进入定制的错误页面
        /**
         * Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code")
         */
        request.setAttribute("javax.servlet.error.status_code", 500);
        map.put("code", "user.NotExist");
        map.put("message", e.getMessage());

        request.setAttribute("ext",map);
        // 转发到/error
        return "forward:/error";
    }


}
