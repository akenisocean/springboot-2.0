package com.ocean.springclouid.druidmybatismultiple.cmdb.entity;

import java.io.Serializable;

public class VcenterResourceUsage implements Serializable {
    private Integer id;

    private Double cpu;

    private Double momery;

    private Double storage;

    private Long time;

    private String vcenter;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getCpu() {
        return cpu;
    }

    public void setCpu(Double cpu) {
        this.cpu = cpu;
    }

    public Double getMomery() {
        return momery;
    }

    public void setMomery(Double momery) {
        this.momery = momery;
    }

    public Double getStorage() {
        return storage;
    }

    public void setStorage(Double storage) {
        this.storage = storage;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public String getVcenter() {
        return vcenter;
    }

    public void setVcenter(String vcenter) {
        this.vcenter = vcenter == null ? null : vcenter.trim();
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
        VcenterResourceUsage other = (VcenterResourceUsage) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getCpu() == null ? other.getCpu() == null : this.getCpu().equals(other.getCpu()))
                && (this.getMomery() == null ? other.getMomery() == null : this.getMomery().equals(other.getMomery()))
                && (this.getStorage() == null ? other.getStorage() == null : this.getStorage().equals(other.getStorage()))
                && (this.getTime() == null ? other.getTime() == null : this.getTime().equals(other.getTime()))
                && (this.getVcenter() == null ? other.getVcenter() == null : this.getVcenter().equals(other.getVcenter()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCpu() == null) ? 0 : getCpu().hashCode());
        result = prime * result + ((getMomery() == null) ? 0 : getMomery().hashCode());
        result = prime * result + ((getStorage() == null) ? 0 : getStorage().hashCode());
        result = prime * result + ((getTime() == null) ? 0 : getTime().hashCode());
        result = prime * result + ((getVcenter() == null) ? 0 : getVcenter().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", cpu=").append(cpu);
        sb.append(", momery=").append(momery);
        sb.append(", storage=").append(storage);
        sb.append(", time=").append(time);
        sb.append(", vcenter=").append(vcenter);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}