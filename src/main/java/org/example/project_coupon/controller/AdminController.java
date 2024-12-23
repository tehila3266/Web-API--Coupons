package org.example.project_coupon.controller;

import org.example.project_coupon.Exception.CustomException;
import org.example.project_coupon.model.*;
import org.example.project_coupon.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import  org.example.project_coupon.JWT.AuthenticationRequest;
import  org.example.project_coupon.JWT.AuthenticationResponse;
import  org.example.project_coupon.JWT.JwtUtils;


import java.util.ArrayList;

@RestController
@RequestMapping("/admin")
public class AdminController extends ClientController{


    @Autowired
    private JwtUtils jwtUtils;

    private AdminService adminService;


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthenticationRequest authenticationRequest) throws CustomException {
        adminService = (AdminService) loginManager.login(new LogIn( authenticationRequest.getEmail(), authenticationRequest.getPassword()), ClientType.Administrator);
        if(adminService != null) {
            String token = jwtUtils.generateToken(authenticationRequest, ClientType.Administrator);
            return ResponseEntity.ok(new AuthenticationResponse(token));
        } else {
            return new ResponseEntity<String>("Invalid Email or Password...", HttpStatus.UNAUTHORIZED);
        }
    }


    @GetMapping("/getCompanies")
    public ArrayList<Company> getAllCompanies() throws CustomException
    {
        return adminService.GetAllCompanies();
    }

   @PostMapping("/addCompanies")
    public void addCompany(@RequestBody Company company) throws CustomException
   {
       adminService.AddCompany(company);
   }

    @PutMapping("/updateCompanies/{id}")
    public void updateCompany(@RequestBody Company company,@PathVariable("id") long compnyId) throws CustomException
    {
        adminService.UpdateCompany(company,compnyId);
    }

    @DeleteMapping("/deleteCompanies/{id}")
    public void deleteCompany(@PathVariable("id") long companyId) throws CustomException
    {
        adminService.DeleteCompany(companyId);
    }

    @GetMapping("/getCustomers")
    public ArrayList<Customer> GetAllCustomers() throws CustomException
    {
        return adminService.GetAllCustomers();
    }

    @PostMapping("/addCustomers")
    public void addCustomers(@RequestBody Customer customer) throws CustomException
    {
        adminService.AddCustomer(customer);
    }

    @PutMapping("/updateCustomers/{id}")
    public void updateCustomers(@RequestBody Customer customer,@PathVariable("id") long customerId) throws CustomException
    {
        adminService.UpdateCustomer(customer,customerId);
    }

    @DeleteMapping("/deleteCustomers/{id}")
    public void deleteCustomers(@PathVariable("id") long customerId) throws CustomException
    {
        adminService.DeleteCustomer(customerId);
    }


}
