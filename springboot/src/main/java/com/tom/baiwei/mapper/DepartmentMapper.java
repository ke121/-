package com.tom.baiwei.mapper;

import com.tom.baiwei.model.Department;

import java.util.List;

public interface DepartmentMapper {

    List<Department> getAllDeps(Integer id);

    List<Department> getAllDepsNoTree();

    void  addDep(Department department);

    void del(Department department);
}
