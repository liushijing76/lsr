package com.jxd.lr.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jxd.lr.model.Emp;
import com.jxd.lr.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface EmpMapper extends BaseMapper<Emp> {
    IPage<Emp> getAllEmpList(IPage<Emp> page, @Param("ename") String ename, @Param("deptno") int deptno);

    int  addEmp(Emp emp);


    boolean updateEmp(Emp emp);

    boolean deleteBatchEmp(int[] empnos);

    int selectEmpCount(int deptno);

    List<Emp> getEmp(Integer empno);

    Map<String,Object> getPerInfo(String uname);

    boolean updateMpno(@Param("mpno")String mpno,@Param("empno")String empno);
}
