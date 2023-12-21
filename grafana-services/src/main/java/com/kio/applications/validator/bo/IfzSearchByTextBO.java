package com.kio.applications.validator.bo;

import java.io.Serializable;

import com.kio.applications.validator.exception.GenericException;

/**
 * The interface Ifz search by text bo.
 *
 * @param <T> the type parameter
 */
public interface IfzSearchByTextBO<T> extends Serializable {

	/**
	 * Search by text t.
	 *
	 * @param value the value
	 * @return the t
	 * @throws GenericException the generic exception
	 */
	T searchByText(String value) throws GenericException;

}
