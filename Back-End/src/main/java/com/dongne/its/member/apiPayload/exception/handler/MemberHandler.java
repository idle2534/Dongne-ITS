package com.dongne.its.member.apiPayload.exception.handler;

import com.dongne.its.member.apiPayload.code.status.MemberErrorStatus;
import com.dongne.its.member.apiPayload.exception.GeneralException;

public class MemberHandler extends GeneralException {

    public MemberHandler(MemberErrorStatus code) {
        super(code);
    }
}
