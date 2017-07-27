package com.dhb.platform.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.dhb.platform.entity.MdModule;

@Repository
public interface MdModuleMapper {
    int insert(MdModule record);

    int insertSelective(MdModule record);
    
    List<MdModule> selectModuleByParams(Map<String, Object> params);
    
    MdModule selectModuleByPrimaryKey(String rowId);
    
    List<MdModule> selectModuleLessShowSequence(String rowId);
    
    List<MdModule> selectModuleGrtShowSequence(String rowId);
    
    void updateByPrimaryKey(MdModule record);
    
    void updateIsConfigByPrimaryKeys(List<String> rowIds);
    
    void updateIsConfigByNotPrimaryKeys(List<String> rowIds);
}