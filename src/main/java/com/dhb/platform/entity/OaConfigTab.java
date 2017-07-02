package com.dhb.platform.entity;

import java.math.BigDecimal;
import java.util.Date;

public class OaConfigTab {
    private Long rowId;

    private String sysWebPath;

    private String sysUploadPath;

    private String mailServerIp;

    private BigDecimal mailServerPort;

    private String webMasterMail;

    private String sysUrl;

    private BigDecimal uploadFileLength;

    private Date createDate;

    private String createBy;

    private Date lastUpdateDate;

    private String lastUpdateBy;

    private Short updateCount;

    private String attribute01;

    private String attribute02;

    private Long attribute03;

    private Long attribute04;

    public Long getRowId() {
        return rowId;
    }

    public void setRowId(Long rowId) {
        this.rowId = rowId;
    }

    public String getSysWebPath() {
        return sysWebPath;
    }

    public void setSysWebPath(String sysWebPath) {
        this.sysWebPath = sysWebPath == null ? null : sysWebPath.trim();
    }

    public String getSysUploadPath() {
        return sysUploadPath;
    }

    public void setSysUploadPath(String sysUploadPath) {
        this.sysUploadPath = sysUploadPath == null ? null : sysUploadPath.trim();
    }

    public String getMailServerIp() {
        return mailServerIp;
    }

    public void setMailServerIp(String mailServerIp) {
        this.mailServerIp = mailServerIp == null ? null : mailServerIp.trim();
    }

    public BigDecimal getMailServerPort() {
        return mailServerPort;
    }

    public void setMailServerPort(BigDecimal mailServerPort) {
        this.mailServerPort = mailServerPort;
    }

    public String getWebMasterMail() {
        return webMasterMail;
    }

    public void setWebMasterMail(String webMasterMail) {
        this.webMasterMail = webMasterMail == null ? null : webMasterMail.trim();
    }

    public String getSysUrl() {
        return sysUrl;
    }

    public void setSysUrl(String sysUrl) {
        this.sysUrl = sysUrl == null ? null : sysUrl.trim();
    }

    public BigDecimal getUploadFileLength() {
        return uploadFileLength;
    }

    public void setUploadFileLength(BigDecimal uploadFileLength) {
        this.uploadFileLength = uploadFileLength;
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

    public Long getAttribute03() {
        return attribute03;
    }

    public void setAttribute03(Long attribute03) {
        this.attribute03 = attribute03;
    }

    public Long getAttribute04() {
        return attribute04;
    }

    public void setAttribute04(Long attribute04) {
        this.attribute04 = attribute04;
    }
}