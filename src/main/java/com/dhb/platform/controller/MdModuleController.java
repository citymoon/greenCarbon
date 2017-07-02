package com.dhb.platform.controller;

import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dhb.platform.entity.MdModule;
import com.dhb.platform.service.IMdModuleService;

@Controller
@RequestMapping("/module")
public class MdModuleController {
    
    @Resource
    IMdModuleService mdModuleService;
    
    @RequestMapping("/moduleIndex")
    public ModelAndView getModuleIndex(){
        return getAllModule();
    }
    
    @RequestMapping("/getAllModule")
    public ModelAndView getAllModule(){
        LinkedHashMap<String, List<MdModule>> modules = mdModuleService.getAllModule();
        return new ModelAndView("moduleIndex","modules",modules);
    }

}
