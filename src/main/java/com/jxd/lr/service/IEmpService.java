package com.jxd.lr.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jxd.lr.model.Emp;
import com.jxd.lr.model.User;

import java.util.Map;

public interface IEmpService extends IService<Emp> {
    Map<String, Object> getAllEmpList(Map<String,String> map);

    int addEmp(Emp emp);

    boolean updateEmp(Emp emp);

    boolean deleteBatchEmp(int[] empnos);

    Map<String, Object> getPerInfo(String uname);

    boolean updateMpno(String mpno,String empno);
}
