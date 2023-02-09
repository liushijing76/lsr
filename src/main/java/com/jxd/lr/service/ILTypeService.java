package com.jxd.lr.service;

import com.jxd.lr.model.LoanType;

import java.util.List;

public interface ILTypeService {
    List<LoanType> getLoanTypeList();

    boolean addLoanType(LoanType loanType);
    boolean updateLoanType(LoanType loanType);
    String deleteLoanType(LoanType loanType);
}
