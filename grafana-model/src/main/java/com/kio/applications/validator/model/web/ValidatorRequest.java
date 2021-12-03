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

// TODO: Auto-generated Javadoc
/**
 * The Class ValidatorRequest.
 */
@JsonInclude(JsonInclude.Include.NON_NULL) @JsonPropertyOrder({ "extra_vars" })
public class ValidatorRequest implements Serializable {

	/** The extra vars. */
	@JsonProperty("extra_vars")
	private ExtraVars extraVars;

	/** The Constant serialVersionUID. */
	private final static long serialVersionUID = 5852931230632180342L;

	/**
	 * Gets the extra vars.
	 *
	 * @return the extra vars
	 */
	@JsonProperty("extra_vars")
	public ExtraVars getExtraVars() {
		return extraVars;
	}

	/**
	 * Sets the extra vars.
	 *
	 * @param extraVars the new extra vars
	 */
	@JsonProperty("extra_vars")
	public void setExtraVars(ExtraVars extraVars) {
		this.extraVars = extraVars;
	}

}
