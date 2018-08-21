package com.tom.baiwei.mapper;

import com.tom.baiwei.model.Role;

import java.util.List;

public interface RoleMapper {
    public List<Role> getRolesByHrId(Integer hrId) ;
}
