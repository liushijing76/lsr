package com.jxd.lr.dao;

import com.jxd.lr.model.Emp;
import com.jxd.lr.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    List<User> selectUser(User user);

    int getUname(String uname);

    boolean addUser(@Param("uname")String uname, @Param("password") String password,@Param("empno") Integer empno);

    boolean deleteBatchUser(int[] empnos);

    boolean updatePwd(@Param("password")String password,@Param("empno")String empno);

    List<User> getEmpno(String uname);


}
