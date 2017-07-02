package com.dhb.platform.entity;

import java.math.BigDecimal;
import java.util.Date;

public class MdSystem {
    private Long rowId;

    private String sysCompName;

    private BigDecimal templateNo;

    private String bannerUrl;

    private String logoUrl;

    private BigDecimal configedFlag;

    private Date createDate;

    private String createBy;

    private Date lastUpdateDate;

    private String lastUpdateBy;

    private Short updateCount;

    private String attribute01;

    private String attribute02;

    public Long getRowId() {
        return rowId;
    }

    public void setRowId(Long rowId) {
        this.rowId = rowId;
    }

    public String getSysCompName() {
        return sysCompName;
    }

    public void setSysCompName(String sysCompName) {
        this.sysCompName = sysCompName == null ? null : sysCompName.trim();
    }

    public BigDecimal getTemplateNo() {
        return templateNo;
    }

    public void setTemplateNo(BigDecimal templateNo) {
        this.templateNo = templateNo;
    }

    public String getBannerUrl() {
        return bannerUrl;
    }

    public void setBannerUrl(String bannerUrl) {
        this.bannerUrl = bannerUrl == null ? null : bannerUrl.trim();
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl == null ? null : logoUrl.trim();
    }

    public BigDecimal getConfigedFlag() {
        return configedFlag;
    }

    public void setConfigedFlag(BigDecimal configedFlag) {
        this.configedFlag = configedFlag;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public String getLastUpdateBy() {
        return lastUpdateBy;
    }

    public void setLastUpdateBy(String lastUpdateBy) {
        this.lastUpdateBy = lastUpdateBy == null ? null : lastUpdateBy.trim();
    }

    public Short getUpdateCount() {
        return updateCount;
    }

    public void setUpdateCount(Short updateCount) {
        this.updateCount = updateCount;
    }

    public String getAttribute01() {
        return attribute01;
    }

    public void setAttribute01(String attribute01) {
        this.attribute01 = attribute01 == null ? null : attribute01.trim();
    }

    public String getAttribute02() {
        return attribute02;
    }

    public void setAttribute02(String attribute02) {
        this.attribute02 = attribute02 == null ? null : attribute02.trim();
    }
}