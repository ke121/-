package com.tom.baiwei.mapper;

import com.tom.baiwei.model.Hr;

import java.util.List;


public interface HrMapper {

    Hr LoadUserByUsername(String username) ;

    List<Hr> getAllHr();

    int updateEnabled(Hr hr);
}
