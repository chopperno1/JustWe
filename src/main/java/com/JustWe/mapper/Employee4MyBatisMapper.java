package com.JustWe.mapper;

import com.JustWe.entities.Employee4MyBatis;

// @Mapper或者@MapperScan将接口扫描装配到容器中
public interface Employee4MyBatisMapper {

    Employee4MyBatis getEmpById(Integer id);

    void insertEmp(Employee4MyBatis employee4MyBatis);


}
