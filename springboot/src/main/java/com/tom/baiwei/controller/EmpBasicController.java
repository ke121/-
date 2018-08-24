package com.tom.baiwei.controller;

import com.tom.baiwei.model.Employee;
import com.tom.baiwei.model.RespBean;
import com.tom.baiwei.service.EmpService;
import com.tom.baiwei.utils.PoiUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/employee/basic")
public class EmpBasicController {
    @Autowired
    EmpService empService ;
        @GetMapping("/emp")
        public List<Employee> getEmp(@RequestParam(defaultValue = "1")Integer currentPage , @RequestParam(defaultValue = "10")Integer pageSize,@RequestParam(defaultValue = "") String keywords){
            return empService.getEmpPageByKeywords(currentPage, pageSize, keywords) ;
        }
        @DeleteMapping("/emp/{ids}")
        public RespBean delete(@PathVariable("ids") String ids){
            Boolean result = empService.deleteEmpByIds(ids);
            RespBean respBean = null ;
            if(result){
                respBean = RespBean.ok("删除成功") ;
            }else{
                respBean =  RespBean.error("删除成功") ;
            }
            return respBean ;
        }

        @GetMapping("/export")
        public ResponseEntity<byte[]> exportExcel() throws IOException {
            List<Employee> employees = empService.getEmpPageByKeywords(null, null, "");
            ResponseEntity<byte[]> entity = PoiUtils.exportExcel(employees);
            return  entity ;
        }

}
