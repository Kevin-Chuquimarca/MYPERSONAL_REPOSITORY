/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.nextpremiers.model;

import java.util.Date;

/**
 *
 * @author Kevin Chuquimarca ESPE-DCCO
 */
public class NextPremier {

    private String title;
    private String gender;
    private int ageRestriction;
    private String sinopsis;
    private String namePicture;
    private Date premierDate;

    public NextPremier(String title, String gender, int ageRestriction, String sinopsis, String namePicture, Date premierDate) {
        this.title = title;
        this.gender = gender;
        this.ageRestriction = ageRestriction;
        this.sinopsis = sinopsis;
        this.namePicture = namePicture;
        this.premierDate = premierDate;
    }

    public String getTitle() {
        return title;
    }

    public String getGender() {
        return gender;
    }

    public String getAgeRestriction() {
        String age = ageRestriction + "";
        return age;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public String getNamePicture() {
        return namePicture;
    }

    public String getPremierDate() {
        return premierDate.toGMTString();
    }
}
