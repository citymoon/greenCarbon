package com.dhb.platform.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dhb.platform.dao.OaConfigTabMapper;
import com.dhb.platform.entity.OaConfigTab;
import com.dhb.platform.service.IOaConfigService;

@Service
public class OaConfigServiceImpl implements IOaConfigService {
    
    @Resource
    OaConfigTabMapper dao;

    public OaConfigTab getOaConfigTab() {
        OaConfigTab oaConfigTab = dao.selectOaConfig();
        return oaConfigTab;
    }

}
