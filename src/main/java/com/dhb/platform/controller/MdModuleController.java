package com.dhb.platform.controller;

import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public ModelAndView getModuleIndex(Model model){
        return getAllModule(model);
    }
    
    @RequestMapping("/getAllModule")
    public ModelAndView getAllModule(Model model){
        LinkedHashMap<MdModule, List<MdModule>> modules = mdModuleService.getAllModule();
        model.addAttribute("modules",modules);
        return new ModelAndView("moduleIndex","model",model);
    }
    
    @RequestMapping("/reConfig")
    public ModelAndView reConfigModule(){
        
        return new ModelAndView("sysconf/moduleConfig","message","success....");
    }

}
