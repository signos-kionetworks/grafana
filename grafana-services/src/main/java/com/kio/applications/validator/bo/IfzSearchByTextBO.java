package com.kio.applications.validator.bo;

import java.io.Serializable;

import com.kio.applications.validator.exception.GenericException;

public interface IfzSearchByTextBO<T> extends Serializable {

	T searchByText(String value) throws GenericException;

}
