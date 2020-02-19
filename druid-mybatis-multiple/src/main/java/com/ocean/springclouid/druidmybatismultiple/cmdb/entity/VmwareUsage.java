package com.ocean.springclouid.druidmybatismultiple.cmdb.entity;

import java.io.Serializable;

public class VmwareUsage implements Serializable {
    private Integer id;

    private String cluster;

    private Double cpu;

    private Double momery;

    private Long time;

    private String vcenter;

    private String vmware;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCluster() {
        return cluster;
    }

    public void setCluster(String cluster) {
        this.cluster = cluster == null ? null : cluster.trim();
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

    public String getVmware() {
        return vmware;
    }

    public void setVmware(String vmware) {
        this.vmware = vmware == null ? null : vmware.trim();
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
        VmwareUsage other = (VmwareUsage) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getCluster() == null ? other.getCluster() == null : this.getCluster().equals(other.getCluster()))
                && (this.getCpu() == null ? other.getCpu() == null : this.getCpu().equals(other.getCpu()))
                && (this.getMomery() == null ? other.getMomery() == null : this.getMomery().equals(other.getMomery()))
                && (this.getTime() == null ? other.getTime() == null : this.getTime().equals(other.getTime()))
                && (this.getVcenter() == null ? other.getVcenter() == null : this.getVcenter().equals(other.getVcenter()))
                && (this.getVmware() == null ? other.getVmware() == null : this.getVmware().equals(other.getVmware()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCluster() == null) ? 0 : getCluster().hashCode());
        result = prime * result + ((getCpu() == null) ? 0 : getCpu().hashCode());
        result = prime * result + ((getMomery() == null) ? 0 : getMomery().hashCode());
        result = prime * result + ((getTime() == null) ? 0 : getTime().hashCode());
        result = prime * result + ((getVcenter() == null) ? 0 : getVcenter().hashCode());
        result = prime * result + ((getVmware() == null) ? 0 : getVmware().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", cluster=").append(cluster);
        sb.append(", cpu=").append(cpu);
        sb.append(", momery=").append(momery);
        sb.append(", time=").append(time);
        sb.append(", vcenter=").append(vcenter);
        sb.append(", vmware=").append(vmware);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}