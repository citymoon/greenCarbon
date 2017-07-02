package com.dhb.platform.entity;

import java.math.BigDecimal;
import java.util.Date;

public class MdModule {
    private Long rowId;

    private String mdName;

    private String mdCode;

    private String parentRowid;

    private BigDecimal selectedFlag;

    private String mdNewName;

    private BigDecimal showSequence;

    private String mdUrl;

    private BigDecimal isSystemMd;

    private BigDecimal haveChild;

    private BigDecimal intranetFlag;

    private BigDecimal oasysFlag;

    private BigDecimal activeFlag;

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

    public BigDecimal getSelectedFlag() {
        return selectedFlag;
    }

    public void setSelectedFlag(BigDecimal selectedFlag) {
        this.selectedFlag = selectedFlag;
    }

    public String getMdNewName() {
        return mdNewName;
    }

    public void setMdNewName(String mdNewName) {
        this.mdNewName = mdNewName == null ? null : mdNewName.trim();
    }

    public BigDecimal getShowSequence() {
        return showSequence;
    }

    public void setShowSequence(BigDecimal showSequence) {
        this.showSequence = showSequence;
    }

    public String getMdUrl() {
        return mdUrl;
    }

    public void setMdUrl(String mdUrl) {
        this.mdUrl = mdUrl == null ? null : mdUrl.trim();
    }

    public BigDecimal getIsSystemMd() {
        return isSystemMd;
    }

    public void setIsSystemMd(BigDecimal isSystemMd) {
        this.isSystemMd = isSystemMd;
    }

    public BigDecimal getHaveChild() {
        return haveChild;
    }

    public void setHaveChild(BigDecimal haveChild) {
        this.haveChild = haveChild;
    }

    public BigDecimal getIntranetFlag() {
        return intranetFlag;
    }

    public void setIntranetFlag(BigDecimal intranetFlag) {
        this.intranetFlag = intranetFlag;
    }

    public BigDecimal getOasysFlag() {
        return oasysFlag;
    }

    public void setOasysFlag(BigDecimal oasysFlag) {
        this.oasysFlag = oasysFlag;
    }

    public BigDecimal getActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(BigDecimal activeFlag) {
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