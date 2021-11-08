/*
* ****************************************************
* * Grafana *
* * KIO Networks *
* * @Author Julio Galindo *
* ****************************************************
*/

package com.kio.applications.validator.handler;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.cxf.message.Message;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;

import com.kio.applications.validator.exception.GrafanaException;

/**
 * The Class InputHandler.
 */
public class InputHandler extends AbstractPhaseInterceptor<Message> {

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
		/*
		 * try { } catch (final GenericException e) {
		 * message.getExchange().put(Response.class,
		 * this.buildResponse(Response.Status.BAD_REQUEST, e.getMessage())); }
		 */

	}

}