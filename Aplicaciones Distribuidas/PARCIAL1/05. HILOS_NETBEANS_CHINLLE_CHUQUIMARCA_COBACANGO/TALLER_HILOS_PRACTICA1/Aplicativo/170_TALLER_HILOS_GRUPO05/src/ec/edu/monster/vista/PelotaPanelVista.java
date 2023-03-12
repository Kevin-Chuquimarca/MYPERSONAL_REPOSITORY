package ec.edu.monster.vista;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JPanel;

import ec.edu.monster.controlador.PelotaControlador;
import ec.edu.monster.modelo.PelotaModelo;

class PelotaPanelVista extends JPanel {
    private final ArrayList<PelotaModelo> arrPelotas = new ArrayList<>();
    private final PelotaControlador pelotaController = new PelotaControlador();
    
    public void agregarPelota(PelotaModelo pelota) {
        arrPelotas.add(pelota);
    }

    public void paint(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        arrPelotas.forEach(p -> g2.fill(pelotaController.obtenerForma(p)));
    }
}