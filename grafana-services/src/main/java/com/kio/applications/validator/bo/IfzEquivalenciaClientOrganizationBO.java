package com.kio.applications.validator.bo;

import java.io.Serializable;

import com.kio.applications.validator.exception.GenericException;
import com.kio.applications.validator.model.EquivalenceClientOrganization;

public interface IfzEquivalenciaClientOrganizationBO extends Serializable {

	EquivalenceClientOrganization searchClientByIdOrganization(Integer id) throws GenericException;

}
