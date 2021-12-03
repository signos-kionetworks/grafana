package com.kio.applications.validator.bo;

import java.io.Serializable;

import com.kio.applications.validator.exception.GenericException;
import com.kio.applications.validator.model.TokenAWX;

public interface IfzTokenAWXBO extends Serializable {

	TokenAWX searchToken(String token) throws GenericException;

}
