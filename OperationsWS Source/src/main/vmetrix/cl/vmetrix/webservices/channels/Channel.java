/*******************************************************************************
 * Copyright (c) 2016 VMetrix SPA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/

package cl.vmetrix.webservices.channels;

import cl.vmetrix.webservices.proxy.VMWebServiceException;

/**
 * The interface <b>Channel</b>, has the firm of the method(s) for the channels used by the WS application.
 * 
 * @author Andre Pinheiro
 * @version 1.0 30/08/2016
 *
 */
public interface Channel {
 
    boolean processMessage(String msg) throws VMWebServiceException;
    
}