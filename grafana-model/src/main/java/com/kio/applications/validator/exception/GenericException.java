/*
* ****************************************************
* * Grafana *
* * KIO Networks *
* * @Author Julio Galindo *
* ****************************************************
*/

package com.kio.applications.validator.exception;

/**
 * The Class GenericException.
 */
public class GenericException extends Exception {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -4657365857019508242L;

	/**
	 * Instantiates a new generic exception.
	 */
	public GenericException() {
		super();
	}

	/**
	 * Instantiates a new generic exception.
	 *
	 * @param message the message
	 */
	public GenericException(String message) {

		super(message);
	}
}