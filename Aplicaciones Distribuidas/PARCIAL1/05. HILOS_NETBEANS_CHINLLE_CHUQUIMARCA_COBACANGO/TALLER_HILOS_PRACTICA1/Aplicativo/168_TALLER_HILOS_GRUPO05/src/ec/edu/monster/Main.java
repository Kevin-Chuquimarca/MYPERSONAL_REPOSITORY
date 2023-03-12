/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.monster;

import javax.swing.JFrame;
import  ec.edu.monster.vista.PelotaVista;

/**
 *
 * @author Grupo5
 */
public class Main {
    public static void main(String[] args) {
        JFrame frameApp = new PelotaVista();
        frameApp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameApp.setVisible(true);
    }
}
