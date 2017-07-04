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
     * 说明        : 主菜单查询方法，去除了未配置且没有子菜单的一级模块
     * @return
     * 创建日期 ： 2017年7月4日
     * 创建人     ： Administrator
     */
    public LinkedHashMap<MdModule, List<MdModule>> getAllModuleForMenu() {
        //被配置的一级模块（上级结点为0）
    	Map<String, Object> params = new HashMap<String, Object>();
		params.put("parentRowid", "0");
		params.put("selectedFlag", "1");
		params.put("haveChild", "1");
        List<MdModule> firstModules = dao.selectModuleByParams(params);
        LinkedHashMap<MdModule, List<MdModule>> resultModuleMap = new LinkedHashMap<MdModule, List<MdModule>>();
        for (MdModule mdModule : firstModules) {
        	//所属被配置的二级模块
        	params.put("parentRowid", mdModule.getRowId().toString());
        	params.put("haveChild", "0");
            List<MdModule> moduleList = dao.selectModuleByParams(params);
            resultModuleMap.put(mdModule, moduleList);
        }
        return resultModuleMap;
    }

    /**
     * 
     * 说明        : 已配置所有模块查询
     * @return
     * 创建日期 ： 2017年7月4日
     * 创建人     ： Administrator
     */
    public LinkedHashMap<MdModule, List<MdModule>> getAllModuleForSelected() {
        //被配置的一级模块（上级结点为0）
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("parentRowid", "0");
        params.put("selectedFlag", "1");
        List<MdModule> firstModules = dao.selectModuleByParams(params);
        LinkedHashMap<MdModule, List<MdModule>> resultModuleMap = new LinkedHashMap<MdModule, List<MdModule>>();
        for (MdModule mdModule : firstModules) {
            //所属被配置的二级模块
            params.put("parentRowid", mdModule.getRowId().toString());
            List<MdModule> moduleList = dao.selectModuleByParams(params);
            resultModuleMap.put(mdModule, moduleList);
        }
        return resultModuleMap;
    }

}
