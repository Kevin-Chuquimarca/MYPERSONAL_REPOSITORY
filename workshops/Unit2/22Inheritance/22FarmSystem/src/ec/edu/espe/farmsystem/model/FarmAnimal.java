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

    public int getAgeInMonths(){
        Date date = new Date();
        String[] months;
        months = date.toLocaleString().split("/");
        String[] years;
        years = months[2].split(" ");
        String year = years[0];
        int month = (Integer.parseInt(year) - bornOn.getYear() - 1900)*12;
        return Integer.parseInt(months[1]) - bornOn.getMonth() - 1 + month;
    }


    public FarmAnimal(int id, String breed, Date bornOn) {
        this.id = id;
        this.breed = breed;
        this.bornOn = bornOn;
    }

    @Override
    public String toString() {
        return "FarmAnimal{" + "id=" + id + ", breed=" + breed + ", bornOn=" + bornOn + '}';
    }
    
    

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the breed
     */
    public String getBreed() {
        return breed;
    }

    /**
     * @param breed the breed to set
     */
    public void setBreed(String breed) {
        this.breed = breed;
    }

    /**
     * @return the bornOn
     */
    public Date getBornOn() {
        return bornOn;
    }

    /**
     * @param bornOn the bornOn to set
     */
    public void setBornOn(Date bornOn) {
        this.bornOn = bornOn;
    }
    
    
    

}
