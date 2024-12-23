package org.example.project_coupon;

import org.example.project_coupon.Login.LoginManager;
import org.example.project_coupon.model.ClientType;
import org.example.project_coupon.model.Company;
import org.example.project_coupon.model.LogIn;
import org.example.project_coupon.services.AdminService;
import org.example.project_coupon.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjectCouponApplication  {

	public static void main(String[] args) {
		SpringApplication.run(ProjectCouponApplication.class, args);
	}
//@Autowired
//	private LoginManager loginManager;
//
//	@Override
//	public void run(String... args) throws Exception {
//		AdminService admin = (AdminService) loginManager.login(new LogIn("admin@admin.com", "1223"), ClientType.Administrator);
//		admin.AddCompany(new Company(1,"tnuva",admin,));
//	}
}
