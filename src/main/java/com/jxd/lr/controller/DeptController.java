package com.jxd.lr.controller;

import com.jxd.lr.model.Dept;
import com.jxd.lr.model.Emp;
import com.jxd.lr.service.IDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @ClassName DeptController
 * @Description TODO
 * @Author liushijing
 * @Date 2023/1/28
 * @Version 1.0
 */
@RestController
public class DeptController {
    @Autowired
    private IDeptService deptService;
    @RequestMapping("/deptList")
    public List<Dept> deptList(){
        return deptService.deptList();
    }

    @RequestMapping("/deptInfo")
    public Map<String,Object> getAllDeptInfo(@RequestBody Map<String,String> map){
        return deptService.getAllDeptInfo(map);
    }
    @RequestMapping("/addDept")
    public String addDept(@RequestBody Dept dept){

        if(deptService.addDept(dept)){
            return "success";
        }else{
            return "error";
        }
    }

    @RequestMapping("/updateDept")
    public String updateDept(@RequestBody Dept dept){

        if(deptService.updateDept(dept)){
            return "success";
        }else{
            return "error";
        }
    }

    @RequestMapping("/delBatchDept")
    public String deleteBatchDept(@RequestBody int[] deptnos){

        if(deptService.deleteBatchDept(deptnos)){
            return "success";
        }else{
            return "error";
        }
    }

    @RequestMapping("/delDept")
    public String deleteDept(@RequestParam int deptno){

        if(deptService.deleteDept(deptno)){
            return "success";
        }else{
            return "error";
        }
    }

}
