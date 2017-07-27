package com.dhb.platform.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.dhb.platform.entity.MdModule;

public interface IMdModuleService {
    
    /**
     * 
     * 说明        : 主菜单查询方法，去除了未配置且没有子菜单的一级模块
     * @return
     * 创建日期 ： 2017年7月4日
     * 创建人     ： dhb
     */
    public LinkedHashMap<MdModule, List<MdModule>> getAllModuleForMenu();
    
    /**
     * 
     * 说明        : 已配置所有模块查询
     * @return
     * 创建日期 ： 2017年7月4日
     * 创建人     ： dhb
     */
    public LinkedHashMap<MdModule, List<MdModule>> getAllModuleForSelected();
    
    /**
     * 
     * 说明：根据不同的参数，查询系统模块信息。
     * @param key menu-系统主菜单  conf-系统当前配置    其它-系统所有模块
     * 创建日期 ： 2017年7月4日
     * 创建人     ： dhb
     */
    public LinkedHashMap<MdModule, List<MdModule>> getAllModuleForKey(String key); 
    
    /**
     * 
     * 说明 : 系统中所有模块查询，包装一级为map-key，二级为map-value
     * @return
     * 创建日期： 2017年7月26日
     * 创建人    ： dhb
     */
    public Map<String, Object> getAllModuleForKey();
    
    /**
     * 
     * 说明      ： 向上移动
     * @param rowId  主键
     * @return
     * 创建日期： 2017年7月26日
     * 创建人    ： dhb
     */
    public boolean moveUp(String rowId);
    
    /**
     * 
     * 说明      ： 向下移动
     * @param rowId  主键
     * @return
     * 创建日期： 2017年7月26日
     * 创建人    ： dhb
     */
    public boolean moveDown(String rowId);
    
    /**
     * 
     * 说明      ： 更新模块的是否配置属性
     * @param rowIds  已选择的主键
     * @return
     * 创建日期： 2017年7月27日
     * 创建人    ： dhb
     */
    public Map<String, Object> configComplete(List<String> rowIds);

}
