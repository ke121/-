package com.tom.baiwei.mapper;

import com.tom.baiwei.model.Position;

import java.util.List;

public interface PositionMapper {

    List<Position> getAllPosition(String keywords);

    int addPosition(Position position);
}
