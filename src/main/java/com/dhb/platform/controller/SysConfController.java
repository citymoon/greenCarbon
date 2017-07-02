package com.dhb.platform.controller;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dhb.platform.entity.MdModule;
import com.dhb.platform.entity.MdSystem;
import com.dhb.platform.entity.OaConfigTab;
import com.dhb.platform.service.IMdModuleService;
import com.dhb.platform.service.IMdSystemService;
import com.dhb.platform.service.IOaConfigService;

@Controller
@RequestMapping("/sysconf")
public class SysConfController {
    
    @Resource
    IOaConfigService oaConfigService;
    
    @Resource
    IMdSystemService mdSystemService;
    
    @Resource
    IMdModuleService mdModuleService;
    
    @RequestMapping("/index")
    public ModelAndView getSysConf(Model model){
        LinkedHashMap<MdModule, List<MdModule>> modules = mdModuleService.getAllModule();
        MdSystem mdSystem = mdSystemService.getMdSystemByOne();
        OaConfigTab oaConfigTab = oaConfigService.getOaConfigTab();
        model.addAttribute("sysCompName", mdSystem.getSysCompName());
        model.addAttribute("modules",modules);
        model.addAttribute("oaConfigTab",oaConfigTab);
        return new ModelAndView("sysconf/firstIndex", "model", model);
    }
    
    @RequestMapping("/update")
    public ModelAndView updSysConf(HttpServletRequest request,OaConfigTab oct){
    	String rowId = oct.getRowId().toString();
    	String sysCompName = request.getParameter("sysName");
    	if(StringUtils.isBlank(rowId))
            rowId = "";
        if(StringUtils.isBlank(sysCompName))
            sysCompName = "";
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("rowId", rowId);
        params.put("sysCompName", sysCompName);
        mdSystemService.updMdSystemById(params);
        return new ModelAndView("sysconf/firstIndex","message", "success!");
    }

}
