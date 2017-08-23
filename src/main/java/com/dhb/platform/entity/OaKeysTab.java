package com.dhb.platform.entity;

public class OaKeysTab {
    private Long rowId;

    private String keytable;

    private String keycolumn;

    private Long keymaxid;

    public Long getRowId() {
        return rowId;
    }

    public void setRowId(Long rowId) {
        this.rowId = rowId;
    }

    public String getKeytable() {
        return keytable;
    }

    public void setKeytable(String keytable) {
        this.keytable = keytable == null ? null : keytable.trim();
    }

    public String getKeycolumn() {
        return keycolumn;
    }

    public void setKeycolumn(String keycolumn) {
        this.keycolumn = keycolumn == null ? null : keycolumn.trim();
    }

    public Long getKeymaxid() {
        return keymaxid;
    }

    public void setKeymaxid(Long keymaxid) {
        this.keymaxid = keymaxid;
    }
}