package com.dongne.its.base.apiPayload.exception.handler;

import com.dongne.its.base.apiPayload.code.BaseErrorCode;
import com.dongne.its.base.apiPayload.exception.GeneralException;

public class GeneralExceptionHandler extends GeneralException {

    public GeneralExceptionHandler(BaseErrorCode code) {
        super(code);
    }
}
