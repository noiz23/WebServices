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
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import cl.vmetrix.spring.AppContext;
import cl.vmetrix.webservices.channels.Channel;

/**
 * The Class <b>AccountService</b> identify the channel to use (The queue to access)
 * and implements the proper logic of that channel.
 * 
 * @author Andre Pinheiro
 * @version 1.0 30/08/2016
 * 
 */
@WebService(endpointInterface = "cl.vmetrix.webservices.proxy.ProxyService")
public class ProxyServiceImpl implements ProxyService {

	private static final Logger logger = Logger
			.getLogger(ProxyServiceImpl.class);

	@Override
	public boolean processMessage(String channelID, int maxTimeRequest,
			String message) throws VMWebServiceException {

		ApplicationContext applicationContext = AppContext
				.getApplicationContext();

		if (applicationContext == null)
			throw new VMWebServiceException("ApplicationContext not loaded.");

//		logger.debug("applicationContext: " + applicationContext);

		Channel app = null;

		try {
			app = (Channel) applicationContext.getBean(channelID);
		} catch (RuntimeException e) {
			throw new VMWebServiceException("Channel \"" + channelID
					+ "\" not found.", e);
		}
		logger.debug("Processing message...");
		boolean result = app.processMessage(message);
		if (result)
			logger.debug("Message processed");
		else
			logger.debug("Message NOT processed");

		return result;

	}
}