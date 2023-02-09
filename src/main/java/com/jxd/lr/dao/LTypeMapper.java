package com.jxd.lr.dao;

import com.jxd.lr.model.LoanType;

import java.util.List;

public interface LTypeMapper {
    List<LoanType> getLoanTypeList();

    boolean addLoanType(LoanType loanType);
    boolean updateLoanType(LoanType loanType);
    boolean deleteLoanType(LoanType loanType);
}
