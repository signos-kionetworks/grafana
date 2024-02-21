package com.kio.applications.validator.bo;

import com.kio.applications.validator.exception.GenericException;
import com.kio.applications.validator.model.Resource;

import java.io.Serializable;

/**
 * The interface Ifz resource bo.
 */
public interface IfzResourceBO extends Serializable {


	/**
	 * Search resource by resource id resource.
	 *
	 * @param resourceId the resource id
	 * @param originId   the origin id
	 * @return the resource
	 * @throws GenericException the generic exception
	 */
	Resource searchResourceByResourceId(String resourceId,  Integer originId) throws GenericException;

}
