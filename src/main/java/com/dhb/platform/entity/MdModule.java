package com.dhb.platform.entity;

import java.util.Date;

public class MdModule {
    private String rowId;

    private String mdName;

    private String mdCode;

    private String parentRowid;

    private String selectedFlag;

    private String mdNewName;

    private String showSequence;

    private String mdUrl;

    private String isSystemMd;

    private String haveChild;

    private String intranetFlag;

    private String oasysFlag;

    private String activeFlag;

    private Date createDate;

    private String createBy;

    private Date lastUpdateDate;

    private String lastUpdateBy;

    private Short updateCount;

    private String attribute01;

    private String attribute02;

    public String getRowId() {
        return rowId;
    }

    public void setRowId(String rowId) {
        this.rowId = rowId;
    }

    public String getMdName() {
        return mdName;
    }

    public void setMdName(String mdName) {
        this.mdName = mdName == null ? null : mdName.trim();
    }

    public String getMdCode() {
        return mdCode;
    }

    public void setMdCode(String mdCode) {
        this.mdCode = mdCode == null ? null : mdCode.trim();
    }

    public String getParentRowid() {
        return parentRowid;
    }

    public void setParentRowid(String parentRowid) {
        this.parentRowid = parentRowid;
    }

    public String getSelectedFlag() {
        return selectedFlag;
    }

    public void setSelectedFlag(String selectedFlag) {
        this.selectedFlag = selectedFlag;
    }

    public String getMdNewName() {
        return mdNewName;
    }

    public void setMdNewName(String mdNewName) {
        this.mdNewName = mdNewName == null ? null : mdNewName.trim();
    }

    public String getShowSequence() {
        return showSequence;
    }

    public void setShowSequence(String showSequence) {
        this.showSequence = showSequence;
    }

    public String getMdUrl() {
        return mdUrl;
    }

    public void setMdUrl(String mdUrl) {
        this.mdUrl = mdUrl == null ? null : mdUrl.trim();
    }

    public String getIsSystemMd() {
        return isSystemMd;
    }

    public void setIsSystemMd(String isSystemMd) {
        this.isSystemMd = isSystemMd;
    }

    public String getHaveChild() {
        return haveChild;
    }

    public void setHaveChild(String haveChild) {
        this.haveChild = haveChild;
    }

    public String getIntranetFlag() {
        return intranetFlag;
    }

    public void setIntranetFlag(String intranetFlag) {
        this.intranetFlag = intranetFlag;
    }

    public String getOasysFlag() {
        return oasysFlag;
    }

    public void setOasysFlag(String oasysFlag) {
        this.oasysFlag = oasysFlag;
    }

    public String getActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(String activeFlag) {
        this.activeFlag = activeFlag;
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