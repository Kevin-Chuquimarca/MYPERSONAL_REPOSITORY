/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.monster.capasgrupo05.service;

import ec.edu.monster.capasgrupo05.controller.CakeJpaController;
import ec.edu.monster.capasgrupo05.data.Cake;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author santi
 */
public class CakeBakingServiceImpl implements CakeBakingService{

    @Override
    public List<Cake> getAllCakes() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CapasGrupo05PU");

        CakeJpaController cakeJpa = new CakeJpaController(emf);
        return cakeJpa.findCakeEntities();
    }
    
}
