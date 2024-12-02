package com.nguyensao.identityservice.service;

import java.text.ParseException;

import com.nguyensao.identityservice.dto.request.AuthenticationRequest;
import com.nguyensao.identityservice.dto.request.IntrospectRequest;
import com.nguyensao.identityservice.dto.request.LogoutRequest;
import com.nguyensao.identityservice.dto.request.RefreshRequest;
import com.nguyensao.identityservice.dto.response.AuthenticationResponse;
import com.nguyensao.identityservice.dto.response.IntrospectResponse;
import com.nimbusds.jose.JOSEException;

public interface AuthenticationService {
    AuthenticationResponse authenticate(AuthenticationRequest request);

    IntrospectResponse introspect(IntrospectRequest request) throws JOSEException, ParseException;

    void logout(LogoutRequest request) throws JOSEException, ParseException;

    AuthenticationResponse refreshToken(RefreshRequest request) throws JOSEException, ParseException;
}
