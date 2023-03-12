/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package aplicacionclientegrupo05;

import ec.edu.monster.modelo.RepetirRemote;
import javax.ejb.EJB;
import javax.swing.JOptionPane;

/**
 *
 * @author santi
 */
public class Main {

    @EJB
    private static RepetirRemote repetir;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        JOptionPane.showMessageDialog(null, repetir.repetir("Si vez este mensaje todo salio bien."));
    }
}
