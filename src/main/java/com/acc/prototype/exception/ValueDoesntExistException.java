package com.acc.prototype.exception;


import org.springframework.ws.soap.server.endpoint.annotation.FaultCode;
import org.springframework.ws.soap.server.endpoint.annotation.SoapFault;

@SoapFault(faultCode = FaultCode.CUSTOM,
        customFaultCode = "{" + ValueDoesntExistException.NAMESPACE_URI + "}custom_fault 3008",
        faultStringOrReason = "Variable doesn't exist in the list")
public class ValueDoesntExistException extends IndexOutOfBoundsException{

    private static final long serialVersionUID = 1L;
    public static final String NAMESPACE_URI = "acc3";

    public ValueDoesntExistException() {
        super();
    }

}
