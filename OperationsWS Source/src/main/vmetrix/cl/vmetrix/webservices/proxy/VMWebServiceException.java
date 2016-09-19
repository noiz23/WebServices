/*******************************************************************************
 * Copyright (c) 2016 VMetrix SPA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/

package cl.vmetrix.webservices.proxy;

/**
 * The class <b>VMWebServiceException</b> will manage the exceptions of the
 * operation WS application.
 * 
 * @author Andre Pinheiro
 * @version 1.0 30/08/2016
 *
 */
public class VMWebServiceException extends Exception {

	private static final long serialVersionUID = -7851991591419674936L;

	public VMWebServiceException(String message, Throwable cause) {
		super(message, cause);

	}

	public VMWebServiceException(String message) {
		super(message);
	}

}
