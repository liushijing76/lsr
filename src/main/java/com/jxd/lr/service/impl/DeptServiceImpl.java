package com.jxd.lr.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jxd.lr.dao.DeptMapper;
import com.jxd.lr.dao.EmpMapper;
import com.jxd.lr.model.Dept;

import com.jxd.lr.service.IDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName DeptServiceImpl
 * @Description TODO
 * @Author liushijing
 * @Date 2023/1/28
 * @Version 1.0
 */
@Service
public class DeptServiceImpl extends ServiceImpl<DeptMapper,Dept> implements IDeptService  {
    @Autowired
    private DeptMapper deptMapper;
    @Autowired
    private EmpMapper empMapper;

    /**
     * 获取部门下拉列表
     * @return
     */
    @Override
    public List<Dept> deptList(){
        return deptMapper.getAllDeptList();
    }

    /**
     * 获取部门信息包含员工数量
     * @param queryMap
     * @return
     */
    @Override
    public Map<String, Object> getAllDeptInfo(Map<String,String> queryMap) {
        String page = queryMap.get("page");
        String limit = queryMap.get("limit");
        String dname = queryMap.get("dname");


        Map<String, Object> map = new HashMap(4);
        if(page != null && limit != null){
            IPage<Dept> pages = new Page(Integer.parseInt(page),Integer.parseInt(limit));
            IPage<Dept> pageResult = deptMapper.getAllDeptInfo(pages,dname);
            map.put("count",pageResult.getTotal());
            map.put("data",pageResult.getRecords());
            map.put("code",0);
            return map;
        }else{
            map.put("data", (Object)null);
            map.put("code", "500");
            map.put("msg", "参数不符");
            map.put("count", (Object)null);
            return map;
        }

    }

    @Override
    public boolean addDept(Dept dept) {
        return deptMapper.addDept(dept);
    }

    @Override
    public boolean updateDept(Dept dept) {
        return deptMapper.updateDept(dept);
    }

    /**
     * 批量删除
     * @param deptnos
     * @return
     */
    @Override
    public boolean deleteBatchDept(int[] deptnos) {
        return deptMapper.deleteBatchDept(deptnos);
    }

    @Override
    public boolean deleteDept(int deptno) {
        int num = empMapper.selectEmpCount(deptno);
        if(num > 0){
            return false;
        }
        return deptMapper.deleteDept(deptno);
    }


}
