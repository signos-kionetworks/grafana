/*
 * ****************************************************
 * * Grafana *
 * * KIO Networks *
 * * @Author Julio Galindo *
 * ****************************************************
 */

package com.kio.applications.validator.controller;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.kio.applications.validator.model.web.ValidatorRequest;
import com.kio.applications.validator.model.web.ValidatorResponse;

/**
 * The Interface IfzValidatorCtrl.
 */
@Path("/")
@WebService
public interface IfzValidatorCtrl {
	@WebMethod
	@POST
	@Path("generate")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	@SOAPBinding(parameterStyle = ParameterStyle.BARE)
	ValidatorResponse validator(ValidatorRequest request);
}
