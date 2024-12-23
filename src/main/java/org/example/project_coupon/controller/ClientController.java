package org.example.project_coupon.controller;

import org.example.project_coupon.Exception.CustomException;
import org.example.project_coupon.JWT.AuthenticationRequest;
import org.example.project_coupon.Login.LoginManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public abstract class ClientController  {

    @Autowired
    protected LoginManager loginManager;

    public abstract ResponseEntity<?> login(AuthenticationRequest authenticationRequest) throws CustomException;
}
