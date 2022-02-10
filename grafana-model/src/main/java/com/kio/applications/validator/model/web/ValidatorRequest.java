/*
 * ****************************************************
 * * Grafana *
 * * KIO Networks *
 * * @Author Julio Galindo *
 * ****************************************************
 */

package com.kio.applications.validator.model.web;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;

/**
 * The Class ValidatorRequest.
 */
public class ValidatorRequest implements Serializable {


	/** The Constant serialVersionUID. */
	private final static long serialVersionUID = 5852931230632180342L;

	private ExtraVars extraVars;

	/**
	 * Gets the extra vars.
	 *
	 * @return the extra vars
	 */
	public ExtraVars getExtraVars() {
		return extraVars;
	}

	/**
	 * Sets the extra vars.
	 *
	 * @param extraVars
	 *            the new extra vars
	 */
	@XmlElement(name = "extra_vars")
	public void setExtraVars(ExtraVars extraVars) {
		this.extraVars = extraVars;
	}

}
