/** Copyright ESPE-DECC
 */
package ec.edu.espe.farmsystem.model;

import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Edison Lascano ESPE-DCCO
 */
public class Pig extends FarmAnimal {

    private static boolean sterilized;
    private static float weightKG;

    public Pig(int id, String breed, Date bornOn, int sexOfAnimal, boolean sterilized, float weightKG) {
        super(id, breed, bornOn, sexOfAnimal);
        Pig.sterilized = sterilized;
        Pig.weightKG = weightKG;
    }

    public static String increaseFood(int month) {
        if (weightKG > 100 | month > 5){
        return "The pig is ready to sell";
        }
        return "Increase food portion";
    }

    public static float calculatePriceOfThePig() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the price for KG of the meat of pork: ");
        float priceForKg = scanner.nextFloat();
        return weightKG * priceForKg;
    }

    @Override
    public String toString() {
        return "Pig{" + super.toString() + ", sterilized=" + sterilized
                + ", weightKG" + weightKG + '}';
    }

    public static boolean isSterilized() {
        return sterilized;
    }

    public static void setSterilized(boolean sterilized) {
        Pig.sterilized = sterilized;
    }

    public static float getWeightKG() {
        return weightKG;
    }

    public static void setWeightKG(float weightKG) {
        Pig.weightKG = weightKG;
    }
    
    
}
