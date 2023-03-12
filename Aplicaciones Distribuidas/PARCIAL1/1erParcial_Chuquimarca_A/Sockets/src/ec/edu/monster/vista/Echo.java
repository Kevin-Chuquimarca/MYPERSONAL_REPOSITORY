/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.monster.vista;

import ec.edu.monster.controlador.ControladorServidor;

/**
 *
 * @author santi
 */
public class Echo {

    public static void main(String[] args) {
        ControladorServidor servidor = new ControladorServidor();
        servidor.initServer();
    }
}
