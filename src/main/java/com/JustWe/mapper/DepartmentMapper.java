package com.JustWe.mapper;

import com.JustWe.entities.Department;
import org.apache.ibatis.annotations.*;

// 指定这是一个操作数据库的mapper
// 在启动类指定需要扫描的mapper，不用在每个接口写注解了
//@Mapper
public interface DepartmentMapper {

    @Select("SELECT * FROM department WHERE id=#{id}")
    Department getDeptById(Integer id);

    @Delete("DELETE FROM department WHERE id=#{id}")
    int deleteDeptById(Integer id);

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("INSERT INTO department(department_name) VALUES(#{departmentName})")
    int insertDept(Department department);

    @Update("UPDATE department SET department_name=#{departmentName} WHERE id=#{id}")
    int updateDept(Department department);

}
