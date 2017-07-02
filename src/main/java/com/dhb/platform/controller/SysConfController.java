package com.dhb.platform.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dhb.platform.entity.OaConfigTab;
import com.dhb.platform.service.IOaConfigService;

@Controller
@RequestMapping("/sysconf")
public class SysConfController {
    
    @Resource
    IOaConfigService oaConfigService;
    
    @RequestMapping("/index")
    public ModelAndView getSysConf(){
        OaConfigTab oaConfigTab = oaConfigService.getOaConfigTab();
        return new ModelAndView("sysconf/firstIndex", "oaConfigTab", oaConfigTab);
    }

}
