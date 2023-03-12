/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.monster.vista;

import ec.edu.monster.controlador.HiloPelotaControlador;
import  ec.edu.monster.controlador.PelotaControlador;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import ec.edu.monster.modelo.PelotaModelo;

/**
 *
 * @author Grupo5
 */

public class PelotaVista extends JFrame {
    private final PelotaPanelVista panel;
    public PelotaModelo pelotaModel;
    public PelotaControlador pelotaController;
    private Thread hiloPelota;

    public PelotaVista() {
        JPanel panelBotones = new JPanel();
        panel = new PelotaPanelVista();
        pelotaController = new PelotaControlador();

        setBounds(600, 300, 400, 350);
        setTitle("Rebotes");
        
        ponerBoton(panelBotones, "Dale!", event -> comenzarJuego());
        ponerBoton(panelBotones, "Salir", event -> System.exit(0));

        add(panel, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);
    }

    private void ponerBoton(Container c, String titulo, ActionListener listener) {
        JButton boton = new JButton(titulo);
        boton.addActionListener(listener);
        
        c.add(boton);
    }

    private void comenzarJuego() {
        pelotaModel = new PelotaModelo();

        panel.agregarPelota(pelotaModel);

        Runnable runnablePelota = new HiloPelotaControlador(pelotaModel, pelotaController, panel);

        hiloPelota = new Thread(runnablePelota);
        hiloPelota.start();
    }
}
