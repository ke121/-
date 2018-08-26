package com.tom.baiwei.service;

import com.tom.baiwei.mapper.DepartmentMapper;
import com.tom.baiwei.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepService {
    @Autowired
    DepartmentMapper mapper ;
    public List<Department> getAllDeps(Integer id){
        return mapper.getAllDeps(id) ;
    }

    public List<Department> getAllDepsNoTree() {
        return  mapper.getAllDepsNoTree() ;
    }

    public void addDep(Department department) {
        mapper.addDep(department) ;
    }

    public void del(Department department) {
        mapper.del(department) ;
    }
}
