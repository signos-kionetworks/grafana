/*
* ****************************************************
* * Grafana *
* * KIO Networks *
* * @Author Julio Galindo *
* ****************************************************
*/

package com.kio.applications.validator.model.web;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * The Class ValidatorResponse.
 */
@JsonInclude(JsonInclude.Include.NON_NULL) @JsonPropertyOrder({ "aut_id", "message", "record_id" })
public class ValidatorResponse implements Serializable {

	/** The aut id. */
	@JsonProperty("aut_id")
	private Integer autId;

	/** The message. */
	@JsonProperty("message")
	private String message;

	/** The record id. */
	@JsonProperty("record_id")
	private Integer recordId;

	/** The Constant serialVersionUID. */
	private final static long serialVersionUID = -3984398257563816954L;

	/**
	 * Gets the aut id.
	 *
	 * @return the aut id
	 */
	@JsonProperty("aut_id")
	public Integer getAutId() {
		return autId;
	}

	/**
	 * Sets the aut id.
	 *
	 * @param autId the new aut id
	 */
	@JsonProperty("aut_id")
	public void setAutId(Integer autId) {
		this.autId = autId;
	}

	/**
	 * Gets the message.
	 *
	 * @return the message
	 */
	@JsonProperty("message")
	public String getMessage() {
		return message;
	}

	/**
	 * Sets the message.
	 *
	 * @param message the new message
	 */
	@JsonProperty("message")
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * Gets the record id.
	 *
	 * @return the record id
	 */
	@JsonProperty("record_id")
	public Integer getRecordId() {
		return recordId;
	}

	/**
	 * Sets the record id.
	 *
	 * @param recordId the new record id
	 */
	@JsonProperty("record_id")
	public void setRecordId(Integer recordId) {
		this.recordId = recordId;
	}

}
