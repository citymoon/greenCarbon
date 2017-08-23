package com.dhb.platform.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.dhb.platform.dao.MdModuleMapper;
import com.dhb.platform.entity.MdModule;
import com.dhb.platform.service.IMdModuleService;
import com.dhb.platform.service.IOaKeysTab;

@Service
public class MdModuleServiceImpl implements IMdModuleService {
    
    private static final Logger log = LoggerFactory.getLogger(MdModuleServiceImpl.class);

    @Resource
    MdModuleMapper dao;
    
    @Resource
    IOaKeysTab oaKeysTabService;
    
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

    /**
     * 
     * 说明        : 主菜单查询方法，去除了未配置且没有子菜单的一级模块
     * @return
     * 创建日期 ： 2017年7月4日
     * 创建人     ： dhb
     */
    public LinkedHashMap<MdModule, List<MdModule>> getAllModuleForMenu() {
        return null;
    }

    /**
     * 
     * 说明        : 已配置所有模块查询
     * @return
     * 创建日期 ： 2017年7月4日
     * 创建人     ： dhb
     */
    public LinkedHashMap<MdModule, List<MdModule>> getAllModuleForSelected() {
        return null;
    }

    /**
     * 
     * 说明      ： 查询一级模块
     * @param parentRowid=0
     * @return
     * 创建日期： 2017年7月28日
     * 创建人    ： dhb
     */
    public Map<String, List<MdModule>> getFirstModule(){
        //一级模块（上级结点为0）
        Map<String, Object> params = new HashMap<String, Object>();
        Map<String, List<MdModule>> resultModules = new HashMap<String, List<MdModule>>();
        //一级内部模块
        params.put("parentRowid", "0");
        params.put("intranetFlag", "1");
        resultModules.put("firstInnerModules",dao.selectModuleByParams(params));
        //一级外部模块
        params.put("intranetFlag", "0");
        resultModules.put("firstOuterModules",dao.selectModuleByParams(params));
        return resultModules;
    }

    /**
     * 
     * 说明      ： 向上移动
     * @param rowId
     * @return
     * 创建日期： 2017年7月26日
     * 创建人    ： dhb
     */
    public boolean moveUp(String rowId) {
        boolean status = false;
        MdModule module = dao.selectModuleByPrimaryKey(rowId);
        List<MdModule> moduleList = dao.selectModuleLessShowSequence(rowId);
        if(moduleList != null && moduleList.size()>0){
            status = moveModule(module,moduleList);
        }
        return status;
    }
    
    /**
     * 
     * 说明      ： 向下移动
     * @param rowId
     * @return
     * 创建日期： 2017年7月26日
     * 创建人    ： dhb
     */
    public boolean moveDown(String rowId) {
        boolean status = false;
        MdModule module = dao.selectModuleByPrimaryKey(rowId);
        List<MdModule> moduleList = dao.selectModuleGrtShowSequence(rowId);
        if(moduleList != null && moduleList.size()>0){
            status = moveModule(module,moduleList);
        }
        return status;
    }
    
    public boolean moveModule(MdModule module,List<MdModule> moduleList) {
        boolean status = false;
        try{
            MdModule moduleold = moduleList.get(0);
            String temp = module.getShowSequence();
            module.setShowSequence(moduleold.getShowSequence());
            moduleold.setShowSequence(temp);
            dao.updateByPrimaryKey(module);
            dao.updateByPrimaryKey(moduleold);
            status = true;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return status;
    }

    /**
     * 
     * 说明 : 系统中所有模块查询，包装一级为map-key，二级为map-value
     * @return
     * 创建日期： 2017年7月26日
     * 创建人    ： dhb
     */
    public Map<String, Object> getAllModuleForKey() {
        //一级模块（上级结点为0）
        Map<String, Object> params = new HashMap<String, Object>();
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        params.put("parentRowid", "0");

        List<MdModule> firstModules = dao.selectModuleByParams(params);
        
        for (MdModule mdModule : firstModules) {
            params.put("parentRowid", mdModule.getRowId());
            String keyString = mdModule.getRowId()+","+mdModule.getMdNewName()+","+mdModule.getMdName()+","+mdModule.getMdCode()+","+mdModule.getIntranetFlag()+","+mdModule.getSelectedFlag();
            resultMap.put(keyString, dao.selectModuleByParams(params));
        }
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
    public Map<String, Object> configComplete(List<String> rowIds) {
        try {
            dao.updateIsConfigByPrimaryKeys(rowIds);
            dao.updateIsConfigByNotPrimaryKeys(rowIds);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return getAllModuleForKey();
    }

    /**
     * 
     * 说明      ： 增加新模块
     * @param request
     * @return 是否成功的标志
     * 创建日期： 2017年8月16日
     * 创建人    ： dhb
     */
    public Map<String, Object> addModule(HttpServletRequest request) {
        String status = "";
        MdModule module = new MdModule();
        Map<String, Object> resultMap = new HashMap<String, Object>();
        try{
            //初始化保存的对象
            module.setRowId(oaKeysTabService.selectRowidFromTableName("MD_MODULE"));
            module.setMdName(request.getParameter("mdNewName").toString());
            module.setMdNewName(request.getParameter("mdNewName").toString());
            module.setMdCode(request.getParameter("mdCode").toString());
            module.setMdUrl(request.getParameter("mdUrl").toString());
            String parentrowid ="";
            if(request.getParameter("moduleLevel").toString().equalsIgnoreCase("1")){
                module.setParentRowid("0");
                parentrowid = "0";
            }else{
                module.setParentRowid(request.getParameter("firstModule").toString());
                parentrowid = request.getParameter("firstModule").toString();
            }
            module.setShowSequence(parentrowid);
            module.setSelectedFlag("1");
            module.setIsSystemMd("1");
            module.setHaveChild("0");
            module.setIntranetFlag(request.getParameter("intranetFlag").toString());
            module.setOasysFlag("0");
            module.setActiveFlag("1");
            
            Date objDate=new Date();
            SimpleDateFormat objFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String datestrString = objFormat.format(objDate);
            module.setCreateDate(objFormat.parse(datestrString));
            
            //查重判断(名称、编码、URL)
            if(dao.selectRepeatModuleByParams(module).size()>0){
                resultMap.put("status", "repeat");
                resultMap.put("params", module);
            }else{
                dao.insertSelective(module);
                resultMap.put("status", "success");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return resultMap;
    }
}
