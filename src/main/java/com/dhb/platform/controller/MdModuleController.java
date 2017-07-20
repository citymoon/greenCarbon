package com.dhb.platform.controller;

import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dhb.platform.entity.MdModule;
import com.dhb.platform.service.IMdModuleService;

@Controller
@RequestMapping("/module")
public class MdModuleController {
    
    @Resource
    IMdModuleService mdModuleService;
    

    /**
     * 
     * 说明 : 根据不同的参数，查询系统模块信息并定位到相应视图
     * @param key    menu-系统主菜单  conf-系统当前配置    其它-系统所有模块
     * @param model  
     * @return
     * 创建日期： 2017年7月5日
     * 创建人    ： Administrator
     */
    @RequestMapping(value="/getAllModuleForKey/{key}")
    public ModelAndView getAllModuleForKey(@PathVariable("key") String key,Model model){
        LinkedHashMap<MdModule, List<MdModule>> modules = mdModuleService.getAllModuleForKey(key);
        model.addAttribute("modules",modules);
        if(key.equalsIgnoreCase("menu")){
            return new ModelAndView("moduleIndex","model",model);
        }else if(key.equalsIgnoreCase("conf")){
            //return new ModelAndView("sysconf/moduleTree","model",model);
            return new ModelAndView("sysconf/moduleConfig","model",model);
        }else{
            return new ModelAndView("sysconf/moduleReconfig","model",model);
        }
    }
    
    @RequestMapping("/moveup")
    public ModelAndView moveUp(HttpServletRequest request,String rowId,Model model){
        if(StringUtils.isBlank(rowId))
            rowId = "";
        boolean status = mdModuleService.moveUp(rowId);
        if(status){
            LinkedHashMap<MdModule, List<MdModule>> modules = mdModuleService.getAllModuleForKey("reconfig");
            model.addAttribute("modules",modules);
            return new ModelAndView("sysconf/moduleReconfig","model",model);
        }
        return new ModelAndView("sysconf/moduleReconfig","error", "fail");
    }

    @RequestMapping("/moveupjson")
    public @ResponseBody Model moveUpJson(HttpServletRequest request,String rowId,Model model){
        if(StringUtils.isBlank(rowId))
            rowId = "";
        boolean status = mdModuleService.moveUp(rowId);
        if(status){
            LinkedHashMap<MdModule, List<MdModule>> modules = mdModuleService.getAllModuleForKey("reconfig");
            model.addAttribute("modules",modules);
            return model;
        }
        model.addAttribute("error", "fail");
        return model;
    }
    
}
