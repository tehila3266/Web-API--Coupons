package org.example.project_coupon.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Embeddable
public class Customer {
    @Id
    @GeneratedValue
    private long id;
    private String firsName;
    private String lastName;
    @Embedded
    private LogIn login;
    @OneToMany
    private List<Coupon> coupons;

    public Customer() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Customer(String firsName, String lastName, LogIn login, List<Coupon> coupons) {

        this.firsName = firsName;
        this.lastName = lastName;
        this.login = login;
        this.coupons = coupons;
    }


    public String getFirsName() {
        return firsName;
    }

    public void setFirsName(String firsName) {
        this.firsName = firsName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LogIn getLogIn() {
        return login;
    }

    public void setLogIn(LogIn logIn) {
        this.login = login;
    }

    public List<Coupon> getCoupons() {
        return coupons;
    }

    public void setCoupons(List<Coupon> coupons) {
        this.coupons = coupons;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firsName='" + firsName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", login=" + login +
                ", coupons=" + coupons +
                '}';
    }
}
