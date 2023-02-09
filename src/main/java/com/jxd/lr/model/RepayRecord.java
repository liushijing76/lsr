package com.jxd.lr.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

/**
 * @ClassName RepayRecord
 * @Description TODO
 * @Author liushijing
 * @Date 2023/2/2
 * @Version 1.0
 */
public class RepayRecord {
    @TableId(value = "rno",type = IdType.AUTO)
    private Integer rno;
    private Integer lno;
    private Integer rbalance;
    private String rtime;
    private Integer rsno;

    private String rrcause;

    public RepayRecord() {
    }

    public RepayRecord(Integer rno, Integer lno, Integer rbalance, String rtime, Integer rsno, String rrcause) {
        this.rno = rno;
        this.lno = lno;
        this.rbalance = rbalance;
        this.rtime = rtime;
        this.rsno = rsno;
        this.rrcause = rrcause;
    }

    public Integer getRno() {
        return rno;
    }

    public void setRno(Integer rno) {
        this.rno = rno;
    }

    public Integer getLno() {
        return lno;
    }

    public void setLno(Integer lno) {
        this.lno = lno;
    }

    public Integer getRbalance() {
        return rbalance;
    }

    public void setRbalance(Integer rbalance) {
        this.rbalance = rbalance;
    }

    public String getRtime() {
        return rtime;
    }

    public void setRtime(String rtime) {
        this.rtime = rtime;
    }

    public Integer getRsno() {
        return rsno;
    }

    public void setRsno(Integer rsno) {
        this.rsno = rsno;
    }

    public String getRrcause() {
        return rrcause;
    }

    public void setRrcause(String rrcause) {
        this.rrcause = rrcause;
    }
}
