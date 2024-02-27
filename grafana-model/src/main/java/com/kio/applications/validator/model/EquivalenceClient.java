/*
 * ****************************************************
 * * Grafana *
 * * KIO Networks *
 * * @Author Julio Galindo *
 * ****************************************************
 */
package com.kio.applications.validator.model;

/**
 * The Class EquivalenceClient.
 */
public class EquivalenceClient {

    /**
     * The valor.
     */
    private String valor;

    /**
     * The id cliente.
     */
    private Integer idCliente;

    /**
     * Gets the valor.
     *
     * @return the valor
     */
    public String getValor() {
        return valor;
    }

    /**
     * Sets the valor.
     *
     * @param valor the new valor
     */
    public void setValor(String valor) {
        this.valor = valor == null ? null : valor.trim();
    }

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
}