package org.example.project_coupon.model;

public class LogIn {
    private String email;
    private String password;

    public LogIn() {
    }

    public LogIn(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public LogIn(String admin, String number, ClientType clientType) {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
