package com.jxd.lr.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jxd.lr.model.Dept;
import com.jxd.lr.model.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface DeptMapper extends BaseMapper<Dept> {
    List<Dept> getAllDeptList();
    IPage<Dept> getAllDeptInfo(IPage<Dept> page, @Param("dname") String dname);

    boolean addDept(Dept dept);

    boolean updateDept(Dept dept);

    boolean deleteBatchDept(int[] deptnos);

    boolean deleteDept(int deptno);

}
