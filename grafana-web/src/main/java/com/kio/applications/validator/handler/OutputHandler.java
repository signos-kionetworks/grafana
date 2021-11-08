/*
* ****************************************************
* * Grafana *
* * KIO Networks *
* * @Author Julio Galindo *
* ****************************************************
*/

package com.kio.applications.validator.handler;

import org.apache.cxf.message.Message;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;

/**
 * The Class OutputHandler.
 */
public class OutputHandler extends AbstractPhaseInterceptor<Message> {

	/**
	 * Instantiates a new output handler.
	 */
	public OutputHandler() {
		super(Phase.PRE_STREAM);
	}

	/**
	 * Handle message.
	 *
	 * @param message the message
	 */
	@Override
	public void handleMessage(final Message message) {

	}

}