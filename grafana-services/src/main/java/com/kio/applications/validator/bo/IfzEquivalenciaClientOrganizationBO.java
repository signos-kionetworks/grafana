package com.kio.applications.validator.bo;

import java.io.Serializable;

import com.kio.applications.validator.exception.GenericException;
import com.kio.applications.validator.model.EquivalenceClientOrganization;

/**
 * The interface Ifz equivalencia client organization bo.
 */
public interface IfzEquivalenciaClientOrganizationBO extends Serializable {

	/**
	 * Search client by id organization equivalence client organization.
	 *
	 * @param id the id
	 * @return the equivalence client organization
	 * @throws GenericException the generic exception
	 */
	EquivalenceClientOrganization searchClientByIdOrganization(Integer id) throws GenericException;

}
