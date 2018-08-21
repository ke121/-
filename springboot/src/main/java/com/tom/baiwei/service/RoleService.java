package com.tom.baiwei.service;

import com.tom.baiwei.mapper.RoleMapper;
import com.tom.baiwei.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    @Autowired
    RoleMapper mapper;
   public   List<Role> getRolesByHrId(Integer id){
       return  mapper.getRolesByHrId(id) ;
    }
}
