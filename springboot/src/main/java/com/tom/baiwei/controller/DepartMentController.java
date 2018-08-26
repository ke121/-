package com.tom.baiwei.controller;

import com.tom.baiwei.model.Department;
import com.tom.baiwei.model.RespBean;
import com.tom.baiwei.service.DepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/system/basic/dep")
public class DepartMentController {
    @Autowired
    DepService depService ;
    @GetMapping("/")
    public List<Department>  getAllDeps(@RequestParam(value = "id" , defaultValue = "-1") Integer id){
            return depService.getAllDeps(id) ;
    }

    @GetMapping("/getAllDeps")
    public List<Department> getAllDepsNoTree(){
        return depService.getAllDepsNoTree();
    }

    @PostMapping("/")
    public RespBean addDep(Department department){
        depService.addDep(department) ;
        RespBean respBean = null ;
        if(department.getResult() == 1){
            respBean =  RespBean.ok("添加成功") ;
            respBean.setObj(department) ;
            return respBean ;
        }else {
            respBean =  RespBean.error("添加失败") ;
            return respBean ;
        }
    }

    @DeleteMapping("/")
    public  RespBean delDep(Department department){
        depService.del(department) ;
        RespBean respBean = null ;
        if(department.getResult() == 1){
            respBean =  RespBean.ok("删除成功") ;
            respBean.setObj(department) ;
            return respBean ;
        }else {
            respBean =  RespBean.error("删除失败") ;
            return respBean ;
        }
    }

}
