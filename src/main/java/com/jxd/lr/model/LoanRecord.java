package com.jxd.lr.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

/**
 * @ClassName LoanRecord
 * @Description TODO
 * @Author liushijing
 * @Date 2023/2/1
 * @Version 1.0
 */
public class LoanRecord {
    @TableId(value = "lno",type = IdType.AUTO)
    private Integer lno;
    private Integer ltno;
    private Integer lbalance;
    private String ltime;
    private Integer lsno;
    private Integer empno;
    private String lcause;
    private String lsname;
    private Integer stillrepay;
    private String ename;

    public LoanRecord() {
    }

    public LoanRecord(Integer lno, Integer ltno, Integer lbalance, String ltime, Integer lsno, Integer empno, String lcause, String lsname, Integer stillrepay, String ename) {
        this.lno = lno;
        this.ltno = ltno;
        this.lbalance = lbalance;
        this.ltime = ltime;
        this.lsno = lsno;
        this.empno = empno;
        this.lcause = lcause;
        this.lsname = lsname;
        this.stillrepay = stillrepay;
        this.ename = ename;
    }

    public Integer getLno() {
        return lno;
    }

    public void setLno(Integer lno) {
        this.lno = lno;
    }

    public Integer getLtno() {
        return ltno;
    }

    public void setLtno(Integer ltno) {
        this.ltno = ltno;
    }

    public Integer getLbalance() {
        return lbalance;
    }

    public void setLbalance(Integer lbalance) {
        this.lbalance = lbalance;
    }

    public String getLtime() {
        return ltime;
    }

    public void setLtime(String ltime) {
        this.ltime = ltime;
    }

    public Integer getLsno() {
        return lsno;
    }

    public void setLsno(Integer lsno) {
        this.lsno = lsno;
    }

    public Integer getEmpno() {
        return empno;
    }

    public void setEmpno(Integer empno) {
        this.empno = empno;
    }

    public String getLcause() {
        return lcause;
    }

    public void setLcause(String lcause) {
        this.lcause = lcause;
    }

    public String getLsname() {
        return lsname;
    }

    public void setLsname(String lsname) {
        this.lsname = lsname;
    }

    public Integer getStillrepay() {
        return stillrepay;
    }

    public void setStillrepay(Integer stillrepay) {
        this.stillrepay = stillrepay;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }
}
