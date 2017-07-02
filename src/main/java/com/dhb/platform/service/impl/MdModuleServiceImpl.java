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

    @Override
    public LinkedHashMap<MdModule, List<MdModule>> getAllModule() {
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
