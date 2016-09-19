/*******************************************************************************
 * Copyright (c) 2016 VMetrix SPA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package cl.vmetrix.spring;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * This class provides an application-wide access to the Spring
 * ApplicationContext. The ApplicationContext is injected in a static method of
 * the class "AppContext".
 *
 * Use AppContext.getApplicationContext() to get access to all Spring Beans.
 *
 * @author Andre Pinheiro
 * @version 1.0  30/08/2016
 */
public class ApplicationContextProvider implements ApplicationContextAware {

	public void setApplicationContext(ApplicationContext ctx) throws BeansException {

		AppContext.setApplicationContext(ctx);

	}
}