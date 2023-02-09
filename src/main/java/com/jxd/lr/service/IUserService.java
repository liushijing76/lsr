package com.jxd.lr.service;


import com.jxd.lr.model.User;

public interface IUserService {
    String login(User user);

    int getUname(String uname);

    boolean addUser(String uname,String password,Integer empno);

    boolean deleteBatchUser(int[] empnos);

    boolean updatePwd(String password,String empno);

    Integer getEmpno(String uname);
}
