package com.dhb.platform.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.dhb.platform.entity.JbdpUser;

@Repository
public interface JbdpUserMapper {
    int deleteByPrimaryKey(String userId);

    int insert(JbdpUser jbdpUser);

    int insertSelective(JbdpUser record);

    JbdpUser selectByPrimaryKey(String userId);
    
    JbdpUser selectByIdAndPass(Map<String, Object> params);
    
    List<JbdpUser> selectAllUsersByMybatis();
    
    List<JbdpUser> selectUsersByParams(Map<String, Object> params);

    int updateByPrimaryKeySelective(JbdpUser record);

    int updateByPrimaryKey(JbdpUser record);
}