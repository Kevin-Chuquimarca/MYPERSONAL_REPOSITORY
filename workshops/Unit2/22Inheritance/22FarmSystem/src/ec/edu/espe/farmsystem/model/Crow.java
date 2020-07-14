/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.farmsystem.model;

import java.util.Date;

/**
 *
 * @author santi
 */
public class Crow extends FarmAnimal{
    private static String sex;

    public Crow(String sex, int id, String breed, Date bornOn) {
        super(id, breed, bornOn);
        Crow.sex = sex;
    }
    
    public static String fly(int month){
        if (month > 5){
            return "The crow can fly";
        }
       return "The crow can't fly";
    }

    @Override
    public String toString() {
        return "Crow{" + "sex=" + sex + super.toString() + '}';
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        Crow.sex = sex;
    }
}
