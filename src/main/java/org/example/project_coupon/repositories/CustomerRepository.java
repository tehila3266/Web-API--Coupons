package org.example.project_coupon.repositories;

import org.example.project_coupon.model.Coupon;
import org.example.project_coupon.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface CustomerRepository extends JpaRepository<Customer,Long> {

  boolean existsByLogin_EmailAndLogin_Password(String email, String password);

  //ArrayList<Coupon> searchCustomersBy(double maxPrice);

}
