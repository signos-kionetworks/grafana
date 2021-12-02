/*
* ****************************************************
* * Grafana *
* * KIO Networks *
* * @Author Julio Galindo *
* ****************************************************
*/

package com.kio.applications.validator.model.web;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

// TODO: Auto-generated Javadoc
/**
 * The Class ValidatorRequest.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "extra_vars"
})
public class ValidatorRequest implements Serializable
{

    /** The extra vars. */
    @JsonProperty("extra_vars")
    private ExtraVars extraVars;

    /** The additional properties. */
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();

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

    /**
	 * Gets the additional properties.
	 *
	 * @return the additional properties
	 */
    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    /**
	 * Sets the additional property.
	 *
	 * @param name  the name
	 * @param value the value
	 */
    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
