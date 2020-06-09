package com.flexicore.exceptions;

import com.flexicore.interfaces.ErrorCodeException;

import javax.ws.rs.InternalServerErrorException;

public class ServerExceptionCustomException extends InternalServerErrorException implements ErrorCodeException {
    private int errorCode;



    public ServerExceptionCustomException(String message, Throwable cause, int errorCode) {
        super(message, cause);
        this.errorCode=errorCode;
    }

    @Override
    public int getErrorCode() {
        return errorCode;
    }
}
