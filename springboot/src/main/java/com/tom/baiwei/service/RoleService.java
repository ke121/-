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

    public List<Role> getAllRoles() {
       return  mapper.getAllRoles() ;
    }

    public int addRole(Role role) {
       return mapper.addRole(role) ;
    }

    public boolean updateRoles(String [] rolesId , Integer id) {
       int result =  mapper.deleteRolesById(id) ;
       if(result >= 1){
           return mapper.insertRoles(rolesId , id)>=1 ;
       }
       return false ;
    }
}
