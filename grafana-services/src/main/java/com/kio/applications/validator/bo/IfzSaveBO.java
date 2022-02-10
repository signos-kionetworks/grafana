
package com.kio.applications.validator.bo;

import java.io.Serializable;

import com.kio.applications.validator.exception.GenericException;

public interface IfzSaveBO<T> extends Serializable {

	T save(T object) throws GenericException;

}
