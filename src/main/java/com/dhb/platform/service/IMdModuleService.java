package com.dhb.platform.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.dhb.platform.entity.MdModule;

public interface IMdModuleService {
    
    /**
     * 
     * 说明        : 主菜单查询方法，去除了未配置且没有子菜单的一级模块
     * @return
     * 创建日期 ： 2017年7月4日
     * 创建人     ： Administrator
     */
    public LinkedHashMap<MdModule, List<MdModule>> getAllModuleForMenu();
    
    /**
     * 
     * 说明        : 已配置所有模块查询
     * @return
     * 创建日期 ： 2017年7月4日
     * 创建人     ： Administrator
     */
    public LinkedHashMap<MdModule, List<MdModule>> getAllModuleForSelected();
    
    public LinkedHashMap<MdModule, List<MdModule>> getAllModuleForKey(String key); 
    
    public Map<String, Object> getAllModuleForKey();
    
    public boolean moveUp(String rowId);
    
    public boolean moveDown(String rowId);

}
