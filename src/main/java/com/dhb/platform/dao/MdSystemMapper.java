package com.dhb.platform.dao;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.dhb.platform.entity.MdModule;
import com.dhb.platform.entity.MdSystem;

@Repository
public interface MdSystemMapper {
    
    MdSystem selectOneRow();

    int updateById(Map<String, Object> params);
}