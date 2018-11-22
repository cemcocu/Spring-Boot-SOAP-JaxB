package com.acc.prototype.exception;


import org.springframework.ws.soap.server.endpoint.annotation.FaultCode;
import org.springframework.ws.soap.server.endpoint.annotation.SoapFault;

@SoapFault(faultCode = FaultCode.CUSTOM,
        customFaultCode = "{" + VariableNotEmptyException.NAMESPACE_URI + "}custom_fault 3005",
        faultStringOrReason = "Variable cannot be empty")
public class VariableNotEmptyException extends NullPointerException {

    private static final long serialVersionUID = 1L;
    public static final String NAMESPACE_URI = "acc2";

    public VariableNotEmptyException() {
        super();
    }
}
