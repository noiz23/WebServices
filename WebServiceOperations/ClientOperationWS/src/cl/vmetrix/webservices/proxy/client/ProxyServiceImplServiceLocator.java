/**
 * ProxyServiceImplServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cl.vmetrix.webservices.proxy.client;

public class ProxyServiceImplServiceLocator extends org.apache.axis.client.Service implements cl.vmetrix.webservices.proxy.client.ProxyServiceImplService {

    public ProxyServiceImplServiceLocator() {
    }


    public ProxyServiceImplServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ProxyServiceImplServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ProxyServiceImplPort
    private java.lang.String ProxyServiceImplPort_address = "http://localhost:9080/OperationsWS/ProxyService";
//    private java.lang.String ProxyServiceImplPort_address = "http://vmserver01:9081/OperationsWS/ProxyService";
    /*Ambiente TOMCAT:*/
//    private java.lang.String ProxyServiceImplPort_address = "http://localhost:8181/OperationsWS/ProxyService";

    public java.lang.String getProxyServiceImplPortAddress() {
        return ProxyServiceImplPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ProxyServiceImplPortWSDDServiceName = "ProxyServiceImplPort";

    public java.lang.String getProxyServiceImplPortWSDDServiceName() {
        return ProxyServiceImplPortWSDDServiceName;
    }

    public void setProxyServiceImplPortWSDDServiceName(java.lang.String name) {
        ProxyServiceImplPortWSDDServiceName = name;
    }

    public cl.vmetrix.webservices.proxy.client.ProxyServiceImpl getProxyServiceImplPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ProxyServiceImplPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getProxyServiceImplPort(endpoint);
    }

    public cl.vmetrix.webservices.proxy.client.ProxyServiceImpl getProxyServiceImplPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            cl.vmetrix.webservices.proxy.client.ProxyServiceImplServiceSoapBindingStub _stub = new cl.vmetrix.webservices.proxy.client.ProxyServiceImplServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getProxyServiceImplPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setProxyServiceImplPortEndpointAddress(java.lang.String address) {
        ProxyServiceImplPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (cl.vmetrix.webservices.proxy.client.ProxyServiceImpl.class.isAssignableFrom(serviceEndpointInterface)) {
                cl.vmetrix.webservices.proxy.client.ProxyServiceImplServiceSoapBindingStub _stub = new cl.vmetrix.webservices.proxy.client.ProxyServiceImplServiceSoapBindingStub(new java.net.URL(ProxyServiceImplPort_address), this);
                _stub.setPortName(getProxyServiceImplPortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("ProxyServiceImplPort".equals(inputPortName)) {
            return getProxyServiceImplPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://proxy.webservices.vmetrix.cl/", "ProxyServiceImplService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://proxy.webservices.vmetrix.cl/", "ProxyServiceImplPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ProxyServiceImplPort".equals(portName)) {
            setProxyServiceImplPortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
