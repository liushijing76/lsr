package com.jxd.lr.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jxd.lr.dao.LoanMapper;
import com.jxd.lr.dao.RepayMapper;
import com.jxd.lr.model.Emp;
import com.jxd.lr.model.LoanRecord;
import com.jxd.lr.model.RepayRecord;
import com.jxd.lr.service.IRepayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName RepayServiceImpl
 * @Description TODO
 * @Author liushijing
 * @Date 2023/2/2
 * @Version 1.0
 */
@Service
public class RepayServiceImpl implements IRepayService {
    @Autowired
    private RepayMapper repayMapper;
    @Autowired
    private LoanMapper loanMapper;


    @Override
    public boolean addRepayRecord(Map<String, String> map) {
        return repayMapper.addRepayRecord(map);
    }

    @Override
    public Map<String, Object> getRepayRecordList(Map<String, String> queryMap) {
        String page = queryMap.get("page");
        String limit = queryMap.get("limit");
        String uname = queryMap.get("uname");
        String lnos = queryMap.get("lno");
        int lno = 0;
        if(!"".equals(lnos)){
            lno = Integer.parseInt(lnos);
        }

        Map<String, Object> map = new HashMap(4);
        if(page != null && limit != null){
            IPage<RepayRecord> pages = new Page(Integer.parseInt(page),Integer.parseInt(limit));
            IPage<RepayRecord> pageResult = repayMapper.getRepayRecordList(pages,uname,lno);
            map.put("count",pageResult.getTotal());
            map.put("data",pageResult.getRecords());
            map.put("code",0);
            return map;
        }else {
            map.put("data", (Object) null);
            map.put("code", "500");
            map.put("msg", "参数不符");
            map.put("count", (Object) null);
            return map;
            }
    }

    @Override
    public Map<String, Object> mGetRepayRecordList(Map<String, Object> queryMap) {
        String page = (queryMap.get("page")).toString();
        String limit = (queryMap.get("limit")).toString();
        String uname = (queryMap.get("uname")).toString();
        String ename = (queryMap.get("ename")).toString();

        String time1 = "";
        String time2 = "";
        if(queryMap.get("timeinterval") instanceof List ){
            List<String> timeinterval = (List<String>)queryMap.get("timeinterval");
            time1 = timeinterval.get(0);
            time2 = timeinterval.get(1);
        }

        Map<String, Object> map = new HashMap(4);
        if(page != null && limit != null){
            IPage<RepayRecord> pages = new Page(Integer.parseInt(page),Integer.parseInt(limit));
            IPage<RepayRecord> pageResult = repayMapper.mGetRepayRecordList(pages,uname,ename,time1,time2);
            map.put("count",pageResult.getTotal());
            map.put("data",pageResult.getRecords());
            map.put("code",0);
            return map;
        }else {
            map.put("data", (Object) null);
            map.put("code", "500");
            map.put("msg", "参数不符");
            map.put("count", (Object) null);
            return map;
        }
    }

    @Override
    public Map<String, Object> fGetRepayRecordList(Map<String, Object> queryMap) {
        String page = (queryMap.get("page")).toString();
        String limit = (queryMap.get("limit")).toString();
        String ename = (queryMap.get("ename")).toString();

        String time1 = "";
        String time2 = "";
        if(queryMap.get("timeinterval") instanceof List ){
            List<String> timeinterval = (List<String>)queryMap.get("timeinterval");
            time1 = timeinterval.get(0);
            time2 = timeinterval.get(1);
        }

        Map<String, Object> map = new HashMap(4);
        if(page != null && limit != null){
            IPage<RepayRecord> pages = new Page(Integer.parseInt(page),Integer.parseInt(limit));
            IPage<RepayRecord> pageResult = repayMapper.fGetRepayRecordList(pages,ename,time1,time2);
            map.put("count",pageResult.getTotal());
            map.put("data",pageResult.getRecords());
            map.put("code",0);
            return map;
        }else {
            map.put("data", (Object) null);
            map.put("code", "500");
            map.put("msg", "参数不符");
            map.put("count", (Object) null);
            return map;
        }
    }

    @Override
    public boolean submitEmpRepay(Map<String, String> map) {
        String lno = map.get("lno");
        String rsno = "";
        List<LoanRecord> repayRecords = loanMapper.getLBalance(lno);
        Integer lbalance = repayRecords.get(0).getLbalance();
        if(lbalance < 2000) {
            rsno = "3";
        } else {
            rsno = "2";
        }
        map.put("rsno",rsno);
        return repayMapper.submitEmpRepay(map);
    }

    @Override
    public boolean submitManagerRepay(Map<String, String> map) {
        String  rsno = "3";
        map.put("rsno",rsno);
        return repayMapper.submitEmpRepay(map);
    }


    @Override
    public boolean deleteBatchEmpRepay(int[] rnos) {
        return repayMapper.deleteBatchEmpRepay(rnos);
    }

    @Override
    public boolean mExamineEmpRepay(Map<String, String> map) {
        return repayMapper.mExamineEmpRepay(map);
    }

    @Override
    public boolean deleteBatchEmpnoRepay(int[] lnos) {
        return repayMapper.deleteBatchEmpnoRepay(lnos);
    }


}
