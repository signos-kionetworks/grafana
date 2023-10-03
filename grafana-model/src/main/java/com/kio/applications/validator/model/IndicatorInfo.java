package com.kio.applications.validator.model;

import javax.annotation.Generated;

public class IndicatorInfo {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String source;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String userAgent;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String remoteHost;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer idIndicador;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getId() {
        return id;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setId(Integer id) {
        this.id = id;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getSource() {
        return source;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getUserAgent() {
        return userAgent;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent == null ? null : userAgent.trim();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getRemoteHost() {
        return remoteHost;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setRemoteHost(String remoteHost) {
        this.remoteHost = remoteHost == null ? null : remoteHost.trim();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getIdIndicador() {
        return idIndicador;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setIdIndicador(Integer idIndicador) {
        this.idIndicador = idIndicador;
    }
}
