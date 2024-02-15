package com.kio.applications.validator.bo;

import java.io.Serializable;

import com.kio.applications.validator.exception.GenericException;
import com.kio.applications.validator.model.TokenAWX;

/**
 * The interface Ifz token awxbo.
 */
public interface IfzTokenAWXBO extends Serializable {

	/**
	 * Search token token awx.
	 *
	 * @param token the token
	 * @return the token awx
	 * @throws GenericException the generic exception
	 */
	TokenAWX searchToken(String token) throws GenericException;

}
