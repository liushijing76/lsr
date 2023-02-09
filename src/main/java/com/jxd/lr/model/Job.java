package com.jxd.lr.model;

/**
 * @ClassName Job
 * @Description TODO
 * @Author liushijing
 * @Date 2023/1/29
 * @Version 1.0
 */
public class Job {
    private Integer jobno;
    private String jname;

    public Job() {
    }

    public Job(Integer jobno, String jname) {
        this.jobno = jobno;
        this.jname = jname;
    }

    public Integer getJobno() {
        return jobno;
    }

    public void setJobno(Integer jobno) {
        this.jobno = jobno;
    }

    public String getJname() {
        return jname;
    }

    public void setJname(String jname) {
        this.jname = jname;
    }
}
