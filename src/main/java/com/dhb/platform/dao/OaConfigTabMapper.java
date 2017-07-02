package com.dhb.platform.dao;

import org.springframework.stereotype.Repository;

import com.dhb.platform.entity.OaConfigTab;

@Repository
public interface OaConfigTabMapper {
    int insert(OaConfigTab record);

    int insertSelective(OaConfigTab record);
    
    OaConfigTab selectOaConfig();
}