package com.jxd.lr.controller;


import com.jxd.lr.dao.LoanMapper;
import com.jxd.lr.model.Emp;
import com.jxd.lr.model.LoanRecord;
import com.jxd.lr.service.IEmpService;
import com.jxd.lr.service.ILoanService;
import com.jxd.lr.service.IRepayService;
import com.jxd.lr.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName EmpController
 * @Description TODO
 * @Author liushijing
 * @Date 2023/1/28
 * @Version 1.0
 */
@RestController
public class EmpController {
    @Autowired
    private IEmpService empService;
    @Autowired
    private IUserService userService;
    @Autowired
    private ILoanService loanService;
    @Autowired
    private IRepayService repayService;
    @RequestMapping("/list")
    public Map<String,Object> list(@RequestBody Map<String,String> map){
        return empService.getAllEmpList(map);
    }

    @RequestMapping("/addEmp")
    @Transactional
    public String addEmp(@RequestBody Emp emp){
        String uname = emp.getUname();
        //判断用户是否重复
        if(userService.getUname(uname) > 0){
            return "error01";
        }
        String password = "123456";
        //影响的行数
        int k = empService.addEmp(emp);
        Integer empno = emp.getEmpno();
        if(userService.addUser(uname,password,empno)){
            return "success";
        }else{
            return "error";
        }
    }

    @RequestMapping("/updateEmp")
    public String updateEmp(@RequestBody Emp emp){

        if(empService.updateEmp(emp)){
            return "success";
        }else{
            return "error";
        }
    }

    @RequestMapping("/delBatchEmp")
    @Transactional
    public String deleteBatchEmp(@RequestBody int[] empnos){
        for (int i = 0; i < empnos.length; i++) {
            //判断是否存在借还款流程记录
           if(loanService.judgeRecord(empnos[i]) > 0){
               return "error02";
           }
        }
        List<LoanRecord> loanRecords = loanService.selectLnos(empnos);
        if(loanRecords.size() == 0){
            if(userService.deleteBatchUser(empnos)){
                if(empService.deleteBatchEmp(empnos)){
                    return "success";
                }else{
                    return "error";
                }
            } else {
                return  "error";
            }
        } else {
            int[] lnos = new int[loanRecords.size()];
            for (int i = 0; i < lnos.length; i++) {
                lnos[i] = loanRecords.get(i).getLno();
            }
            boolean flag1 = repayService.deleteBatchEmpnoRepay(lnos);
            boolean flag2 = loanService.deleteBatchEmpnoLoan(empnos);
            boolean flag3 = userService.deleteBatchUser(empnos);
            boolean flag4 = empService.deleteBatchEmp(empnos);
            if(flag1 && flag2 && flag3 && flag4){
                return "success";
            }else {
                return "error";
            }

        }
    }

    @RequestMapping("/getPerInfo")
    public Map<String,Object> getPerInfo(@RequestParam String uname){
        Map<String, Object> perInfo = empService.getPerInfo(uname);

        return perInfo;
    }

    @RequestMapping("/updateMpno")
    public String updateMpno(@RequestBody Map<String,String> map){
        String mpno = map.get("mpno");
        String empno = map.get("empno");
        if(empService.updateMpno(mpno,empno)){
            return "success";
        }else{
            return "error";
        }
    }

    @RequestMapping("/updatePwd")
    public String updatePwd(@RequestBody Map<String,String> map){
        String password = map.get("password");
        String empno = map.get("empno");
        if(userService.updatePwd(password,empno)){
            return "success";
        }else{
            return "error";
        }
    }

    @RequestMapping("/resetUserPwd")
    public String resetUserPwd(@RequestParam String empno){
        String password = "123456";
        if(userService.updatePwd(password,empno)){
            return "success";
        }else{
            return "error";
        }
    }
}
