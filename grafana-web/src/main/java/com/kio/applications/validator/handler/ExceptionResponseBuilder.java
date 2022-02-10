/*
* ****************************************************
* * Grafana *
* * KIO Networks *
* * @Author Julio Galindo *
* ****************************************************
*/
package com.kio.applications.validator.handler;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import org.apache.cxf.jaxrs.impl.WebApplicationExceptionMapper;

import com.kio.applications.validator.exception.RestException;

/**
 * The Class ExceptionResponseBuilder.
 */
public class ExceptionResponseBuilder extends WebApplicationExceptionMapper {

	/**
	 * To response.
	 *
	 * @param ex
	 *            the ex
	 * @return the response
	 */
	@Override
	public Response toResponse(WebApplicationException ex) {

		return Response.status(Response.Status.BAD_REQUEST)
				.entity(new RestException(
						Response.Status.BAD_REQUEST.getStatusCode(),
						ex.getCause() != null
								? ex.getCause().getMessage()
								: ex.getMessage()))
				.build();

	}

}