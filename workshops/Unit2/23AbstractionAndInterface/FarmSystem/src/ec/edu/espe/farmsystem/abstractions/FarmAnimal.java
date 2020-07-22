/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.farmsystem.abstractions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kevin Chuquimarca ESPE-DCCO
 */
public abstract class FarmAnimal {

    protected Date bornOn;
    protected float foodMoney;
    protected float earningMoney;
    private int ageInMonths;
    
    Date date = new Date();

    public int computeAgeInMonths() {
        String[] currentsDate = date.toLocaleString().split("/");
        String[] years = currentsDate[2].split(" ");
        int year = Integer.parseInt(years[0]) - 1900 - bornOn.getYear();
        int month = Integer.parseInt(currentsDate[1]);
        int day = Integer.parseInt(currentsDate[0]) - bornOn.getDay();
        if (day <= 0) {
            return month - bornOn.getMonth() + (year * 12);
        } else {
            return month - bornOn.getMonth() + (year * 12) - 1;
        }
    }

    public int computeAgeInMonths(int bornOnYear, int bornOnMonth, int bornOnDay) {
        String[] currentsDate = date.toLocaleString().split("/");
        String[] years = currentsDate[2].split(" ");
        int year = Integer.parseInt(years[0]) - 1900 - bornOnYear;
        int month = Integer.parseInt(currentsDate[1]);
        int day = Integer.parseInt(currentsDate[0]) - bornOnDay;
        if (day <= 0) {
            return month - bornOnMonth + (year * 12) - 1;
        } else {
            return month - bornOnMonth + (year * 12) - 2;
        }
    }

    public int computeAgeInMonths(Date bornOnDate) {
        String[] currentsDate = date.toLocaleString().split("/");
        String[] years = currentsDate[2].split(" ");
        int year = Integer.parseInt(years[0]) - 1900 - bornOnDate.getYear();
        int month = Integer.parseInt(currentsDate[1]);
        int day = Integer.parseInt(currentsDate[0]) - bornOnDate.getDay();
        if (day <= 0) {
            return month - bornOnDate.getMonth() + (year * 12);
        } else {
            return month - bornOnDate.getMonth() + (year * 12) - 1;
        }
    }

    public int computeAgeInMonths(Calendar bornOnCalendar) {
        int year = bornOnCalendar.get(Calendar.YEAR);
        int month = bornOnCalendar.get(Calendar.MONTH) + 1;
        int date = bornOnCalendar.get(Calendar.DATE);
        Period diff1;
        int months = 0;

        String s = year + "/" + month + "/" + date;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        Date d;
        try {
            d = sdf.parse(s);
            Calendar c = Calendar.getInstance();
            c.setTime(d);
            int currentYear = c.get(Calendar.YEAR);
            int currentMonth = c.get(Calendar.MONTH) + 1;
            int currentDate = c.get(Calendar.DATE);
            LocalDate l1 = LocalDate.of(currentYear, currentMonth, currentDate);
            LocalDate now1 = LocalDate.now();
            diff1 = Period.between(l1, now1);
            months = diff1.getYears() * 12 + diff1.getMonths();
            return months;
        } catch (ParseException ex) {
            Logger.getLogger(FarmAnimal.class.getName()).log(Level.SEVERE, null, ex);
            return months;
        }
        }

    

    public abstract float computeEarningMoney(float product, int quantity);

    public abstract float computeFoodMoney(Food food);

}
