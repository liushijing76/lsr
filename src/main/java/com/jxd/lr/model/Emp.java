package com.jxd.lr.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

/**
 * @ClassName Emp
 * @Description TODO
 * @Author liushijing
 * @Date 2023/1/28
 * @Version 1.0
 */
public class Emp {
    @TableId(value = "empno",type = IdType.AUTO)
    private Integer empno;
    private String ename;
    private String sex;
    private Integer jobno;
    private String hiredate;
    private Integer deptno;
    private String  mpno;
    private String idno;
    private String uname;

    public Emp() {
    }

    public Emp(Integer empno, String ename, String sex, Integer jobno, String hiredate, Integer deptno, String mpno, String idno, String uname) {
        this.empno = empno;
        this.ename = ename;
        this.sex = sex;
        this.jobno = jobno;
        this.hiredate = hiredate;
        this.deptno = deptno;
        this.mpno = mpno;
        this.idno = idno;
        this.uname = uname;
    }

    public Integer getEmpno() {
        return empno;
    }

    public void setEmpno(Integer empno) {
        this.empno = empno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getJobno() {
        return jobno;
    }

    public void setJobno(Integer jobno) {
        this.jobno = jobno;
    }

    public String getHiredate() {
        return hiredate;
    }

    public void setHiredate(String hiredate) {
        this.hiredate = hiredate;
    }

    public Integer getDeptno() {
        return deptno;
    }

    public void setDeptno(Integer deptno) {
        this.deptno = deptno;
    }

    public String getMpno() {
        return mpno;
    }

    public void setMpno(String mpno) {
        this.mpno = mpno;
    }

    public String getIdno() {
        return idno;
    }

    public void setIdno(String idno) {
        this.idno = idno;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }
}
