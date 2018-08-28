package com.tom.baiwei.mapper;

import com.tom.baiwei.model.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleMapper {
    public List<Role> getRolesByHrId(Integer hrId) ;

    List<Role> getAllRoles();

    int addRole(Role role);

    int deleteRolesById(Integer id);

    int insertRoles(@Param("rolesId") String[] rolesId, @Param("id") Integer id);
}
