package com.JustWe.controller;

import com.JustWe.dao.EmployeeDao;
import com.JustWe.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

/**
 * 处理员工信息
 *
 */
@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;

    /**
     * 查询所有员工，返回列表页面
     *
     * @return
     */
    @GetMapping("/emps")
    public String list(Model model) {

        Collection<Employee> employees = employeeDao.getAll();
        // 放在请求域中
        model.addAttribute("emps", employees);

        // thymeleaf默认就会拼串
        // classpath:/templates/xxxxx.html
        return "emp/list";
    }




}
