/*
 * ****************************************************
 * * Grafana *
 * * KIO Networks *
 * * @Author Julio Galindo *
 * ****************************************************
 */
package com.kio.applications.validator.model;

/**
 * The Class EquivalenceClientOrganization.
 */
public class EquivalenceClientOrganization {

    /**
     * The id cliente.
     */
    private Integer idCliente;

    /**
     * The id organizacion awx.
     */
    private Integer idOrganizacionAwx;

    /**
     * Gets the id cliente.
     *
     * @return the id cliente
     */
    public Integer getIdCliente() {
        return idCliente;
    }

    /**
     * Sets the id cliente.
     *
     * @param idCliente the new id cliente
     */
    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    /**
     * Gets the id organizacion awx.
     *
     * @return the id organizacion awx
     */
    public Integer getIdOrganizacionAwx() {
        return idOrganizacionAwx;
    }

    /**
     * Sets the id organizacion awx.
     *
     * @param idOrganizacionAwx the new id organizacion awx
     */
    public void setIdOrganizacionAwx(Integer idOrganizacionAwx) {
        this.idOrganizacionAwx = idOrganizacionAwx;
    }
}