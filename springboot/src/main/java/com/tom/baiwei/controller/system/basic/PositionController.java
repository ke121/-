package com.tom.baiwei.controller.system.basic;

import com.tom.baiwei.model.Position;
import com.tom.baiwei.model.RespBean;
import com.tom.baiwei.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/system/basic/position")
public class PositionController {
    @Autowired
    PositionService positionService ;
    @GetMapping("/")
    public List<Position> getAllPosition(@RequestParam(value = "keywords", defaultValue = "") String keywords){
        return positionService.getAllPosition(keywords) ;
    }

    @PostMapping("/")
    public RespBean addPosition(Position position){
        int result = positionService.addPosition(position) ;
        RespBean respBean = null ;
        if(result == 1){
            respBean =  RespBean.ok("添加成功") ;
            return respBean ;
        }else {
            respBean =  RespBean.error("添加失败") ;
            return respBean ;
        }
    }
}
