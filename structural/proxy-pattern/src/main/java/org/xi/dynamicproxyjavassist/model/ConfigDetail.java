package org.xi.dynamicproxyjavassist.model;

import java.io.Serializable;

public class ConfigDetail implements Serializable {

    private String key;
    private String value;
    private Integer envId;
    private Integer type;
    private String remark;
    private Integer deleted;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getEnvId() {
        return envId;
    }

    public void setEnvId(Integer envId) {
        this.envId = envId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "ConfigDetail{" +
                "key='" + key + '\'' +
                ", value='" + value + '\'' +
                ", envId=" + envId +
                ", type=" + type +
                ", remark='" + remark + '\'' +
                ", deleted=" + deleted +
                '}';
    }
}
