/*
* ****************************************************
* * Grafana *
* * KIO Networks *
* * @Author Julio Galindo *
* ****************************************************
*/

package com.kio.applications.validator.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

/**
 * The Class RestServiceException.
 */
public class RestServiceException extends WebApplicationException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1154886234595592271L;

	/** The status. */
	private Status status;

	/** The message. */
	private String message;

	/**
	 * Instantiates a new rest service exception.
	 */
	public RestServiceException() {

	}

	/**
	 * Instantiates a new rest service exception.
	 *
	 * @param status  the status
	 * @param message the message
	 */
	public RestServiceException(Status status, String message) {
		super(Response.status(status).entity(new GrafanaException(status.getStatusCode(), message)).build());
		this.message = message;
		this.status = status;
	}

	/**
	 * Gets the message.
	 *
	 * @return the message
	 */
	@Override
	public String getMessage() {
		return this.message;
	}

	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public Status getStatus() {
		return this.status;
	}

	/**
	 * Sets the message.
	 *
	 * @param message the new message
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * Sets the status.
	 *
	 * @param status the new status
	 */
	public void setStatus(Status status) {
		this.status = status;
	}

}
