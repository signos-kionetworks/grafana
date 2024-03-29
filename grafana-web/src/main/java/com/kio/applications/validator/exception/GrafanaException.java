/*
* ****************************************************
* * Grafana *
* * KIO Networks *
* * @Author Julio Galindo *
* ****************************************************
*/

package com.kio.applications.validator.exception;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * The Class GrafanaException.
 */
@XmlRootElement(name = "GrafanaException")
public class GrafanaException {

	/** The error code. */
	private int errorCode;

	/** The error message. */
	private String errorMessage;

	/**
	 * Instantiates a new grafana exception.
	 *
	 * @param errorCode    the error code
	 * @param errorMessage the error message
	 */
	public GrafanaException(int errorCode, String errorMessage) {
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	/**
	 * Gets the error code.
	 *
	 * @return the error code
	 */
	@XmlElement(name = "error_code")
	public int getErrorCode() {
		return this.errorCode;
	}

	/**
	 * Gets the error message.
	 *
	 * @return the error message
	 */
	@XmlElement(name = "error_message")
	public String getErrorMessage() {
		return this.errorMessage;
	}

	/**
	 * Sets the error code.
	 *
	 * @param errorCode the new error code
	 */
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	/**
	 * Sets the error message.
	 *
	 * @param errorMessage the new error message
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}