package com.jxd.lr.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jxd.lr.dao.EmpMapper;
import com.jxd.lr.dao.LoanMapper;
import com.jxd.lr.model.*;
import com.jxd.lr.service.ILoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName LoanServiceImpl
 * @Description TODO
 * @Author liushijing
 * @Date 2023/2/1
 * @Version 1.0
 */
@Service
public class LoanServiceImpl extends ServiceImpl<LoanMapper, LoanRecord> implements ILoanService  {
    @Autowired
    private LoanMapper loanMapper;
    @Override
    public Map<String, Object> getLoanRecordList(Map<String, String> queryMap) {
        String page = queryMap.get("page");
        String limit = queryMap.get("limit");
        String ename = queryMap.get("lbalance");
        String ltnos = queryMap.get("ltno");
        String empno = queryMap.get("empno");
        int ltno = 0;
        if(!"".equals(ltnos)){
            ltno = Integer.parseInt(ltnos);
        }

        Map<String, Object> map = new HashMap(4);
        if(page != null && limit != null){
            IPage<LoanRecord> pages = new Page(Integer.parseInt(page),Integer.parseInt(limit));
            IPage<LoanRecord> pageResult = loanMapper.getLoanRecordList(pages,ename,ltno,empno);
            map.put("count",pageResult.getTotal());
            map.put("data",pageResult.getRecords());
            map.put("code",0);
            return map;
        }else{
            map.put("data", (Object)null);
            map.put("code", "500");
            map.put("msg", "参数不符");
            map.put("count", (Object)null);
            return map;
        }
    }

    @Override
    public Map<String, Object> mGetLoanRecordList(Map<String, String> queryMap) {
        String page = queryMap.get("page");
        String limit = queryMap.get("limit");
        String ltnos = queryMap.get("ltno");
        String ename = queryMap.get("ename");
        String uname = queryMap.get("uname");
        int ltno = 0;
        if(!"".equals(ltnos)){
            ltno = Integer.parseInt(ltnos);
        }

        Map<String, Object> map = new HashMap(4);
        if(page != null && limit != null){
            IPage<LoanRecord> pages = new Page(Integer.parseInt(page),Integer.parseInt(limit));
            IPage<LoanRecord> pageResult = loanMapper.mGetLoanRecordList(pages,ltno,ename,uname);
            map.put("count",pageResult.getTotal());
            map.put("data",pageResult.getRecords());
            map.put("code",0);
            return map;
        }else{
            map.put("data", (Object)null);
            map.put("code", "500");
            map.put("msg", "参数不符");
            map.put("count", (Object)null);
            return map;
        }
    }

    @Override
    public Map<String, Object> fGetLoanRecordList(Map<String, String> queryMap) {
        String page = queryMap.get("page");
        String limit = queryMap.get("limit");
        String ltnos = queryMap.get("ltno");
        String ename = queryMap.get("ename");
        int ltno = 0;
        if(!"".equals(ltnos)){
            ltno = Integer.parseInt(ltnos);
        }

        Map<String, Object> map = new HashMap(4);
        if(page != null && limit != null){
            IPage<LoanRecord> pages = new Page(Integer.parseInt(page),Integer.parseInt(limit));
            IPage<LoanRecord> pageResult = loanMapper.fGetLoanRecordList(pages,ltno,ename);
            map.put("count",pageResult.getTotal());
            map.put("data",pageResult.getRecords());
            map.put("code",0);
            return map;
        }else{
            map.put("data", (Object)null);
            map.put("code", "500");
            map.put("msg", "参数不符");
            map.put("count", (Object)null);
            return map;
        }
    }


    @Override
    public boolean addLoanRecord(Map<String, String> map) {
        return loanMapper.addLoanRecord(map);
    }

    @Override
    public boolean updateLoanRecord(Map<String, String> map) {
        String stillRepay = map.get("lbalance");
        map.put("stillrepay",stillRepay);
        return loanMapper.updateLoanRecord(map);
    }

    @Override
    public boolean deleteBatchEmpLoan(int[] lnos) {
        return loanMapper.deleteBatchEmpLoan(lnos);
    }

    @Override
    public List<Lno> getAllLno(String uname) {
        return loanMapper.getAllLno(uname);
    }


    @Override
    public List<LoanRecord> selectRepay(String lno) {
        return loanMapper.selectRepay(lno);
    }

    @Override
    public int judgeProcess(Map<String, String> map) {
        String lno = map.get("lno");
        return loanMapper.judgeProcess(lno);
    }

    @Override
    public boolean mExamineEmpLoan(Map<String, String> map) {
        return loanMapper.mExamineEmpLoan(map);
    }

    @Override
    public boolean updateStillRepay(String lno, Integer stillRepay, String lsno) {
        return loanMapper.updateStillRepay(lno,stillRepay,lsno);
    }

    @Override
    public boolean deleteBatchEmpnoLoan(int[] empnos) {
        return loanMapper.deleteBatchEmpnoLoan(empnos);
    }

    @Override
    public int judge(LoanType loanType) {
        return loanMapper.judge(loanType);
    }

    @Override
    public int judgeRecord(int empno) {
        return loanMapper.judgeRecord(empno);
    }

    @Override
    public List<LoanRecord> selectLnos(int[] empnos){
        return  loanMapper.selectLnos(empnos);
    }
}
