package com.dhb.platform.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.dhb.platform.entity.MdModule;

@Repository
public interface MdModuleMapper {
    int insert(MdModule record);

    int insertSelective(MdModule record);
    
    /**
     * 
     * 说明      ： 根据参数列表查询模块
     * @param params--parentRowid,selectedFlag,haveChild,intranetFlag
     * @return
     * 创建日期： 2017年7月28日
     * 创建人    ： dhb
     */
    List<MdModule> selectModuleByParams(Map<String, Object> params);
    
    MdModule selectModuleByPrimaryKey(String rowId);
    
    List<MdModule> selectRepeatModuleByParams(MdModule mdModule);
    
    List<MdModule> selectModuleLessShowSequence(String rowId);
    
    List<MdModule> selectModuleGrtShowSequence(String rowId);
    
    String selectNewShowSequenceByParentRowid(String parentRowid);
    
    void updateByPrimaryKey(MdModule record);
    
    void updateIsConfigByPrimaryKeys(List<String> rowIds);
    
    void updateIsConfigByNotPrimaryKeys(List<String> rowIds);
    
    void updateByParams(MdModule mdModule);
    
    void deleteByPrimaryKey(String rowId);
}