package org.example.project_coupon.Login;

import org.example.project_coupon.model.ClientType;
import org.example.project_coupon.model.LogIn;
import org.example.project_coupon.Exception.CustomException;
import org.example.project_coupon.services.AdminService;
import org.example.project_coupon.services.ClientService;
import org.example.project_coupon.services.CompanyService;
import org.example.project_coupon.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class LoginManager {

    @Autowired
    AdminService adminService;

    @Autowired
    CompanyService companyService;

    @Autowired
    CustomerService customerService;

    private LoginManager() {

    }

    public ClientService login(LogIn login, ClientType clientType) throws CustomException {
        boolean boolLogin = false;
        ClientService clientService = null;
        switch (clientType) {
            case Administrator:
                clientService = adminService;
                boolLogin = clientService.Login(login);
                break;
            case Company:
                clientService = companyService;
                boolLogin = clientService.Login(login);
                break;
            case Customer:
                clientService = customerService;
                boolLogin = clientService.Login(login);
                break;
        }

        if(!boolLogin)
            return null;
        else
            return clientService;
    }
}
