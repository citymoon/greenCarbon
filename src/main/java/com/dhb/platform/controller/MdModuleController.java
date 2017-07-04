package com.dhb.platform.controller;

import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dhb.platform.entity.MdModule;
import com.dhb.platform.service.IMdModuleService;

@Controller
@RequestMapping("/module")
public class MdModuleController {
    
    @Resource
    IMdModuleService mdModuleService;
    
//    @RequestMapping("/moduleIndex")
//    public ModelAndView getModuleIndex(Model model){
//        return getAllModuleForMenu(model);
//    }
//    
//    @RequestMapping("/getAllModuleForMenu")
//    public ModelAndView getAllModuleForMenu(Model model){
//        LinkedHashMap<MdModule, List<MdModule>> modules = mdModuleService.getAllModuleForMenu();
//        model.addAttribute("modules",modules);
//        return new ModelAndView("moduleIndex","model",model);
//    }
//    
//    @RequestMapping("/getAllModuleForSelected")
//    public ModelAndView getAllModuleForSelected(Model model){
//        LinkedHashMap<MdModule, List<MdModule>> modules = mdModuleService.getAllModuleForSelected();
//        model.addAttribute("modules",modules);
//        return new ModelAndView("sysconf/moduleConfig","model",model);
//    }
    
    @RequestMapping(value="/getAllModuleForKey/{key}",method=RequestMethod.GET)
    public ModelAndView getAllModuleForKey(@PathVariable("key") String key,Model model){
        LinkedHashMap<MdModule, List<MdModule>> modules = mdModuleService.getAllModuleForSelected();
        model.addAttribute("modules",modules);
        return new ModelAndView("sysconf/moduleConfig","model",model);
    }

    @RequestMapping("/reConfig")
    public ModelAndView reConfigModule(){
        
        return new ModelAndView("sysconf/moduleConfig","message","success....");
    }

}
