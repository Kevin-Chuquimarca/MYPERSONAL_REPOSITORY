/** Copyright ESPE-DECC
*/

package ec.edu.espe.farmsystem.model;

import java.util.Date;

/**
 *
 * @author Edison Lascano ESPE-DCCO
 */
public class Pig extends FarmAnimal{
    private static float weighKg;
    
    public Pig(float weightKg, int id, String breed, Date bornOn) {
        super(id, breed, bornOn);
        Pig.weighKg = weightKg;
    }
    
    public static String toSellPig(){
        if (weighKg > 100){
            return "the pig is ready to be sold"; 
        }
        return "the pig isn't ready to be sold";
    }

    @Override
    public String toString() {
        return "Pig{" + "weighKg=" + weighKg + super.toString() + '}';
    }

    public float getWeighKg() {
        return weighKg;
    }

    public void setWeighKg(float weighKg) {
        Pig.weighKg = weighKg;
    }
}
