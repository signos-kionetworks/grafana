/*
* ****************************************************
* * Grafana *
* * KIO Networks *
* * @Author Julio Galindo *
* ****************************************************
*/

package com.kio.applications.validator.handler;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.cxf.message.Message;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.kio.applications.validator.bo.impl.TokenAWXBO;
import com.kio.applications.validator.exception.GenericException;
import com.kio.applications.validator.exception.GrafanaException;
import com.kio.applications.validator.model.TokenAWX;
import com.kio.applications.validator.noctopus.api.APINoctopus;
import com.kio.applications.validator.util.AppConstants;

/**
 * The Class InputHandler.
 */
public class InputHandler extends AbstractPhaseInterceptor<Message> {

	private static final Logger logger = Logger.getLogger(InputHandler.class);

	@Autowired
	private APINoctopus apiNoctopus;

	@Autowired
	TokenAWXBO tokenAWXBO;

	private static final String BEARER = "Bearer ";

	/**
	 * Instantiates a new input handler.
	 */
	public InputHandler() {
		super(Phase.PRE_STREAM);
	}

	/**
	 * Builds the response.
	 *
	 * @param status  the status
	 * @param mensaje the mensaje
	 * @return the response
	 */
	private Response buildResponse(Status status, String mensaje) {
		return Response.status(status).type(MediaType.APPLICATION_JSON)
				.entity(new GrafanaException(status.getStatusCode(), mensaje)).build();
	}

	/**
	 * Handle message.
	 *
	 * @param message the message
	 */
	@Override
	public void handleMessage(final Message message) {

		Map<?, ?> protocolHeaders = (TreeMap<?, ?>) message.get(Message.PROTOCOL_HEADERS);
		List<?> authzHeaders = (ArrayList<?>) protocolHeaders.get("Authorization");
		if (null != authzHeaders && !authzHeaders.isEmpty()) {
			String authorization = (String) authzHeaders.get(0);
			if (authorization.startsWith(BEARER)) {
				try {
					String bearerToken = authorization.replace(BEARER, "");
					//apiNoctopus.validateTokenAnsible(bearerToken);
					TokenAWX token = tokenAWXBO.searchToken(bearerToken);
					if (null == token) {
						message.getExchange().put(Response.class,
								this.buildResponse(Response.Status.UNAUTHORIZED, "Token ["+bearerToken+"] no registrado en AutomationID."));
					} else {
						message.put(AppConstants.P_TOKEN, token);
					}

				} catch (GenericException e) {
					logger.error(e.getMessage());
					message.getExchange().put(Response.class,
							this.buildResponse(Response.Status.UNAUTHORIZED, e.getMessage()));
				} catch (Exception e) {
					logger.error(e.getMessage());
					message.getExchange().put(Response.class,
							this.buildResponse(Response.Status.BAD_REQUEST, "No se pudo atender la solicitud."));
				}

			} else {
				message.getExchange().put(Response.class,
						this.buildResponse(Response.Status.UNAUTHORIZED, "Authentication method not allowed."));
			}
		} else {
			message.getExchange().put(Response.class,
					this.buildResponse(Response.Status.UNAUTHORIZED, "Authentication is required."));
		}

	}

}
