/*******************************************************************************
 * Copyright (c) 2016 VMetrix SPA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/

package cl.vmetrix.webservices.proxy;

import javax.jws.WebService;

/**
 * The Interface <b>ProxyService</b> has the unique method used by the WS:
 * processMessage.
 * 
 * @author Andre Pinheiro
 * @version 1.0 30/08/2016
 */
@WebService
public interface ProxyService {
	/**
	 * A service that is going to be used as a proxy to call other services.
	 * 
	 * @param channelID
	 *            : The id of the communication channel. It will relate directly
	 *            to the service that is going to handle the sent message.
	 * @param maxTimeRequest
	 *            : The maximun amount of time (in milliseconds) that the client
	 *            is going to wait for the response.
	 * @param message
	 *            : An message, in XML, that is going to be handled to the
	 *            destination service
	 * @return The response of the destination service, in XML format.
	 * 
	 * @throws VMWebServiceException
	 */
	public boolean processMessage(String channelID, int maxTimeRequest,
			String message) throws VMWebServiceException;
}