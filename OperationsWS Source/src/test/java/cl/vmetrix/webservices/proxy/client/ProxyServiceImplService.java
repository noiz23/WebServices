/*******************************************************************************
 * Copyright (c) 2016 VMetrix SPA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
/**
 * ProxyServiceImplService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cl.vmetrix.webservices.proxy.client;

public interface ProxyServiceImplService extends javax.xml.rpc.Service {
    public java.lang.String getProxyServiceImplPortAddress();

    public cl.vmetrix.webservices.proxy.client.ProxyServiceImpl getProxyServiceImplPort() throws javax.xml.rpc.ServiceException;

    public cl.vmetrix.webservices.proxy.client.ProxyServiceImpl getProxyServiceImplPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
