package com.JustWeDemo.aop_StaticProxy;

/**
 * 静态代理
 *
 */
public class UserDaoProxy implements IUserDao{

    private IUserDao target;

    public UserDaoProxy(IUserDao iuserDao) {
        this.target = iuserDao;
    }

    public void save() {
        System.out.println("开启事物...");
        target.save();
        System.out.println("关闭事物...");
    }


    public static void main(String[] args) {

        IUserDao userDao = new UserDao();
        IUserDao userDaoProxy = new UserDaoProxy(userDao);
        userDaoProxy.save();


    }


}
