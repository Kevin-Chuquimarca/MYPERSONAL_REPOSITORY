/** Copyright ESPE-DECC
 */
package ec.edu.espe.farmsystem.model;

import java.util.Date;

/**
 *
 * @author Kevin Chuquimarca ESPE-DCCO
 */
public class Chicken extends FarmAnimal {

    private static boolean isMolting;

    public Chicken(int id, String breed, Date bornOn, boolean isMolting) {
        super(id, breed, bornOn);
        Chicken.isMolting = isMolting;
    }
    
    public static String putEgg(int month){
        if (month>5 & isMolting==true){
            return "The Chicken does put eggs";
        }
        return "The Chicken doesn't put eggs";
    }

    @Override
    public String toString() {
        String basicInformation = super.toString();

        String chicken = "Chicken{" + getId() + ", breed " + getBreed()
                + ", bornOn " + getBornOn() + ", isMolting " + isMolting;

        //return "Chicken{" + basicInformation + ", isMolting=" + isMolting + '}';
        return chicken;
    }

    public boolean isIsMolting() {
        return isMolting;
    }

    public void setIsMolting(boolean isMolting) {
        Chicken.isMolting = isMolting;
    }
}
