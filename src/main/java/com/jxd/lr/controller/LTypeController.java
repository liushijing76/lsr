package com.jxd.lr.controller;
import com.jxd.lr.model.Job;
import com.jxd.lr.model.LoanType;
import com.jxd.lr.service.ILTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.rtf.RTFEditorKit;
import java.util.List;
import java.util.Map;

/**
 * @ClassName LTypeController
 * @Description TODO
 * @Author liushijing
 * @Date 2023/2/1
 * @Version 1.0
 */
@RestController
public class LTypeController {
    @Autowired
    private ILTypeService lTypeService;

    @RequestMapping("/getLoanTypeList")
    public List<LoanType> getLoanTypeList() {
        return lTypeService.getLoanTypeList();
    }

    @RequestMapping("/addLoanType")
    public String addLoanType(@RequestBody LoanType loanType) {
        if(lTypeService.addLoanType(loanType)){
            return "success";
        }else {
            return "error";
        }
    }

    @RequestMapping("/updateLoanType")
    public String updateLoanType(@RequestBody LoanType loanType) {
        if(lTypeService.updateLoanType(loanType)){
            return "success";
        }else {
            return "error";
        }
    }

    @RequestMapping("/deleteLoanType")
    public String deleteLoanType(@RequestBody LoanType loanType) {
        return lTypeService.deleteLoanType(loanType);
    }
}
