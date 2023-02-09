package com.jxd.lr.service.impl;

import com.jxd.lr.dao.JobMapper;
import com.jxd.lr.model.Job;
import com.jxd.lr.service.IJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName JobServiceImpl
 * @Description TODO
 * @Author liushijing
 * @Date 2023/1/29
 * @Version 1.0
 */
@Service
public class JobServiceImpl implements IJobService {
    @Autowired
    private JobMapper jobMapper;
    @Override
    public List<Job> getJobList() {
        return jobMapper.getJobList();
    }
}
