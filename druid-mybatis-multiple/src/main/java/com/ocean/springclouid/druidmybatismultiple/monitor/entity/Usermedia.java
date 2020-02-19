package com.ocean.springclouid.druidmybatismultiple.monitor.entity;

import java.io.Serializable;

public class Usermedia implements Serializable {
    private Integer id;

    private Integer mediatypeid;

    private String sendto;

    private String active;

    private String severity;

    private String period;

    private Integer userid;

    private Integer mediaid;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMediatypeid() {
        return mediatypeid;
    }

    public void setMediatypeid(Integer mediatypeid) {
        this.mediatypeid = mediatypeid;
    }

    public String getSendto() {
        return sendto;
    }

    public void setSendto(String sendto) {
        this.sendto = sendto == null ? null : sendto.trim();
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active == null ? null : active.trim();
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity == null ? null : severity.trim();
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period == null ? null : period.trim();
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getMediaid() {
        return mediaid;
    }

    public void setMediaid(Integer mediaid) {
        this.mediaid = mediaid;
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
        Usermedia other = (Usermedia) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getMediatypeid() == null ? other.getMediatypeid() == null : this.getMediatypeid().equals(other.getMediatypeid()))
                && (this.getSendto() == null ? other.getSendto() == null : this.getSendto().equals(other.getSendto()))
                && (this.getActive() == null ? other.getActive() == null : this.getActive().equals(other.getActive()))
                && (this.getSeverity() == null ? other.getSeverity() == null : this.getSeverity().equals(other.getSeverity()))
                && (this.getPeriod() == null ? other.getPeriod() == null : this.getPeriod().equals(other.getPeriod()))
                && (this.getUserid() == null ? other.getUserid() == null : this.getUserid().equals(other.getUserid()))
                && (this.getMediaid() == null ? other.getMediaid() == null : this.getMediaid().equals(other.getMediaid()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getMediatypeid() == null) ? 0 : getMediatypeid().hashCode());
        result = prime * result + ((getSendto() == null) ? 0 : getSendto().hashCode());
        result = prime * result + ((getActive() == null) ? 0 : getActive().hashCode());
        result = prime * result + ((getSeverity() == null) ? 0 : getSeverity().hashCode());
        result = prime * result + ((getPeriod() == null) ? 0 : getPeriod().hashCode());
        result = prime * result + ((getUserid() == null) ? 0 : getUserid().hashCode());
        result = prime * result + ((getMediaid() == null) ? 0 : getMediaid().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", mediatypeid=").append(mediatypeid);
        sb.append(", sendto=").append(sendto);
        sb.append(", active=").append(active);
        sb.append(", severity=").append(severity);
        sb.append(", period=").append(period);
        sb.append(", userid=").append(userid);
        sb.append(", mediaid=").append(mediaid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}