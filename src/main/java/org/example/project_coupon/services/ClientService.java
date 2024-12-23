package org.example.project_coupon.services;

import org.apache.commons.logging.Log;
import org.example.project_coupon.Exception.CustomException;
import org.example.project_coupon.model.LogIn;
import org.example.project_coupon.repositories.CouponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public abstract class ClientService {
    @Autowired
    protected CouponRepository couponRepository;

    public abstract boolean Login(LogIn c) throws CustomException;
}
