package com.JustWe.entities;

import javax.persistence.*;

/**
 * 使用JPA注解配置映射关系
 *
 */
@Entity // 告诉JPA这是一个实体类（和数据表映射的类）
@Table(name = "tab_user") // 指定和哪个数据表对应，如果省略表名就是user
public class User {

    @Id // 主键
    @GeneratedValue(strategy = GenerationType.IDENTITY) //自增
    private Integer id;

    @Column(name = "last_name", length = 50) // 和数据表对应的列
    private String lastName;

    @Column // 省略默认列名就是属性名
    private String email;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public User(Integer id, String lastName, String email) {
        this.id = id;
        this.lastName = lastName;
        this.email = email;
    }

    public User() {

    }

    public void setId(Integer id) {

        this.id = id;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getId() {

        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }
}
