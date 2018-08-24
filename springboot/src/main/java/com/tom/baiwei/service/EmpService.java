package com.tom.baiwei.service;

import com.tom.baiwei.mapper.EmpMapper;
import com.tom.baiwei.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpService {
    @Autowired
    EmpMapper mapper ;
    public List<Employee> getEmpPageByKeywords(Integer currentPage , Integer pageSize , String keywords){
        Integer start = null ;
        if(currentPage != null && pageSize != null){
             start = (currentPage - 1) * pageSize;
        }
        return  mapper.getEmpPageByKeywords(start, pageSize, keywords) ;
    }

    public Boolean deleteEmpByIds(String ids) {
        String[] split = ids.split(",");
        int result = mapper.deleteEmpByIds(split) ;
        return result==split.length ;
    }
}
