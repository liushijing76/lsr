package com.jxd.lr.model;

/**
 * @ClassName User
 * @Description TODO
 * @Author liushijing
 * @Date 2023/1/23
 * @Version 1.0
 */
public class User {
    private Integer uid;
    private String uname;
    private String password;

    private Integer empno;


    public User() {
    }

    public User(Integer uid, String uname, String password, Integer empno) {
        this.uid = uid;
        this.uname = uname;
        this.password = password;
        this.empno = empno;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getEmpno() {
        return empno;
    }

    public void setEmpno(Integer empno) {
        this.empno = empno;
    }
}
