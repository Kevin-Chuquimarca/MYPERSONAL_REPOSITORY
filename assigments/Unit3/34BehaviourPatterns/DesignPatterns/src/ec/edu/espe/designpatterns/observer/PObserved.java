/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.designpatterns.observer;

/**
 *
 * @author Kevin Chuquimarca ESPE-DCCO
 */
public class PObserved {

    public static void pObserved() {
        AObserved objObserved = new AObserved();
        AObserver objObservadorPepe = new AObserver("Pepe");
        objObserved.agregarObservador(objObservadorPepe);
        AObserver objObservadorJuan = new AObserver("Juan");
        objObserved.agregarObservador(objObservadorJuan);
        AObserver objObservadorMarta = new AObserver("Marta");
        objObserved.agregarObservador(objObservadorMarta);
    }
}
