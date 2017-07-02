package com.dhb.platform.service;

import java.util.LinkedHashMap;
import java.util.List;

import com.dhb.platform.entity.MdModule;

public interface IMdModuleService {
    
    public LinkedHashMap<MdModule, List<MdModule>> getAllModule();

}
