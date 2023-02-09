package com.jxd.lr.service.impl;

import com.jxd.lr.dao.EmpMapper;
import com.jxd.lr.dao.UserMapper;
import com.jxd.lr.model.Emp;
import com.jxd.lr.model.User;
import com.jxd.lr.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.handler.UserRoleAuthorizationInterceptor;

import java.util.List;
import java.util.Map;

/**
 * @ClassName IUserServiceImpl
 * @Description TODO
 * @Author liushijing
 * @Date 2023/1/23
 * @Version 1.0
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private EmpMapper empMapper;
    @Override
    public String login(User user) {
        List<User> list = userMapper.selectUser(user);
        if(list.size() == 0){
            return "error";
        }
        Integer empno = list.get(0).getEmpno();
         if(empno == null){
             return "success";
         } else {
             List<Emp> empList = empMapper.getEmp(empno);
             Integer deptno = empList.get(0).getDeptno();
             if(deptno == 3){
                return "success04";
             } else {
                 Integer jobno = empList.get(0).getJobno();
                 if (jobno == 1){
                     return "success03";
                 } else {
                     return "success02";
                 }
             }
         }
    }

    @Override
    public int getUname(String uname) {

        return userMapper.getUname(uname);
    }

    @Override
    public boolean addUser(String uname, String password, Integer empno) {
        return userMapper.addUser(uname,password,empno);
    }

    @Override
    public boolean deleteBatchUser(int[] empnos) {
        return userMapper.deleteBatchUser(empnos);
    }

    @Override
    public boolean updatePwd(String password, String empno) {
        return userMapper.updatePwd(password,empno);
    }

    @Override
    public Integer getEmpno(String uname) {
        List<User> list = userMapper.getEmpno(uname);
        Integer empno = list.get(0).getEmpno();
        return empno;
    }


}
