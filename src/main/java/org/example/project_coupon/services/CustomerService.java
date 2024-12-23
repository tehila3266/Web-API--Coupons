package org.example.project_coupon.services;

import org.example.project_coupon.Exception.CustomException;
import org.example.project_coupon.model.Coupon;
import org.example.project_coupon.model.Customer;
import org.example.project_coupon.model.LogIn;
import org.example.project_coupon.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class CustomerService extends  ClientService{

    private int customer;
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public boolean Login(LogIn c) {
        return customerRepository.existsByLogin_EmailAndLogin_Password(c.getEmail(),c.getPassword());
    }

    public CustomerService() {
    }
    //TODO  get-להשלים את כל פונקציות ה
//    public ArrayList<Coupon> GetCustomerCoupon() {
//        return customerRepository.findAll();
//    }
//    public ArrayList<Coupon> GetCustomerCoupons(){
//
//    }
//
//    public ArrayList<Coupon> GetCustomerCoupons(Category category)
//    {
//        return customerRepository.searchCouponByCategory(category);
//    }
//
//    public  ArrayList<Coupon> GetCustomerCoupons(double maxPrice) {
//        //למה עושים בי-פור למחיר???????????
//        return couponRepository.searchCouponsByPriceBefore(maxPrice);
//    }

    public void purchaseCoupon(Coupon coupon,Customer customer){

     if(coupon.getAmount() == 0)
         System.out.println("Can't buy this coupon ,his amount is 0");
     if(coupon.getStartDate().isBefore(LocalDate.now()) || coupon.getStartDate().isAfter(LocalDate.now()))
         System.out.println("the date is not valid");
     else{
         customer.getCoupons().add(coupon);
         coupon.setAmount(coupon.getAmount()-1);
         customerRepository.save(customer);
         couponRepository.save(coupon);
         System.out.println("you succeeded buy coupon");
         }
    }


    public Customer GetCustomerById(long id) throws CustomException{
        if(customerRepository.existsById(id))
            return customerRepository.getReferenceById(id);
        throw new CustomException("this customer is not exist please enter other id");
    }
    public Customer AddCustomer(Customer customer) {
        if(customerRepository.existsById(customer.getId())) {
            customerRepository.save(customer);
        }
        return customer;
    }

    public Customer UpdateCustomer(Customer customer){
        if(customerRepository.existsById(customer.getId()))
           customerRepository.save(customer);
        return customer;
    }

    public void DeleteCustomer(long id) {
        if (customerRepository.existsById(id))
            customerRepository.deleteById(id);
    }

}
