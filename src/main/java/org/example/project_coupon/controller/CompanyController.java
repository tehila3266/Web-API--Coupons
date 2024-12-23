package org.example.project_coupon.controller;

import org.example.project_coupon.Exception.CustomException;
import org.example.project_coupon.model.*;
import org.example.project_coupon.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import org.example.project_coupon.JWT.AuthenticationRequest;
import org.example.project_coupon.JWT.AuthenticationResponse;
import org.example.project_coupon.JWT.JwtUtils;
import org.example.project_coupon.services.CompanyService;



import java.util.ArrayList;

@RestController
@RequestMapping("/company")
public class CompanyController extends ClientController{

    private CompanyService companyService;

    @Autowired
    private JwtUtils jwtUtils;



    @GetMapping("/getCompanies")
    public ArrayList<Coupon> getAllCompanies() throws CustomException
    {
        return companyService.GetCompanyCoupons();
    }


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthenticationRequest authenticationRequest) throws CustomException {
        companyService = (CompanyService)loginManager.login(new LogIn( authenticationRequest.getEmail(), authenticationRequest.getPassword()), ClientType.Company);
        if(companyService != null) {
            String token = jwtUtils.generateToken(authenticationRequest, ClientType.Company);
            System.out.println(token);
            return ResponseEntity.ok(new AuthenticationResponse(token));
        } else {
            return new ResponseEntity<String>("Invalid Email or Password...", HttpStatus.UNAUTHORIZED);
        }
    }

    @PostMapping("/addCoupon")
    public Coupon addCompany(@RequestBody Coupon coupon) throws CustomException
    {
        return companyService.AddCoupon(coupon);
    }

    @PutMapping("/updateCoupon")
    public  Coupon updateCoupon(@RequestBody Coupon coupon) throws CustomException
    {
        return companyService.UpdateCoupon(coupon);
    }

    @DeleteMapping("/deleteCoupon/{id}")
    public  void deleteCoupon( @PathVariable("id") long couponID) throws CustomException
    {
        companyService.DeleteCoupon(couponID);
    }
}


