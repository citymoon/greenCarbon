package com.dhb.platform.service.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dhb.platform.dao.MdSystemMapper;
import com.dhb.platform.entity.MdSystem;
import com.dhb.platform.service.IMdSystemService;

@Service
public class MdSystemServiceImpl implements IMdSystemService {

    @Resource
    MdSystemMapper dao;
    
    public void updMdSystemById(Map<String, Object> params) {
        dao.updateById(params);
    }

    public MdSystem getMdSystemByOne() {
        MdSystem mdSystem = dao.selectOneRow();
        return mdSystem;
    }

}
