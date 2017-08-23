package com.dhb.platform.dao;

import java.util.HashMap;

import com.dhb.platform.entity.OaKeysTab;

public interface OaKeysTabMapper {
    int insert(OaKeysTab record);

    int insertSelective(OaKeysTab record);
    
    HashMap<String, String> selectMaxId(String tableName);
    
    void updateMaxid(String tableName);

    //int updateByExampleSelective(@Param("record") OaKeysTab record, @Param("example") OaKeysTabExample example);

    //int updateByExample(@Param("record") OaKeysTab record, @Param("example") OaKeysTabExample example);
}