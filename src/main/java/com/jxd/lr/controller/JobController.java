package com.jxd.lr.controller;

import com.jxd.lr.model.Job;
import com.jxd.lr.service.IJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName JobController
 * @Description TODO
 * @Author liushijing
 * @Date 2023/1/29
 * @Version 1.0
 */
@RestController
public class JobController {
    @Autowired
    private IJobService jobService;

    @RequestMapping("/jobList")
    public List<Job> getJobList() {
        return jobService.getJobList();
    }
}
