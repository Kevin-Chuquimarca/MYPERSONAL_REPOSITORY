/** Copyright ESPE-DECC
 */
package ec.edu.espe.farmsystem.model;

import java.util.Date;

/**
 *
 * @author Kevin Chuquimarca ESPE-DCCO
 */
public class FarmAnimal {

    private int id;
    private String breed;
    private Date bornOn;
    private int sexOfTheAnimal;

    public FarmAnimal(int id, String breed, Date bornOn, int sexOfAnimal) {
        this.id = id;
        this.breed = breed;
        this.bornOn = bornOn;
        this.sexOfTheAnimal = sexOfAnimal;
    }

    public int getAgeInMonths() {
        Date date = new Date();
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

    public int getAgeInDays() {
        Date date = new Date();
        String[] currentsDate = date.toLocaleString().split("/");
        int day = Integer.parseInt(currentsDate[0]) - bornOn.getDay();
        return (getAgeInMonths())*30 + day;
    }
    
    public String defineSexOfAnimal(){
        if (sexOfTheAnimal == 1){
            return "female";
        }
        return "male";
    }

    @Override
    public String toString() {
        return "FarmAnimal{" + "id=" + id + ", breed=" + breed + ", bornOn="
                + bornOn + ", sexAnimal=" + defineSexOfAnimal() + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public Date getBornOn() {
        return bornOn;
    }

    public void setBornOn(Date bornOn) {
        this.bornOn = bornOn;
    }

    public int getSexOfAnimal() {
        return sexOfTheAnimal;
    }

    public void setSexOfAnimal(int sexOfAnimal) {
        this.sexOfTheAnimal = sexOfAnimal;
    }
}
