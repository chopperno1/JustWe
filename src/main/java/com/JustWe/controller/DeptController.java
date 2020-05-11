package com.JustWe.controller;

import com.JustWe.entities.Department;
import com.JustWe.entities.Employee4MyBatis;
import com.JustWe.mapper.DepartmentMapper;
import com.JustWe.mapper.Employee4MyBatisMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeptController {

    @Autowired
    DepartmentMapper departmentMapper;

    @Autowired
    Employee4MyBatisMapper employee4MyBatisMapper;

    @GetMapping("/dept/{id}")
    public Department getDepartment(@PathVariable("id") Integer id) {
        return departmentMapper.getDeptById(id);
    }

    @GetMapping("/dept")
    public Department insertDepartment(Department department) {
        departmentMapper.insertDept(department);
        return department;
    }

    @GetMapping("/emp/mybatis/{id}")
    public Employee4MyBatis getEmp(@PathVariable("id") Integer id) {
        return employee4MyBatisMapper.getEmpById(id);
    }


}
