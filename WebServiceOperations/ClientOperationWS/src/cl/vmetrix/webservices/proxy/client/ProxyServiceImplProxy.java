package cl.vmetrix.webservices.proxy.client;

import java.rmi.RemoteException;

public class ProxyServiceImplProxy implements cl.vmetrix.webservices.proxy.client.ProxyServiceImpl {
  private String _endpoint = null;
  private cl.vmetrix.webservices.proxy.client.ProxyServiceImpl proxyServiceImpl = null;
  
  public ProxyServiceImplProxy() {
    _initProxyServiceImplProxy();
  }
  
  public ProxyServiceImplProxy(String endpoint) {
    _endpoint = endpoint;
    _initProxyServiceImplProxy();
  }
  
  private void _initProxyServiceImplProxy() {
    try {
      proxyServiceImpl = (new cl.vmetrix.webservices.proxy.client.ProxyServiceImplServiceLocator()).getProxyServiceImplPort();
      if (proxyServiceImpl != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)proxyServiceImpl)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)proxyServiceImpl)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (proxyServiceImpl != null)
      ((javax.xml.rpc.Stub)proxyServiceImpl)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public cl.vmetrix.webservices.proxy.client.ProxyServiceImpl getProxyServiceImpl() {
    if (proxyServiceImpl == null)
      _initProxyServiceImplProxy();
    return proxyServiceImpl;
  }
  
  public boolean processMessage(java.lang.String channelID, int maxTimeRequest, java.lang.String message) throws RemoteException{
    if (proxyServiceImpl == null)
      _initProxyServiceImplProxy();
    return proxyServiceImpl.processMessage(channelID, maxTimeRequest, message);
  }
  
  
}