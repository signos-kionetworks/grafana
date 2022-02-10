package com.kio.applications.validator.bo;

import java.io.Serializable;

import com.kio.applications.validator.exception.GenericException;
import com.kio.applications.validator.model.web.ValidatorRequest;
import com.kio.applications.validator.model.web.ValidatorResponse;

public interface IfzValidatorBO extends Serializable {
	ValidatorResponse processRequest(ValidatorRequest value) throws GenericException;
}
