package com.jxd.lr.dao;

import com.jxd.lr.model.Job;

import java.util.List;

/**
 * @ClassName JobMapper
 * @Description TODO
 * @Author liushijing
 * @Date 2023/1/29
 * @Version 1.0
 */
public interface JobMapper {
    List<Job> getJobList();
}
