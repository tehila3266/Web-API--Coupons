package org.example.project_coupon.services;

import org.example.project_coupon.Exception.CustomException;
import org.example.project_coupon.model.Company;
import org.example.project_coupon.model.Customer;
import org.example.project_coupon.model.LogIn;
import org.example.project_coupon.repositories.CompanyRepository;
import org.example.project_coupon.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AdminService extends ClientService {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private CustomerRepository customerRepository;


    public AdminService() {
    }

    public boolean Login(LogIn details) throws CustomException {
        if(details!=null) {
            if (details.getEmail().equals("admin@admin.com") && details.getPassword().equals("admin")) ;
            {
                System.out.println("hello Admin");
                return true;
            }
        }
      throw new CustomException("Invalid email or password");
    }

    public ArrayList<Company> GetAllCompanies() {
        ArrayList<Company> all = (ArrayList<Company>)companyRepository.findAll();
        return all;
    }

    public Company GetCompanyById(long id) {
        Company c = companyRepository.findById(id).get();
        return c;
    }

    //הוספת חברה חדשה לאוסף החברות
    public Company AddCompany(Company company){
        //בדיקה אם החברה לא קיימת באוסף
        if (!companyRepository.existsByName(company.getName())) {
            companyRepository.save(company);
        }
        return company;
    }
    //עדכון חברה קיימת
    public Company UpdateCompany(Company company,long id){
        //בדיקה אם חברה קיימת אם כן נעדכן אותה
        if (companyRepository.getReferenceById(id)!=null){
            companyRepository.save(company);
        }
        return company;
    }
    //מחיקת חברה מהאוסף
    public void DeleteCompany(long id){
        //בדיקה אם אם האי די קיים אם כן נמחק אותו
        Company c= companyRepository.getReferenceById(id);
           if(c!=null)
               companyRepository.delete(c);
        }

    public ArrayList<Customer> GetAllCustomers() {
        ArrayList<Customer> all = (ArrayList<Customer>)customerRepository.findAll();
        return all;
    }

    public Customer GetCustomerById(long id){
        Customer c = customerRepository.findById(id).get();
        return c;
    }

    //הוספת לקוח חדש לאוסף הלקוחות
    public Customer AddCustomer(Customer customer) {
        //בדיקה אם הלקוח לא קיים באוסף
        if (customerRepository.existsByLogin_EmailAndLogin_Password(customer.getLogIn().getEmail(),customer.getLogIn().getPassword())) {
            customerRepository.save(customer);
        }
        return customer;
    }
    //עדכון לקוח קיימת
    public Customer UpdateCustomer(Customer customer,long id){
        //בדיקה אם  לקוח קיים אם כן נעדכן אותה
        if (customerRepository.getReferenceById(id)!=null){
            customerRepository.save(customer);
        }
        return customer;
    }
    //מחיקת חברה מהאוסף
    public void DeleteCustomer(long id){
        //בדיקה אם אם האי די קיים אם כן נמחק אותו
         Customer c= customerRepository.getReferenceById(id);
         if(c!=null)
             customerRepository.delete(c);
    }








}



//