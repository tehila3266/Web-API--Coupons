package org.example.project_coupon.JWT;

public class AuthenticationResponse {
    public String getToken() {
        return token;
    }

    private final String token;

    public AuthenticationResponse(String token) {
        this.token = token;
    }

}
