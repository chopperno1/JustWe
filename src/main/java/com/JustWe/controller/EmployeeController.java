package com.JustWe.controller;

import com.JustWe.dao.DepartmentDao;
import com.JustWe.dao.EmployeeDao;
import com.JustWe.entities.Department;
import com.JustWe.entities.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * 处理员工信息
 *
 */
@Controller
public class EmployeeController {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;

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

    /**
     * 跳转到员工添加页面
     *
     * @return
     */
    @GetMapping("/emp")
    public String toAddPage(Model model) {
        // 跳转到添加页面，查出所有的部门，在页面回显
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts", departments);
        return "emp/add";
    }


    /**
     * 员工添加
     *
     * @param employee
     * @return
     */
    @PostMapping("/emp")
    public String addEmp(Employee employee) {
        //SpringMVC自动将请求参数和入参对象的属性进行一一绑定：要求请求参数的名字和javaBean入参的属性名一致
        logger.info("保存的员工信息:" + employee);

        //保存员工
        employeeDao.save(employee);

        // 来到员工列表页面
        // redirect: 表示重定向到一个地址 /代表当前项目路径
        // forward: 表示转发到一个地址
        return "redirect:/emps";
    }


    /**
     * 跳转到修改页面，查出当前员工并回显
     *
     * @return
     */
    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id, Model model) {
        Employee employee = employeeDao.get(id);
        model.addAttribute("emp", employee);

        // 页面要显示所有的部门列表
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts", departments);

        //回到修改页面（add是一个修改添加二合一页面）
        return "emp/add";
    }


    /**
     * 修改员工信息：需要提交员工id
     *
     * @param employee
     * @return
     */
    @PutMapping("/emp")
    public String updateEmployee(Employee employee) {
        logger.info("修改的员工信息:" + employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }


    /**
     * 删除员工信息
     *
     * @param id
     * @return
     */
    @DeleteMapping("/emp/{id}")
    public String deleteEmployee(@PathVariable Integer id) {
        logger.info("删除的员工id:" + id);
        employeeDao.delete(id);
        return "redirect:/emps";
    }


}
