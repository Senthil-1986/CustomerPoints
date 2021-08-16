package com.cp.serviceimpl;

import com.cp.model.Customer;
import com.cp.model.*;
import java.util.*;
import java.text.*;

public class PointOperator implements com.cp.service.CalculatePoint {

    public Map calculate(Customer customer) {
        Map<String, Integer> points = new HashMap<>();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.roll(Calendar.MONTH, -1);
        points.put(new SimpleDateFormat("MMMM").format(calendar.getTime()), 0);
        calendar.roll(Calendar.MONTH, -1);
        points.put(new SimpleDateFormat("MMMM").format(calendar.getTime()), 0);
        calendar.roll(Calendar.MONTH, -1);
        points.put(new SimpleDateFormat("MMMM").format(calendar.getTime()), 0);
        
        for (Invoice invoice : customer.getInvoices()) {
            Calendar Thirdmonth_firstday = Calendar.getInstance();
            Thirdmonth_firstday.setTime(new Date());
            Thirdmonth_firstday.set(Calendar.HOUR_OF_DAY, 0);
            Thirdmonth_firstday.set(Calendar.MINUTE, 0);
            Thirdmonth_firstday.set(Calendar.SECOND, 0);
            Thirdmonth_firstday.set(Calendar.MILLISECOND, 0);
            Thirdmonth_firstday.roll(Calendar.MONTH, -3);
            Thirdmonth_firstday.set(Calendar.DATE, 1);
            
            Calendar currentmonth_firstday = Calendar.getInstance();
            currentmonth_firstday.setTime(new Date());
            currentmonth_firstday.set(Calendar.HOUR_OF_DAY, 0);
            currentmonth_firstday.set(Calendar.MINUTE, 0);
            currentmonth_firstday.set(Calendar.SECOND, 0);
            currentmonth_firstday.set(Calendar.MILLISECOND, 0);
            currentmonth_firstday.set(Calendar.DATE, 1);
            
            if ((Thirdmonth_firstday.getTimeInMillis() <= invoice.getValueDate().getTime())
                    &&(currentmonth_firstday.getTimeInMillis() > invoice.getValueDate().getTime())) {
                float amount = invoice.getAmount();
                int dollar_int = (int) amount;
                int point =0;
                if (dollar_int > 50 && dollar_int <= 100) {
                    point = point + (dollar_int % 50);
                } else if (dollar_int > 100) {
                    point = point + (((dollar_int - 100) * 2) + 50);
                }
                point = point + points.get(new SimpleDateFormat("MMMM").format(invoice.getValueDate()));
                points.put(new SimpleDateFormat("MMMM").format(invoice.getValueDate()), point);
            }
        }

        return points;

    }
}
