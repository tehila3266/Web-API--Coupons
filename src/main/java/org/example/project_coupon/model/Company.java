package org.example.project_coupon.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Embeddable
public class Company {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    @Embedded
    private LogIn login;
    @OneToMany
    private List<Coupon>coupons;

    public Company() {
    }

    public Company(String name, LogIn logIn, ArrayList<Coupon> coupons) {
        this.name = name;
        this.login = logIn;
        this.coupons = coupons;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LogIn getLogIn() {
        return login;
    }


    public List<Coupon> getCoupons() {
        return coupons;
    }

    public void setCoupons(List<Coupon> coupons) {
        this.coupons = coupons;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", logIn=" + login +
                ", coupons=" + coupons +
                '}';
    }
}
