/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.farmsystem.interfaces;

import ec.edu.espe.farmsystem.abstractions.Food;
/**
 *
 * @author Kevin Chuquimarca ESPE-DCCO
 */
public interface IFarmAnimal {
    
    public float computeFoodMoney(Food food);
    public float computeEarningMoney(float product);
}
