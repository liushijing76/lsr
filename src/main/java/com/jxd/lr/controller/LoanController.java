package com.jxd.lr.controller;

import com.jxd.lr.model.LoanRecord;
import com.jxd.lr.model.RepayRecord;
import com.jxd.lr.service.ILoanService;
import com.jxd.lr.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName LoanController
 * @Description TODO
 * @Author liushijing
 * @Date 2023/2/1
 * @Version 1.0
 */
@RestController
public class LoanController {
    @Autowired
    private IUserService userService;
    @Autowired
    private ILoanService loanService;

    @RequestMapping("/getLoanRecordList")
    public Map<String,Object> getLoanRecordList(@RequestBody Map<String,String> map){
        String uname = map.get("uname");
        Integer empno = userService.getEmpno(uname);
        String empno01 = empno.toString();
        map.put("empno",empno01);
        return loanService.getLoanRecordList(map);
    }

    @RequestMapping("/mGetLoanRecordList")
    public Map<String,Object> mGetLoanRecordList(@RequestBody Map<String,String> map){
        return loanService.mGetLoanRecordList(map);
    }

    @RequestMapping("/fGetLoanRecordList")
    public Map<String,Object> fGetLoanRecordList(@RequestBody Map<String,String> map){
        return loanService.fGetLoanRecordList(map);
    }

    @RequestMapping("/addLoanRecord")
    public String addLoanRecord(@RequestBody Map<String,String> map){
        String uname = map.get("uname");
        Integer empno = userService.getEmpno(uname);
        String empno01 = empno.toString();
        map.put("empno",empno01);
        if(loanService.addLoanRecord(map)){
            return "success";
        } else {
            return "error";
        }
    }

    @RequestMapping("/updateLoanRecord")
    public String updateLoanRecord(@RequestBody Map<String,String> map){
        if(loanService.updateLoanRecord(map)){
            return "success";
        } else {
            return "error";
        }
    }

    @RequestMapping("/delBatchEmpLoan")
    @Transactional
    public String delBatchEmpLoan(@RequestBody int[] lnos){
        if(loanService.deleteBatchEmpLoan(lnos)){
            return "success";
        }else{
            return "error";
        }
    }

    @RequestMapping("/selectRepay")
    public Map<String,Object> selectRepay(@RequestBody Map<String,String> map) {
        String lno = map.get("lno");
        Map<String,Object> list = new HashMap<>();
        List<LoanRecord> repayRecords = loanService.selectRepay(lno);
        list.put("stillrepay",repayRecords.get(0).getStillrepay());
        return  list;
    }

    /*判断还款流程是否存在*/
    @RequestMapping("/judgeProcess")
    public String judgeProcess(@RequestBody Map<String,String> map){
        if(loanService.judgeProcess(map) == 0){
            return "success";
        } else {
            return "error";
        }
    }
    @RequestMapping("/mExamineEmpLoan")
    public String mExamineEmpLoan(@RequestBody Map<String,String> map){
        if(loanService.mExamineEmpLoan(map)){
            return "success";
        } else {
            return "error";
        }
    }

}
