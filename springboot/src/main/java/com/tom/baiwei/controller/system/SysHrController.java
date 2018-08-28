package com.tom.baiwei.controller.system;

import com.tom.baiwei.model.Hr;
import com.tom.baiwei.model.RespBean;
import com.tom.baiwei.model.Role;
import com.tom.baiwei.service.HrService;
import com.tom.baiwei.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/system/hr")
public class SysHrController {
    @Autowired
    HrService hrService ;
    @Autowired
    RoleService roleService ;
    @GetMapping("/")
    public List<Hr>  getAllHr(){
        return hrService.getAllHr() ;
    }

    @PutMapping("/")
    public RespBean updateEnabled(Hr hr){
        int result =  hrService.updateEnabled(hr) ;
        RespBean respBean = null ;
        if(result ==1){
            respBean = RespBean.ok("修改成功" ) ;
            return  respBean ;
        }
        return  RespBean.error("修改失败") ;
    }

    @GetMapping("/roles")
    public List<Role> getAllRoles(){
            return  roleService.getAllRoles() ;
    }

    @PutMapping("/roles")
    public RespBean updateRoles(String rolesId, Integer id){
        String[] split = rolesId.split(",");
        boolean isUpdate = roleService.updateRoles(split,id) ;
        RespBean respBean = null ;
        if(isUpdate){
            respBean = RespBean.ok("修改成功" ) ;
            return  respBean ;
        }
        return  RespBean.error("修改失败") ;
    }
}
