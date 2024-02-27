/*
 * ****************************************************
 * * Grafana *
 * * KIO Networks *
 * * @Author Julio Galindo *
 * ****************************************************
 */

package com.kio.applications.validator.model.web;

import javax.xml.bind.annotation.XmlElement;
import java.io.Serializable;

/**
 * The Class ValidatorResponse.
 */
public class ValidatorResponse implements Serializable {

    /**
     * The Constant serialVersionUID.
     */
    private final static long serialVersionUID = -3984398257563816954L;

    /**
     * The aut id.
     */
    private Integer autId;

    /**
     * The message.
     */
    private String message;

    /**
     * The record id.
     */
    private Integer recordId;

    /**
     * Gets the aut id.
     *
     * @return the aut id
     */
    public Integer getAutId() {
        return autId;
    }

    /**
     * Sets the aut id.
     *
     * @param autId the new aut id
     */
    @XmlElement(name = "automation_id")
    public void setAutId(Integer autId) {
        this.autId = autId;
    }

    /**
     * Gets the message.
     *
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the message.
     *
     * @param message the new message
     */
    @XmlElement(name = "message")
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Gets the record id.
     *
     * @return the record id
     */
    public Integer getRecordId() {
        return recordId;
    }

    /**
     * Sets the record id.
     *
     * @param recordId the new record id
     */
    @XmlElement(name = "record_id")
    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }

}
