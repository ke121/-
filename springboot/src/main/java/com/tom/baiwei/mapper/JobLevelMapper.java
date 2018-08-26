package com.tom.baiwei.mapper;

import com.tom.baiwei.model.JobLevel;

import java.util.List;

public interface JobLevelMapper {
    List<JobLevel> getAllJobLevels();

    int addJl(JobLevel jobLevel);
}
