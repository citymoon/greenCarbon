package com.dhb.platform.dao;

import com.dhb.platform.entity.OrgRightlist;

public interface OrgRightlistMapper {
    int insert(OrgRightlist record);

    int insertSelective(OrgRightlist record);
}