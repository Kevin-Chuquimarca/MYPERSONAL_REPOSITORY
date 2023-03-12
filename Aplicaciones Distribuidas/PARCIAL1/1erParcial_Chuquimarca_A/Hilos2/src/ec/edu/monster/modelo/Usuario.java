/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.monster.modelo;

/**
 *
 * @author santi
 */
public class Usuario {

    private String nombre;
    private String diaIngreso;
    private double horaLlegada;

    public Usuario(String nombre, String diaIngreso, double horaLlegada) {
        this.nombre = nombre;
        this.diaIngreso = diaIngreso;
        this.horaLlegada = horaLlegada;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDiaIngreso() {
        return diaIngreso;
    }

    public void setDiaIngreso(String diaIngreso) {
        this.diaIngreso = diaIngreso;
    }

    public double getHoraLlegada() {
        return horaLlegada;
    }

    public void setHoraLlegada(double horaLlegada) {
        this.horaLlegada = horaLlegada;
    }

}
