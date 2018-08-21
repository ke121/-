package com.tom.baiwei.service;

import com.tom.baiwei.model.Menu;
import com.tom.baiwei.mapper.MenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@CacheConfig(cacheNames = "c1")

@Service
public class MenuService {
    @Autowired
    MenuMapper mapper ;
    public List<Menu> getMenusByHrId(Integer id){
        return mapper.getMenusByHrId(id) ;
    }

    @Cacheable(key = "#root.method.name")
    public List<Menu> getAllMenus() {
       return mapper.getAllMenus() ;
    }

    ;
}
