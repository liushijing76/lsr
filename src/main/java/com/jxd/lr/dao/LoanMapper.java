package com.jxd.lr.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jxd.lr.model.Lno;
import com.jxd.lr.model.LoanRecord;
import com.jxd.lr.model.LoanType;
import com.jxd.lr.model.RepayRecord;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @ClassName LoanMapper
 * @Description TODO
 * @Author liushijing
 * @Date 2023/2/1
 * @Version 1.0
 */
public interface LoanMapper extends BaseMapper<LoanRecord> {
    IPage<LoanRecord> getLoanRecordList(IPage<LoanRecord> page, @Param("lbalance") String lbalance, @Param("ltno") int ltno,@Param("empno")String empno);
    IPage<LoanRecord> mGetLoanRecordList(IPage<LoanRecord> page,@Param("ltno") int ltno,@Param("ename")String ename,@Param("uname") String uanme);

    IPage<LoanRecord> fGetLoanRecordList(IPage<LoanRecord> page,@Param("ltno") int ltno,@Param("ename")String ename);

    boolean addLoanRecord(Map<String,String> map);
    boolean updateLoanRecord(Map<String,String> map);

    boolean deleteBatchEmpLoan(int[] lnos);

    List<Lno> getAllLno(String uname);

    List<LoanRecord> getLBalance(String lno);

    boolean mExamineEmpLoan(Map<String,String> map);

    List<LoanRecord> selectRepay(String lno);

    int judgeProcess(String lno);

    boolean updateStillRepay(@Param("lno") String lno,@Param("stillrepay") Integer stillRepay, @Param("lsno") String lsno);

    int judge(LoanType loanType);

    int judgeRecord(int empno);

    boolean deleteBatchEmpnoLoan(int[] empnos);

    List<LoanRecord> selectLnos(int[] empnos);
}
