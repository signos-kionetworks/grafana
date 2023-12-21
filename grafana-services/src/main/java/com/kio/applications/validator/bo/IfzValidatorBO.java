package com.kio.applications.validator.bo;

import java.io.Serializable;

import com.kio.applications.validator.exception.GenericException;
import com.kio.applications.validator.model.web.ValidatorRequest;
import com.kio.applications.validator.model.web.ValidatorResponse;

/**
 * The interface Ifz validator bo.
 */
public interface IfzValidatorBO extends Serializable {
	/**
	 * Process request validator response.
	 *
	 * @param value the value
	 * @return the validator response
	 * @throws GenericException the generic exception
	 */
	ValidatorResponse processRequest(ValidatorRequest value) throws GenericException;
}
