package com.tom.baiwei.controller;

import com.tom.baiwei.model.JobLevel;
import com.tom.baiwei.model.RespBean;
import com.tom.baiwei.service.JobLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/system/basic/jobLevel")
public class JobLevelController {

    @Autowired
    JobLevelService jobLevelService ;
    @GetMapping("/")
    public List<JobLevel> getAllJobLevels(){
        System.out.println("===========================");
        return jobLevelService.getAllJobLevels() ;
    }

    @PostMapping("/")
    public RespBean addJl(@RequestBody JobLevel jobLevel){
        Date date = new Date() ;
        jobLevel.setEnabled(true);
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd") ;
//        final String format = simpleDateFormat.format(date);
        jobLevel.setCreatedate(date);
        int result = jobLevelService.addJl(jobLevel) ;
        RespBean respBean = null ;
        if(result ==1){
            respBean = RespBean.ok("添加成功") ;
            return  respBean ;
        }
        return  RespBean.error("添加失败") ;
    }
}
