package com.jxd.lr.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

/**
 * @ClassName Dept
 * @Description TODO
 * @Author liushijing
 * @Date 2023/1/28
 * @Version 1.0
 */
public class Dept {
    @TableId(value = "deptno",type = IdType.AUTO)
    private Integer deptno;
    private String dname;
    private String ctime;

    public Dept() {
    }

    public Dept(Integer deptno, String dname, String ctime) {
        this.deptno = deptno;
        this.dname = dname;
        this.ctime = ctime;
    }

    public Integer getDeptno() {
        return deptno;
    }

    public void setDeptno(Integer deptno) {
        this.deptno = deptno;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getCtime() {
        return ctime;
    }

    public void setCtime(String ctime) {
        this.ctime = ctime;
    }
}
