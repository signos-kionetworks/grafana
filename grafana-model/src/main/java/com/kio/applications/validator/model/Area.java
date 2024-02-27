/*
 * ****************************************************
 * * Grafana *
 * * KIO Networks *
 * * @Author Julio Galindo *
 * ****************************************************
 */
package com.kio.applications.validator.model;

/**
 * The Class Area.
 */
public class Area {

    /**
     * The id.
     */
    private Integer id;

    /**
     * The name.
     */
    private String name;

    /**
     * The descr.
     */
    private String descr;

    /**
     * The id direccion.
     */
    private Integer idDireccion;

    /**
     * Gets the descr.
     *
     * @return the descr
     */
    public String getDescr() {
        return descr;
    }

    /**
     * Sets the descr.
     *
     * @param descr the new descr
     */
    public void setDescr(String descr) {
        this.descr = descr == null ? null : descr.trim();
    }

    /**
     * Gets the id.
     *
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets the id.
     *
     * @param id the new id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets the id direccion.
     *
     * @return the id direccion
     */
    public Integer getIdDireccion() {
        return idDireccion;
    }

    /**
     * Sets the id direccion.
     *
     * @param idDireccion the new id direccion
     */
    public void setIdDireccion(Integer idDireccion) {
        this.idDireccion = idDireccion;
    }

    /**
     * Gets the name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name.
     *
     * @param name the new name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}