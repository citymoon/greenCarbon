package com.dhb.platform.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
     * 创建人    ： dhb
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
    
    /**
     * 
     * 说明 : 向上移动
     * @param rowId 主键
     * @return
     * 创建日期： 2017年7月26日
     * 创建人    ： dhb
     */
    @RequestMapping("/moveupjson")
    @ResponseBody
    public  Map<String, Object> moveUpJson(String rowId){
        if(StringUtils.isBlank(rowId))
            rowId = "";
        boolean status = mdModuleService.moveUp(rowId);
        Map<String, Object> resultMap = new HashMap<String, Object>();
        if(status){
            resultMap = moveResult(rowId);
        }else{
            resultMap.put("error", "fail");
        }
        return resultMap;
    }
 
    /**
     * 
     * 说明 : 向下移动
     * @param rowId 主键
     * @return
     * 创建日期： 2017年7月26日
     * 创建人    ： dhb
     */
    @RequestMapping("/movedownjson")
    @ResponseBody
    public  Map<String, Object> moveDownJson(String rowId){
        if(StringUtils.isBlank(rowId))
            rowId = "";
        boolean status = mdModuleService.moveDown(rowId);
        Map<String, Object> resultMap = new HashMap<String, Object>();
        if(status){
            resultMap = moveResult(rowId);
        }else{
            resultMap.put("error", "fail");
        }
        return resultMap;
    }
    
    /**
     * 
     * 说明 : 成功移动结点后的结果数据
     * @param rowId 主键
     * @return
     * 创建日期： 2017年7月26日
     * 创建人    ： dhb
     */
    public  Map<String, Object> moveResult(String rowId){
        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("rowid", rowId);
        resultMap.put("result",mdModuleService.getAllModuleForKey());
        return resultMap;
    }
    
    /**
     * 
     * 说明      ： 更新模块的是否配置属性
     * @param rowIds  已选择的主键
     * @return
     * 创建日期： 2017年7月27日
     * 创建人    ： dhb
     */
    @RequestMapping("/completejson")
    @ResponseBody
    public Map<String, Object> configComplete(String rowIds){
        Map<String, Object> resultMap = new HashMap<String, Object>();
        List<String> tempRowids = new ArrayList<String>();
        if(StringUtils.isBlank(rowIds)){
            resultMap.put("result",mdModuleService.getAllModuleForKey());
            return resultMap;
        } else {
            for (String rowid : rowIds.split(",")) {
                tempRowids.add(rowid);
            }
        }
        resultMap.put("result",mdModuleService.configComplete(tempRowids));
        return resultMap;
    }

}
