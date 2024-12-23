package org.example.project_coupon.Job;

import org.example.project_coupon.model.Coupon;
import org.example.project_coupon.repositories.CouponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.lang.ref.Cleaner;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Locale;

@Component
@Scope("singleton")
public class CouponExpirationDailyJob implements Runnable{
  @Autowired
    private CouponRepository couponRepo;
    private boolean quit;

    public CouponExpirationDailyJob() {
    }

    @Override
    public void run() {
        while (!quit)
        {
            for(Coupon cpn: couponRepo.findByEndDateBefore( LocalDate.now()))
            {
                couponRepo.delete(cpn);
            }
            try
            {
                Thread.sleep(864000000);
            }catch (InterruptedException e){
                System.out.println("Exception in CouponExpirationDailyJob - " + e.getMessage());
            }
        }
    }
    public void stop() { quit = true; }
}
