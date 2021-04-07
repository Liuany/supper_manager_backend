package com.example.xiaochun.common.exception;

import com.example.xiaochun.common.api.IErrorCode;

public class ApiException extends RuntimeException{

    private static final long serialVersionUID = 4640584074996625029L;

    private IErrorCode errorCode;

    public ApiException(IErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public ApiException(String message) {
        super(message);
    }

    public IErrorCode getErrorCode() {
        return  errorCode;
    }
}
