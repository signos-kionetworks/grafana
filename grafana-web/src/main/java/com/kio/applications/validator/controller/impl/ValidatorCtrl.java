/*
* ****************************************************
* * Grafana *
* * KIO Networks *
* * @Author Julio Galindo *
* ****************************************************
*/

package com.kio.applications.validator.controller.impl;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.cxf.message.Message;
import org.apache.cxf.phase.PhaseInterceptorChain;
import org.apache.cxf.transport.http.AbstractHTTPDestination;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.kio.applications.validator.bo.impl.ValidatorBO;
import com.kio.applications.validator.controller.IfzValidatorCtrl;
import com.kio.applications.validator.exception.GenericException;
import com.kio.applications.validator.exception.RestServiceException;
import com.kio.applications.validator.model.web.ValidatorRequest;
import com.kio.applications.validator.model.web.ValidatorResponse;
import com.kio.applications.validator.util.AppConstants;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

/**
 * The Class ValidatorCtrl.
 */
@Controller("validator")
public class ValidatorCtrl implements IfzValidatorCtrl {

	/** The Constant logger. */
	private static final Logger logger = Logger.getLogger(ValidatorCtrl.class);

	@Autowired
	ValidatorBO validatorBO;

	@Override
	public ValidatorResponse validator(@RequestBody ValidatorRequest request) {
		//Long initTime = new Date().getTime();
		HttpServletRequest req = null;
		try {
			final Message message = PhaseInterceptorChain.getCurrentMessage();
			req = (HttpServletRequest) message.get(AbstractHTTPDestination.HTTP_REQUEST);
			request.getExtraVars().setUserAgent(req.getHeader("user-agent"));
			request.getExtraVars().setRemoteHost(req.getRemoteHost());
			return this.validatorBO.processRequest(request);
		} catch (final GenericException e) {
			logger.error(e.getMessage(), e);
			throw new RestServiceException(Status.BAD_REQUEST, e.getMessage());
		} catch (final Exception e) {
			logger.error(e.getMessage(), e);
			throw new RestServiceException(Status.INTERNAL_SERVER_ERROR,
					AppConstants.INTERNAL_ERROR);
		} finally {
			//logger.info(new Date().getTime() - initTime);
		}
	}

}
