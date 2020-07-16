/** Copyright ESPE-DECC
 */
package ec.edu.espe.farmsystem.model;

import java.util.Date;

/**
 *
 * @author Kevin Chuquimarca ESPE-DCCO
 */
public class Chicken extends FarmAnimal {

    private static boolean laysEggs;
    private static int numberOfEggs;

    public Chicken(int id, String breed, Date bornOn, int sexOfAnimal,
            boolean laysEggs, int numberOfEggs) {
        super(id, breed, bornOn, sexOfAnimal);
        Chicken.laysEggs = laysEggs;
        Chicken.numberOfEggs = numberOfEggs;
    }

    public static int calculateEggsOfChicken(int daysLife) {
        if (daysLife > 140) {
            return (daysLife - 140);
        }
        Chicken.laysEggs = false;
        return 0;
    }

    public static float calculatePriceOfEggs(int totalEggs, int priceOfOneEgg) {
        Chicken.numberOfEggs = totalEggs;
        float price = priceOfOneEgg;
        return (price/100) * totalEggs;
    }

    @Override
    public String toString() {
        return "Chicken{" + super.toString() + ", laysEggs=" + laysEggs
                + ", numberOfEggs=" + numberOfEggs + '}';
    }

    public static boolean isLaysEggs() {
        return laysEggs;
    }

    public static void setLaysEggs(boolean laysEggs) {
        Chicken.laysEggs = laysEggs;
    }

    public static int getNumberOfEggs() {
        return numberOfEggs;
    }

    public static void setNumberOfEggs(int numberOfEggs) {
        Chicken.numberOfEggs = numberOfEggs;
    }

    
}
