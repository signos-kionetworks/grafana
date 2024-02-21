package com.kio.applications.validator.model;

/**
 * The type Token awx.
 */
public class TokenAWX {

    private Integer id;


    private String token;


    private Integer idArea;


    private String emailUser;


    private Integer idOrigen;


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
     * Gets token.
     *
     * @return the token
     */
    public String getToken() {
        return token;
    }


    /**
     * Sets token.
     *
     * @param token the token
     */
    public void setToken(String token) {
        this.token = token == null ? null : token.trim();
    }


    /**
     * Gets id area.
     *
     * @return the id area
     */
    public Integer getIdArea() {
        return idArea;
    }


    /**
     * Sets id area.
     *
     * @param idArea the id area
     */
    public void setIdArea(Integer idArea) {
        this.idArea = idArea;
    }


    /**
     * Gets email user.
     *
     * @return the email user
     */
    public String getEmailUser() {
        return emailUser;
    }


    /**
     * Sets email user.
     *
     * @param emailUser the email user
     */
    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser == null ? null : emailUser.trim();
    }


    /**
     * Gets id origen.
     *
     * @return the id origen
     */
    public Integer getIdOrigen() {
        return idOrigen;
    }


    /**
     * Sets id origen.
     *
     * @param idOrigen the id origen
     */
    public void setIdOrigen(Integer idOrigen) {
        this.idOrigen = idOrigen;
    }
}