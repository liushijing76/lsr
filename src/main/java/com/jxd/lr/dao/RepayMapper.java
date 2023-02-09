package com.jxd.lr.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jxd.lr.model.RepayRecord;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface RepayMapper {


    boolean addRepayRecord(Map<String,String> map);

    IPage<RepayRecord> getRepayRecordList(IPage<RepayRecord> page, @Param("uname") String uname, @Param("lno") int lno);


    IPage<RepayRecord> mGetRepayRecordList(IPage<RepayRecord> page, @Param("uname") String uname,@Param("ename")String ename,@Param("time1") String time1,@Param("time2")String time2);

    IPage<RepayRecord> fGetRepayRecordList(IPage<RepayRecord> page,@Param("ename")String ename,@Param("time1") String time1,@Param("time2")String time2);

    boolean submitEmpRepay(Map<String,String> map);

    boolean deleteBatchEmpRepay(int[] rnos);

    boolean mExamineEmpRepay(Map<String,String> map);

    boolean deleteBatchEmpnoRepay(int[] lnos);
}
