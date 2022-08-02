package com.kio.applications.validator.bo;

import java.io.Serializable;

import com.kio.applications.validator.exception.GenericException;

public interface IfzSearchByKeyBO<T> extends Serializable {

	T searchByKey(T value) throws GenericException;

}
