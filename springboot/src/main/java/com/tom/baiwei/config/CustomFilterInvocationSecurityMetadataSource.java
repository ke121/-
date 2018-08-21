package com.tom.baiwei.config;

import com.tom.baiwei.model.Menu;
import com.tom.baiwei.model.Role;
import com.tom.baiwei.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import java.util.Collection;
import java.util.List;

@Component
public class CustomFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

    @Autowired
    MenuService menuService ;
    AntPathMatcher antPathMatcher = new AntPathMatcher() ;

    //根据用户当前的请求返回所需要的角色集合
    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {

        FilterInvocation filterInvocation = (FilterInvocation) o;
        String requestUrl = filterInvocation.getRequestUrl();//employ/advanced/hello ;
        List<Menu> allMenus = menuService.getAllMenus();
        for (int i = 0 ; i <  allMenus.size() ; i++){
            Menu menu = allMenus.get(i) ;
            if(antPathMatcher.match(menu.getUrl(), requestUrl)){
                List<Role> roles = menu.getRoles() ;
                String arr[] = new String[roles.size()] ;
                for (int j = 0; j < roles.size(); j++) {
                    arr[j] = roles.get(j).getName() ;
                }
                return SecurityConfig.createList(arr) ;
            }
        }
        return SecurityConfig.createList("ROLE_LOGIN") ;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
