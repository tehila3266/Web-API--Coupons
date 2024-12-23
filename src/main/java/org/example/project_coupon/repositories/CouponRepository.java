package org.example.project_coupon.repositories;

import org.example.project_coupon.model.Category;
import org.example.project_coupon.model.Company;
import org.example.project_coupon.model.Coupon;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Set;

@Repository
public interface CouponRepository extends JpaRepository<Coupon,Long> {

 //int countById();
 ArrayList<Coupon> searchCouponByCategory(Category category);

 boolean existsCouponByTitleAndCompany(String title, Company company);

 boolean existsCouponById(long id);

 ArrayList<Coupon> searchCouponsByPriceBefore(double maxPrice);
 public ArrayList<Coupon> findByEndDateBefore(LocalDate endDate);

}
