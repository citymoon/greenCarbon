package com.dhb.platform.service;

import java.util.Map;

import com.dhb.platform.entity.MdSystem;

public interface IMdSystemService {
    
    public MdSystem getMdSystemByOne();
    
    public void updMdSystemById(Map<String, Object> params);

}
