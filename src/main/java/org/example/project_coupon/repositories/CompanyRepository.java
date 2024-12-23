package org.example.project_coupon.repositories;

import org.example.project_coupon.model.Company;
import org.example.project_coupon.model.Coupon;
import org.example.project_coupon.model.LogIn;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company,Long> {

    public Company findCompanyByCoupons(Coupon coupon);
    public boolean existsByName(String name);

    boolean existsCouponById(long id);

    boolean existsByLogin_EmailAndLogin_Password(String email,String password);



}
