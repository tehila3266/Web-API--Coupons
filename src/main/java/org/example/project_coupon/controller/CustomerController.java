package org.example.project_coupon.controller;

import org.example.project_coupon.Exception.CustomException;
import org.example.project_coupon.model.*;
import org.example.project_coupon.services.CompanyService;
import org.example.project_coupon.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.example.project_coupon.Exception.CustomException;
import org.example.project_coupon.JWT.AuthenticationRequest;
import org.example.project_coupon.JWT.AuthenticationResponse;
import org.example.project_coupon.JWT.JwtUtils;
import org.example.project_coupon.model.Coupon;
import org.example.project_coupon.services.CustomerService;



import java.util.ArrayList;

@RestController
@RequestMapping("/customer")
public class CustomerController extends ClientController {

    private CustomerService customerService;


    @Autowired
    private JwtUtils jwtUtils;


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthenticationRequest authenticationRequest) throws CustomException {
        customerService = (CustomerService)loginManager.login(new LogIn( authenticationRequest.getEmail(), authenticationRequest.getPassword()), ClientType.Customer);
        if(customerService != null) {
            String token = jwtUtils.generateToken(authenticationRequest, ClientType.Customer);
            System.out.println(token);
            return ResponseEntity.ok(new AuthenticationResponse(token));
        }
        else {
            return new ResponseEntity<String>("Invalid Email or Password...", HttpStatus.UNAUTHORIZED);
        }
    }

    @GetMapping("/getCustomers/{id}")
    public Customer getAllCustomers(@PathVariable long customerId) throws CustomException
    {
        return customerService.GetCustomerById(customerId);
    }

    @PostMapping("/addCustomers")
    public Customer addCustomer(@RequestBody Customer customer) throws CustomException
    {
        return customerService.AddCustomer(customer);
    }

    @PutMapping("/updateCustomers")
    public  Customer updateCustomer(@RequestBody Customer customer) throws CustomException
    {
        return customerService.UpdateCustomer(customer);
    }

    @DeleteMapping("/deleteCustomers/{id}")
    public  void deleteCoupon( @PathVariable("id") long couponID) throws CustomException
    {
        customerService.DeleteCustomer(couponID);
    }
}
