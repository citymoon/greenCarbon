package com.dhb.platform.service.impl;

import java.util.HashMap;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.dhb.platform.dao.OaKeysTabMapper;
import com.dhb.platform.service.IOaKeysTab;
import com.dhb.platform.util.DateTimeUtil;

@Service
public class OaKeysTabServiceImpl implements IOaKeysTab {
    
    private static final Logger log = LoggerFactory.getLogger(OaKeysTabServiceImpl.class);

    @Resource
    OaKeysTabMapper dao;

    @Override
    public String selectRowidFromTableName(String tableName) {
        HashMap<String, String> resultMap = dao.selectMaxId(tableName);
        String rowid = "";
        if(!resultMap.isEmpty()){
            String year = DateTimeUtil.getNowYear();
            String month = DateTimeUtil.getNowMonth();
            String maxid = String.valueOf(resultMap.get("keylpaded"));
            String zeroNum = "";
            int zeroLength = 16-year.length()-month.length()-maxid.length();
            for(int i=0;i<zeroLength;i++){
                zeroNum += "0";
            }
            rowid = year+month+zeroNum+maxid;
            log.debug("Generates ROW_ID="+rowid);
            if(rowid.length() != 16){
                log.error("Generates ROW_ID length is not 16!!");
                return "";
            }
            dao.updateMaxid(tableName);
        }
        return rowid;
    }

}
