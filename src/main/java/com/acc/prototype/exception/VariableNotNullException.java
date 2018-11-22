package com.acc.prototype.exception;

import org.springframework.ws.soap.server.endpoint.annotation.FaultCode;
import org.springframework.ws.soap.server.endpoint.annotation.SoapFault;

@SoapFault(faultCode = FaultCode.CUSTOM,
        customFaultCode = "{" + VariableNotNullException.NAMESPACE_URI + "}custom_fault 3005",
        faultStringOrReason = "Variable cannot empty")
public class VariableNotNullException extends NullPointerException {

    private static final long serialVersionUID = 1L;
    public static final String NAMESPACE_URI = "acc1";

    public VariableNotNullException() {
        super();
    }
}