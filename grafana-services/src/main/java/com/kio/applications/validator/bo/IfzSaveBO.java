
package com.kio.applications.validator.bo;

import java.io.Serializable;

import com.kio.applications.validator.exception.GenericException;

/**
 * The interface Ifz save bo.
 *
 * @param <T> the type parameter
 */
public interface IfzSaveBO<T> extends Serializable {

	/**
	 * Save t.
	 *
	 * @param object the object
	 * @return the t
	 * @throws GenericException the generic exception
	 */
	T save(T object) throws GenericException;

}
