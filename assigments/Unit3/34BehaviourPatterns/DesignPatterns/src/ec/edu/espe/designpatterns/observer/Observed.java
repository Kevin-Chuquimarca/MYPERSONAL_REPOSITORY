/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.designpatterns.observer;

import java.util.ArrayList;

/**
 *
 * @author Kevin Chuquimarca ESPE-DCCO
 */
public class Observed {

    private ArrayList<IObserver> observers = new ArrayList<IObserver>();

    public Observed() {
    }

    public void agregarObservador(IObserver o) {
        observers.add(o);
        notificarObservadores();
    }

    public void eliminarObservador(IObserver o) {
        observers.remove(o);
    }

    public void notificarObservadores() {
        observers.forEach((obj) -> {
            obj.observadoActualizado();
        });
    }
}
