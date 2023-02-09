package com.jxd.lr.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jxd.lr.model.Dept;

import java.util.List;
import java.util.Map;

public interface IDeptService extends IService<Dept> {
    List<Dept> deptList();
    Map<String, Object> getAllDeptInfo(Map<String,String> queryMap);

    boolean addDept(Dept Dept);

    boolean updateDept(Dept dept);

    boolean deleteBatchDept(int[] deptnos);
    boolean deleteDept(int deptno);

}
