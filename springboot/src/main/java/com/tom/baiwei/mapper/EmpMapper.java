package com.tom.baiwei.mapper;

import com.tom.baiwei.model.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmpMapper {
    public List<Employee> getEmpPageByKeywords(@Param("start")Integer start , @Param("pageSize") Integer pageSize,@Param("keywords") String keywords) ;

    int deleteEmpByIds(@Param("ids") String[] ids);
}
