package org.example.project_coupon.services;

import org.example.project_coupon.model.Category;
import org.example.project_coupon.model.Company;
import org.example.project_coupon.model.Coupon;
import org.example.project_coupon.model.LogIn;
import org.example.project_coupon.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CompanyService extends ClientService {
    private Company company;

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public boolean Login(LogIn c)  {
        return companyRepository.existsByLogin_EmailAndLogin_Password(c.getEmail(),c.getPassword());
    }

    public CompanyService() {
    }
   // public int  getNumCoupons(){ return couponRepository.countById();}



  public ArrayList<Coupon> GetCompanyCoupons()
  {
      return (ArrayList<Coupon>) couponRepository.findAll();
  }
    public ArrayList<Coupon> GetCompanyCoupons(Category category)
    {
              return couponRepository.searchCouponByCategory(category);
    }

    public  ArrayList<Coupon> GetCompanyCoupons(double maxPrice) {
        //למה עושים בי-פור למחיר???????????
     return couponRepository.searchCouponsByPriceBefore(maxPrice);
    }

    public void /* Company */ GetCompanyDetails() {
     //TODO מה עושים בפונקציה הזו
    }
    public Coupon AddCoupon(Coupon coupon)
    {
       if(!couponRepository.existsCouponByTitleAndCompany(coupon.getTitle(), coupon.getCompany())) {
           if (couponRepository.existsCouponById(coupon.getId()))
               couponRepository.save(coupon);
       }
        return coupon;
    }

    public Coupon UpdateCoupon(Coupon coupon)
    {
        Coupon c= couponRepository.getReferenceById(coupon.getId());
        if(c!=null){
            coupon.setCompany(c.getCompany());
//          if (couponRepository.existsById(coupon.getId()))
              couponRepository.save(coupon);
        }
        return coupon;
    }

    public void DeleteCoupon(long id)
    {
        if(couponRepository.existsCouponById(id))
            couponRepository.deleteById(id);
        //TODO צריך למחוק גם את היסטוריית הרכישות של הלקוחות איך עושים את זה

    }




}
