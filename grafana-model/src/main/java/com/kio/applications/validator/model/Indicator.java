package com.kio.applications.validator.model;

import java.util.Date;
import javax.annotation.Generated;

public class Indicator {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Date time;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long autid;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Float autotime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Float svtime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String transactionid;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String ticketid;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Float svfte;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer impactedCis;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer totalImpactedCis;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Float mantime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getId() {
        return id;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setId(Long id) {
        this.id = id;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Date getTime() {
        return time;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setTime(Date time) {
        this.time = time;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getAutid() {
        return autid;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setAutid(Long autid) {
        this.autid = autid;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Float getAutotime() {
        return autotime;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setAutotime(Float autotime) {
        this.autotime = autotime;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Float getSvtime() {
        return svtime;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setSvtime(Float svtime) {
        this.svtime = svtime;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getTransactionid() {
        return transactionid;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setTransactionid(String transactionid) {
        this.transactionid = transactionid == null ? null : transactionid.trim();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getTicketid() {
        return ticketid;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setTicketid(String ticketid) {
        this.ticketid = ticketid == null ? null : ticketid.trim();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Float getSvfte() {
        return svfte;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setSvfte(Float svfte) {
        this.svfte = svfte;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getImpactedCis() {
        return impactedCis;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setImpactedCis(Integer impactedCis) {
        this.impactedCis = impactedCis;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getTotalImpactedCis() {
        return totalImpactedCis;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setTotalImpactedCis(Integer totalImpactedCis) {
        this.totalImpactedCis = totalImpactedCis;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Float getMantime() {
        return mantime;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setMantime(Float mantime) {
        this.mantime = mantime;
    }
}
