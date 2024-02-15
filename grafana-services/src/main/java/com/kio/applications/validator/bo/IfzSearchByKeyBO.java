package com.kio.applications.validator.bo;

import java.io.Serializable;

import com.kio.applications.validator.exception.GenericException;

/**
 * The interface Ifz search by key bo.
 *
 * @param <T> the type parameter
 */
public interface IfzSearchByKeyBO<T> extends Serializable {

	/**
	 * Search by key t.
	 *
	 * @param value the value
	 * @return the t
	 * @throws GenericException the generic exception
	 */
	T searchByKey(T value) throws GenericException;

}
