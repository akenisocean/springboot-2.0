package com.ocean.springclouid.druidmybatismultiple.cmdb.entity;

import java.io.Serializable;

public class Vmwarecredential implements Serializable {
    private Integer id;

    private Integer cycle;

    private String name;

    private String password;

    private String state;

    private Long sysntime;

    private String url;

    private String username;

    private String acountstate;

    private String syncType;

    private Boolean flag;

    private Integer saveMonth;

    private Integer startDate;

    private Integer numEsxi;

    private Integer numVmware;

    private String vCenterip;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCycle() {
        return cycle;
    }

    public void setCycle(Integer cycle) {
        this.cycle = cycle;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public Long getSysntime() {
        return sysntime;
    }

    public void setSysntime(Long sysntime) {
        this.sysntime = sysntime;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getAcountstate() {
        return acountstate;
    }

    public void setAcountstate(String acountstate) {
        this.acountstate = acountstate == null ? null : acountstate.trim();
    }

    public String getSyncType() {
        return syncType;
    }

    public void setSyncType(String syncType) {
        this.syncType = syncType == null ? null : syncType.trim();
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public Integer getSaveMonth() {
        return saveMonth;
    }

    public void setSaveMonth(Integer saveMonth) {
        this.saveMonth = saveMonth;
    }

    public Integer getStartDate() {
        return startDate;
    }

    public void setStartDate(Integer startDate) {
        this.startDate = startDate;
    }

    public Integer getNumEsxi() {
        return numEsxi;
    }

    public void setNumEsxi(Integer numEsxi) {
        this.numEsxi = numEsxi;
    }

    public Integer getNumVmware() {
        return numVmware;
    }

    public void setNumVmware(Integer numVmware) {
        this.numVmware = numVmware;
    }

    public String getvCenterip() {
        return vCenterip;
    }

    public void setvCenterip(String vCenterip) {
        this.vCenterip = vCenterip == null ? null : vCenterip.trim();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Vmwarecredential other = (Vmwarecredential) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getCycle() == null ? other.getCycle() == null : this.getCycle().equals(other.getCycle()))
                && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
                && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()))
                && (this.getState() == null ? other.getState() == null : this.getState().equals(other.getState()))
                && (this.getSysntime() == null ? other.getSysntime() == null : this.getSysntime().equals(other.getSysntime()))
                && (this.getUrl() == null ? other.getUrl() == null : this.getUrl().equals(other.getUrl()))
                && (this.getUsername() == null ? other.getUsername() == null : this.getUsername().equals(other.getUsername()))
                && (this.getAcountstate() == null ? other.getAcountstate() == null : this.getAcountstate().equals(other.getAcountstate()))
                && (this.getSyncType() == null ? other.getSyncType() == null : this.getSyncType().equals(other.getSyncType()))
                && (this.getFlag() == null ? other.getFlag() == null : this.getFlag().equals(other.getFlag()))
                && (this.getSaveMonth() == null ? other.getSaveMonth() == null : this.getSaveMonth().equals(other.getSaveMonth()))
                && (this.getStartDate() == null ? other.getStartDate() == null : this.getStartDate().equals(other.getStartDate()))
                && (this.getNumEsxi() == null ? other.getNumEsxi() == null : this.getNumEsxi().equals(other.getNumEsxi()))
                && (this.getNumVmware() == null ? other.getNumVmware() == null : this.getNumVmware().equals(other.getNumVmware()))
                && (this.getvCenterip() == null ? other.getvCenterip() == null : this.getvCenterip().equals(other.getvCenterip()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCycle() == null) ? 0 : getCycle().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
        result = prime * result + ((getState() == null) ? 0 : getState().hashCode());
        result = prime * result + ((getSysntime() == null) ? 0 : getSysntime().hashCode());
        result = prime * result + ((getUrl() == null) ? 0 : getUrl().hashCode());
        result = prime * result + ((getUsername() == null) ? 0 : getUsername().hashCode());
        result = prime * result + ((getAcountstate() == null) ? 0 : getAcountstate().hashCode());
        result = prime * result + ((getSyncType() == null) ? 0 : getSyncType().hashCode());
        result = prime * result + ((getFlag() == null) ? 0 : getFlag().hashCode());
        result = prime * result + ((getSaveMonth() == null) ? 0 : getSaveMonth().hashCode());
        result = prime * result + ((getStartDate() == null) ? 0 : getStartDate().hashCode());
        result = prime * result + ((getNumEsxi() == null) ? 0 : getNumEsxi().hashCode());
        result = prime * result + ((getNumVmware() == null) ? 0 : getNumVmware().hashCode());
        result = prime * result + ((getvCenterip() == null) ? 0 : getvCenterip().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", cycle=").append(cycle);
        sb.append(", name=").append(name);
        sb.append(", password=").append(password);
        sb.append(", state=").append(state);
        sb.append(", sysntime=").append(sysntime);
        sb.append(", url=").append(url);
        sb.append(", username=").append(username);
        sb.append(", acountstate=").append(acountstate);
        sb.append(", syncType=").append(syncType);
        sb.append(", flag=").append(flag);
        sb.append(", saveMonth=").append(saveMonth);
        sb.append(", startDate=").append(startDate);
        sb.append(", numEsxi=").append(numEsxi);
        sb.append(", numVmware=").append(numVmware);
        sb.append(", vCenterip=").append(vCenterip);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}