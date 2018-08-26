package com.tom.baiwei.service;

import com.tom.baiwei.mapper.JobLevelMapper;
import com.tom.baiwei.model.JobLevel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobLevelService {

    @Autowired
    JobLevelMapper mapper ;
    public List<JobLevel> getAllJobLevels() {
        return mapper.getAllJobLevels() ;
    }

    public int addJl(JobLevel jobLevel) {
        return  mapper.addJl(jobLevel) ;
    }
}
