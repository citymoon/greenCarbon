package com.dhb.platform.entity;

import java.math.BigDecimal;
import java.util.Date;

public class OrgRightlist {
    private Long rowId;

    private String rigModuleName;

    private String firstModuleCode;

    private String secndModuleCode;

    private String rigCode;

    private String rigName;

    private BigDecimal activeFlag;

    private Date createDate;

    private String createBy;

    private Date lastUpdateDate;

    private String lastUpdateBy;

    private Short updateCount;

    private String attribute01;

    private String attribute02;

    private String attribute03;

    private Long attribute04;

    public Long getRowId() {
        return rowId;
    }

    public void setRowId(Long rowId) {
        this.rowId = rowId;
    }

    public String getRigModuleName() {
        return rigModuleName;
    }

    public void setRigModuleName(String rigModuleName) {
        this.rigModuleName = rigModuleName == null ? null : rigModuleName.trim();
    }

    public String getFirstModuleCode() {
        return firstModuleCode;
    }

    public void setFirstModuleCode(String firstModuleCode) {
        this.firstModuleCode = firstModuleCode == null ? null : firstModuleCode.trim();
    }

    public String getSecndModuleCode() {
        return secndModuleCode;
    }

    public void setSecndModuleCode(String secndModuleCode) {
        this.secndModuleCode = secndModuleCode == null ? null : secndModuleCode.trim();
    }

    public String getRigCode() {
        return rigCode;
    }

    public void setRigCode(String rigCode) {
        this.rigCode = rigCode == null ? null : rigCode.trim();
    }

    public String getRigName() {
        return rigName;
    }

    public void setRigName(String rigName) {
        this.rigName = rigName == null ? null : rigName.trim();
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

    public String getAttribute03() {
        return attribute03;
    }

    public void setAttribute03(String attribute03) {
        this.attribute03 = attribute03 == null ? null : attribute03.trim();
    }

    public Long getAttribute04() {
        return attribute04;
    }

    public void setAttribute04(Long attribute04) {
        this.attribute04 = attribute04;
    }
}