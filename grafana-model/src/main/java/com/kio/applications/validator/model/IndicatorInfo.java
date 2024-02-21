package com.kio.applications.validator.model;

/**
 * The type Indicator info.
 */
public class IndicatorInfo {

    private Integer id;


    private String source;


    private String userAgent;


    private String remoteHost;


    private Integer idIndicador;


    /**
     * Gets id.
     *
     * @return the id
     */
    public Integer getId() {
        return id;
    }


    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(Integer id) {
        this.id = id;
    }


    /**
     * Gets source.
     *
     * @return the source
     */
    public String getSource() {
        return source;
    }


    /**
     * Sets source.
     *
     * @param source the source
     */
    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }


    /**
     * Gets user agent.
     *
     * @return the user agent
     */
    public String getUserAgent() {
        return userAgent;
    }


    /**
     * Sets user agent.
     *
     * @param userAgent the user agent
     */
    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent == null ? null : userAgent.trim();
    }


    /**
     * Gets remote host.
     *
     * @return the remote host
     */
    public String getRemoteHost() {
        return remoteHost;
    }


    /**
     * Sets remote host.
     *
     * @param remoteHost the remote host
     */
    public void setRemoteHost(String remoteHost) {
        this.remoteHost = remoteHost == null ? null : remoteHost.trim();
    }


    /**
     * Gets id indicador.
     *
     * @return the id indicador
     */
    public Integer getIdIndicador() {
        return idIndicador;
    }


    /**
     * Sets id indicador.
     *
     * @param idIndicador the id indicador
     */
    public void setIdIndicador(Integer idIndicador) {
        this.idIndicador = idIndicador;
    }
}
