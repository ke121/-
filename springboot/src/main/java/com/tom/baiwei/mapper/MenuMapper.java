package com.tom.baiwei.mapper;

import com.tom.baiwei.model.Menu;

import java.util.List;

public interface MenuMapper {
    List<Menu> getMenusByHrId(Integer id);

    List<Menu> getAllMenus();
}
