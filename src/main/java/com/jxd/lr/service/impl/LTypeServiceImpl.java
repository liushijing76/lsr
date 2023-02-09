package com.jxd.lr.service.impl;

import com.jxd.lr.dao.LTypeMapper;
import com.jxd.lr.dao.LoanMapper;
import com.jxd.lr.model.LoanRecord;
import com.jxd.lr.model.LoanType;
import com.jxd.lr.service.ILTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName LTypeServiceImpl
 * @Description TODO
 * @Author liushijing
 * @Date 2023/2/1
 * @Version 1.0
 */
@Service
public class LTypeServiceImpl implements ILTypeService {
    @Autowired
    private LTypeMapper lTypeMapper;
    @Autowired
    private LoanMapper loanMapper;
    @Override
    public List<LoanType> getLoanTypeList() {
        return lTypeMapper.getLoanTypeList();
    }

    @Override
    public boolean addLoanType(LoanType loanType) {
        return lTypeMapper.addLoanType(loanType);
    }

    @Override
    public boolean updateLoanType(LoanType loanType) {
        return lTypeMapper.updateLoanType(loanType);
    }

    @Override
    public String deleteLoanType(LoanType loanType) {
        int count = loanMapper.judge(loanType);
        if(count > 0){
            return "error01";
        }
        if(lTypeMapper.deleteLoanType(loanType)){
            return "success";
        }else {
            return "error02";
        }

    }
}
