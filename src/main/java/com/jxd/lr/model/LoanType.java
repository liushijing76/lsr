package com.jxd.lr.model;

/**
 * @ClassName LoanType
 * @Description TODO
 * @Author liushijing
 * @Date 2023/2/1
 * @Version 1.0
 */
public class LoanType {
    private Integer ltno;
    private String ltype;

    public LoanType() {
    }

    public LoanType(Integer ltno, String ltype) {
        this.ltno = ltno;
        this.ltype = ltype;
    }

    public Integer getLtno() {
        return ltno;
    }

    public void setLtno(Integer ltno) {
        this.ltno = ltno;
    }

    public String getLtype() {
        return ltype;
    }

    public void setLtype(String ltype) {
        this.ltype = ltype;
    }
}
