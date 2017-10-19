package org.example.servlet;

import java.util.Map;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.xml.ws.BindingProvider;

import org.example.bookservice.BookService;
import org.example.bookservice.BookService_Service;
import org.example.util.KeystorePasswordCallbackHandler;
import org.example.util.SAMLCallbackHandler;

public class ContextListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent arg0) {

        BookService_Service ss = new BookService_Service();
        BookService port = ss.getBookServiceSOAP();  
        
        final Map<String,Object> ctx = ((BindingProvider)port).getRequestContext();
        ctx.put("ws-security.callback-handler", new KeystorePasswordCallbackHandler());
        ctx.put("ws-security.saml-callback-handler", new SAMLCallbackHandler());
        ctx.put("ws-security.signature.properties", "client_sign.properties");
        ctx.put("ws-security.signature.username", "selfsigned");
        
        {
	        System.out.println("Invoking newOperation...");
	        java.lang.String _newOperation_in = "_newOperation_in-640412423";
	        java.lang.String _newOperation__return = port.newOperation(_newOperation_in);
	        System.out.println("newOperation.result=" + _newOperation__return);
        }
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
	}
}