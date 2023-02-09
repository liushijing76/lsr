package com.jxd.lr.service;

import com.jxd.lr.model.RepayRecord;

import java.util.List;
import java.util.Map;

public interface IRepayService {


    boolean addRepayRecord(Map<String,String> map);

    Map<String, Object> getRepayRecordList(Map<String,String> map);

    Map<String, Object> mGetRepayRecordList(Map<String,Object> map);

    Map<String, Object> fGetRepayRecordList(Map<String,Object> map);

    boolean submitEmpRepay(Map<String,String> map);

    boolean submitManagerRepay(Map<String,String> map);

    boolean deleteBatchEmpRepay(int[] rnos);

    boolean mExamineEmpRepay(Map<String,String> map);

    boolean deleteBatchEmpnoRepay(int[] lnos);
}
