package com.kio.applications.validator.bo;

import java.io.Serializable;

import com.kio.applications.validator.exception.GenericException;

/**
 * The Interface IfzQueryBO.
 *
 * @param <T> the generic type
 */
public interface IfzSelectBO<T> extends Serializable {

	/**
	 * Select by id t.
	 *
	 * @param id the id
	 * @return the t
	 * @throws GenericException the generic exception
	 */
	T selectById(int id) throws GenericException;

	/**
	 * Select by name t.
	 *
	 * @param value the value
	 * @return the t
	 * @throws GenericException the generic exception
	 */
	T selectByName(String value) throws GenericException;

}
