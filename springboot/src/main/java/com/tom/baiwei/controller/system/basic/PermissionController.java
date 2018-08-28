package com.tom.baiwei.controller.system.basic;

import com.tom.baiwei.model.Menu;
import com.tom.baiwei.model.RespBean;
import com.tom.baiwei.model.Role;
import com.tom.baiwei.service.MenuService;
import com.tom.baiwei.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/system/basic/permission")
public class PermissionController {
    @Autowired
    RoleService roleService ;
    @Autowired
    MenuService menuService ;
    @GetMapping("/")
    public List<Role> getAllRoles(){
        return roleService.getAllRoles();
    }

    @GetMapping("/menus")
    public List<Menu> getMenuTree(){
        return  menuService.getMenuTree() ;
    }

    @GetMapping("/menusChecked")
    public List<Integer> getMenusChecked(Integer rid){
        return menuService.getMenusChecked(rid) ;
    }

    @PostMapping("/addRole")
    public RespBean addRole(Role role){
        int result = roleService.addRole(role) ;
        RespBean respBean = null ;
        if(result ==1){
            respBean = RespBean.ok("添加成功") ;
            return  respBean ;
        }
        return  RespBean.error("添加失败") ;
    }

}
