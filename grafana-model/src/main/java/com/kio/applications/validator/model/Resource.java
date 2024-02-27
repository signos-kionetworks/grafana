package com.kio.applications.validator.model;

import javax.annotation.Generated;

public class Resource {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String name;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String identificadorRecurso;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer idOrigen;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getId() {
        return id;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setId(Integer id) {
        this.id = id;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getName() {
        return name;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getIdentificadorRecurso() {
        return identificadorRecurso;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setIdentificadorRecurso(String identificadorRecurso) {
        this.identificadorRecurso = identificadorRecurso == null ? null : identificadorRecurso.trim();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getIdOrigen() {
        return idOrigen;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setIdOrigen(Integer idOrigen) {
        this.idOrigen = idOrigen;
    }
}