/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.monster.controlador;

import ec.edu.monster.modelo.Usuario;

/**
 *
 * @author santi
 */
public class ControlLlegada extends Thread {

    private Usuario usuario;

    public ControlLlegada(Usuario usuario) {
        this.usuario = usuario;
    }

    public void run() {
        if (usuario.getHoraLlegada() > 8.00) {
            System.out.println("El usuario " + usuario.getNombre() + " llego tarde el día " + usuario.getDiaIngreso());
        } else {
            System.out.println("El usuario " + usuario.getNombre() + " llego temprano el día " + usuario.getDiaIngreso());
        }
    }
}
