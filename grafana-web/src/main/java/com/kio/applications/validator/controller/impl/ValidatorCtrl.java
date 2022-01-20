/*
* ****************************************************
* * Grafana *
* * KIO Networks *
* * @Author Julio Galindo *
* ****************************************************
*/

package com.kio.applications.validator.controller.impl;

import javax.ws.rs.core.Response.Status;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kio.applications.validator.bo.impl.ValidatorBO;
import com.kio.applications.validator.controller.IfzValidatorCtrl;
import com.kio.applications.validator.exception.GenericException;
import com.kio.applications.validator.exception.RestServiceException;
import com.kio.applications.validator.model.web.ValidatorRequest;
import com.kio.applications.validator.model.web.ValidatorResponse;
import com.kio.applications.validator.util.AppConstants;

/**
 * The Class ValidatorCtrl.
 */
@Service("validator")
public class ValidatorCtrl implements IfzValidatorCtrl {

	/** The Constant logger. */
	private static final Logger logger = Logger.getLogger(ValidatorCtrl.class);

	@Autowired
	ValidatorBO validatorBO;

	@Override
	public ValidatorResponse validator(ValidatorRequest request) {
		//Long initTime = new Date().getTime();
		try {
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