package com.dhb.platform.service.impl;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dhb.platform.dao.MdModuleMapper;
import com.dhb.platform.entity.JbdpUser;
import com.dhb.platform.entity.MdModule;
import com.dhb.platform.service.IMdModuleService;

@Service
public class MdModuleServiceImpl implements IMdModuleService {
    
    @Resource
    MdModuleMapper dao;
    
    /**
     * 
     * 说明：根据不同的参数，查询系统模块信息。
     * @param key menu-系统主菜单  conf-系统当前配置    其它-系统所有模块
     * @see com.dhb.platform.service.IMdModuleService#getAllModuleForKey(java.lang.String)
     */
    public LinkedHashMap<MdModule, List<MdModule>> getAllModuleForKey(String key) {
        //一级模块（上级结点为0）
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("parentRowid", "0");
        if(key.equalsIgnoreCase("menu")){
            //一级模块，被配置且有子模块
            params.put("selectedFlag", "1");
            params.put("haveChild", "1");
        }else if(key.equalsIgnoreCase("conf")){
            //一级模块，被配置
            params.put("selectedFlag", "1");
        }else{
            params.remove("selectedFlag");
        }
        List<MdModule> firstModules = dao.selectModuleByParams(params);
        LinkedHashMap<MdModule, List<MdModule>> resultModuleMap = new LinkedHashMap<MdModule, List<MdModule>>();
        params = new HashMap<String, Object>();
        if(key.equalsIgnoreCase("menu") || key.equalsIgnoreCase("conf")){
            //二级模块，被配置
            params.put("selectedFlag", "1");
        }
        for (MdModule mdModule : firstModules) {
            params.put("parentRowid", mdModule.getRowId().toString());
            List<MdModule> moduleList = dao.selectModuleByParams(params);
            resultModuleMap.put(mdModule, moduleList);
        }
        return resultModuleMap;
    }

    @Override
    public LinkedHashMap<MdModule, List<MdModule>> getAllModuleForMenu() {
        return null;
    }

    @Override
    public LinkedHashMap<MdModule, List<MdModule>> getAllModuleForSelected() {
        return null;
    }

}
