package com.tom.baiwei.service;

import com.tom.baiwei.mapper.PositionMapper;
import com.tom.baiwei.model.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PositionService {
    @Autowired
    PositionMapper mapper ;
    public List<Position> getAllPosition(String keywords){
        return mapper.getAllPosition(keywords) ;
    }

    public int addPosition(Position position) {
        position.setCreatedate(new Date());
        return mapper.addPosition(position) ;
    }
}
