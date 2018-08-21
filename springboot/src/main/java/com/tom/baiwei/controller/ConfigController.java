package com.tom.baiwei.controller;


import com.tom.baiwei.model.Menu;
import com.tom.baiwei.model.Role;
import com.tom.baiwei.service.MenuService;
import com.tom.baiwei.service.RoleService;
import com.tom.baiwei.utils.HrUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ConfigController {
    @Autowired
    RoleService roleService ;

    @GetMapping("/role")
    public List<Role> getRoles(Integer id){
       return  roleService.getRolesByHrId(id) ;
    }

    @Autowired
    MenuService menuService ;
    @GetMapping("/config/menus")
    public  List<Menu> getMenus(){
        System.out.println(menuService.getMenusByHrId(HrUtils.getCurrentUser().getId())) ;
        return  menuService.getMenusByHrId(HrUtils.getCurrentUser().getId()) ;
    }

    @GetMapping("/menus")
    public  List<Menu> getMenusAndRoles(){
        return  menuService.getAllMenus();
    }
    @GetMapping("/employee/basic/hello1")
    public  String hello1(){
        return "/employee/basic/hello1" ;
    }
    @GetMapping("/employee/basic/hello2")
    public  String hello2(){
        return "/employee/basic/hello2" ;
    }
    @GetMapping("/employee/advanced/hello")
    public  String hello3(){
        return "/employee/advanced/hello" ;
    }
}
