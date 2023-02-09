package com.jxd.lr.service;



import com.baomidou.mybatisplus.extension.service.IService;
import com.jxd.lr.model.Dept;
import com.jxd.lr.model.Lno;
import com.jxd.lr.model.LoanRecord;
import com.jxd.lr.model.LoanType;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ILoanService extends IService<LoanRecord> {

    Map<String, Object> getLoanRecordList(Map<String,String> map);

    Map<String, Object> mGetLoanRecordList(Map<String, String> queryMap);

    Map<String, Object> fGetLoanRecordList(Map<String, String> queryMap);

    boolean addLoanRecord(Map<String,String> map);
    boolean updateLoanRecord(Map<String,String> map);

    boolean deleteBatchEmpLoan(int[] lnos);

    List<Lno> getAllLno(String uname);

    List<LoanRecord> selectRepay(String lno);

    int judgeProcess(Map<String,String> map);

    boolean mExamineEmpLoan(Map<String,String> map);

    boolean updateStillRepay(String lno,Integer stillRepay,String lsno);

    boolean deleteBatchEmpnoLoan(int[] empnos);

    int judge(LoanType loanType);

    int judgeRecord(int empno);

    List<LoanRecord> selectLnos(int[] empnos);
}
