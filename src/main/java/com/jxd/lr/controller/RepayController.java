package com.jxd.lr.controller;

import com.jxd.lr.model.Lno;
import com.jxd.lr.model.LoanRecord;
import com.jxd.lr.model.RepayRecord;
import com.jxd.lr.service.ILoanService;
import com.jxd.lr.service.IRepayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName RepayController
 * @Description TODO
 * @Author liushijing
 * @Date 2023/2/2
 * @Version 1.0
 */
@RestController
public class RepayController {
    @Autowired
    private IRepayService repayService;
    @Autowired
    private ILoanService loanService;



    @RequestMapping("/addRepayRecord")
    public String addRepayRecord(@RequestBody Map<String,String>map){
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String rtime = format.format(date);
        String stillrepay = map.get("lbalance");
        map.put("rtime",rtime);
        map.put("rsno","1");
        map.put("stillrepay",stillrepay);
        if(repayService.addRepayRecord(map)){
            return "success";
        } else {
            return "error";
        }
    }

    @RequestMapping("/getAllLno")
    public List<Lno> getAllLno(@RequestParam String uname){
        return loanService.getAllLno(uname);
    }

    @RequestMapping("/getRepayRecordList")
    public Map<String, Object> getRepayRecordList(@RequestBody Map<String,String> map){
        return repayService.getRepayRecordList(map);
    }

    @RequestMapping("/mGetRepayRecordList")
    public Map<String, Object> mGetRepayRecordList(@RequestBody Map<String,Object> map){
        return repayService.mGetRepayRecordList(map);
    }

    @RequestMapping("/fGetRepayRecordList")
    public Map<String, Object> fGetRepayRecordList(@RequestBody Map<String,Object> map){
        return repayService.fGetRepayRecordList(map);
    }


    @RequestMapping("/submitEmpRepay")
    public String submitEmpRepay(@RequestBody Map<String,String> map){
        if(repayService.submitEmpRepay(map)){
            return "success";
        } else {
            return "error";
        }
    }

    @RequestMapping("/submitManagerRepay")
    public String submitManagerRepay(@RequestBody Map<String,String> map){
        if(repayService.submitManagerRepay(map)){
            return "success";
        } else {
            return "error";
        }
    }

    @RequestMapping("/delBatchEmpRepay")
    public String delBatchEmpRepay(@RequestBody int[] rnos){
        if(repayService.deleteBatchEmpRepay(rnos)){
            return "success";
        } else {
            return "error";
        }
    }

    @RequestMapping("/mExamineEmpRepay")
    public String mExamineEmpRepay(@RequestBody Map<String,String> map){
        if(repayService.mExamineEmpRepay(map)){
            return "success";
        } else {
            return "error";
        }
    }

    @RequestMapping("/fExamineEmpRepay")
    @Transactional
    public String fExamineEmpRepay(@RequestBody Map<String,String> map){
        String lno = map.get("lno");
        String lsno = "5";
        List<LoanRecord> loanRecords = loanService.selectRepay(lno);
        Integer stillRepay = loanRecords.get(0).getStillrepay();
        if(map.get("rbalance") != null){
            Integer repay =Integer.valueOf(map.get("rbalance"));
            stillRepay = stillRepay - repay;
            if(stillRepay == 0){
                lsno = "7";
            } else {
                lsno = "6";
            }
        }

        if(repayService.mExamineEmpRepay(map)){
            if(loanService.updateStillRepay(lno,stillRepay,lsno)){
                return "success";
            } else {
                return "error";
            }
        } else {
            return "error";
        }
    }
}
