package com.JustWe;

import com.JustWe.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

// 继承JpaRepository来完成对数据库的操作（泛型参数第一个为实体类，第二个为主键类型）
public interface UserRepository extends JpaRepository<User, Integer>{

}
