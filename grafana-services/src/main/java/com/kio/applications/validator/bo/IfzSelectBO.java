package com.kio.applications.validator.bo;

import java.io.Serializable;

import com.kio.applications.validator.exception.GenericException;

/**
 * The Interface IfzQueryBO.
 *
 * @param <T> the generic type
 */
public interface IfzSelectBO<T> extends Serializable {

	T selectById(int id) throws GenericException;

	T selectByName(String value) throws GenericException;

}
