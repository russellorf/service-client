package org.example.bookservice;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

import org.apache.cxf.annotations.Policies;
import org.apache.cxf.annotations.Policy;

/**
 * This class was generated by Apache CXF 3.1.13
 * 2017-10-18T16:25:44.607-04:00
 * Generated source version: 3.1.13
 * 
 */
@WebService(targetNamespace = "http://www.example.org/BookService/", name = "BookService")
@XmlSeeAlso({ObjectFactory.class})
public interface BookService {

    @WebMethod(operationName = "NewOperation", action = "http://www.example.org/BookService/NewOperation")
    @RequestWrapper(localName = "NewOperation", targetNamespace = "http://www.example.org/BookService/", className = "org.example.bookservice.NewOperation")
    @ResponseWrapper(localName = "NewOperationResponse", targetNamespace = "http://www.example.org/BookService/", className = "org.example.bookservice.NewOperationResponse")
    @WebResult(name = "out", targetNamespace = "")
    @Policies({
    	@Policy(uri="Endpoint_GenericInput.xml", placement=Policy.Placement.BINDING_OPERATION_INPUT),
    	@Policy(uri="Endpoint_HolderOfKey.xml", placement=Policy.Placement.BINDING_OPERATION_INPUT)
    })
    public java.lang.String newOperation(
        @WebParam(name = "in", targetNamespace = "")
        java.lang.String in
    );
}