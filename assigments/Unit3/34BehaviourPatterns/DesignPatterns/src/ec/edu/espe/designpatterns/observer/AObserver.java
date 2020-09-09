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
public class AObserver implements IObserver{

    private String nombre;

    public AObserver(String nombre) {
        this.setNombre(nombre);
        System.out.println("Observer [" + this.nombre + "] created");
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void observadoActualizado() {
        System.out.println("Observer [" + this.getNombre() + "] has the notification");
    }
}
