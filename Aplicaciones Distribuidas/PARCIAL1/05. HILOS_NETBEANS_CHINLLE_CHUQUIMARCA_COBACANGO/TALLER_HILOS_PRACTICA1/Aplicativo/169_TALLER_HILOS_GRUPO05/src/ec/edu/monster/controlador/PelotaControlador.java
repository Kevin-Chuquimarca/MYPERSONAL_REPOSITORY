/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package  ec.edu.monster.controlador;

import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import ec.edu.monster.modelo.PelotaModelo;

/**
 *
 * @author Grupo5
 */
public class PelotaControlador {
    public void moverPelota(Rectangle2D limites, PelotaModelo pelota) {
        pelota.x += pelota.dx;
        pelota.y += pelota.dy;

        if (pelota.x < limites.getMinX()) {
            pelota.x = limites.getMinX();
            pelota.dx = -pelota.dx;
        }

        if (pelota.x + PelotaModelo.TAMX >= limites.getMaxX()) {
            pelota.x = limites.getMaxX() - PelotaModelo.TAMX;
            pelota.dx = -pelota.dx;
        }

        if (pelota.y < limites.getMinY()) {
            pelota.y = limites.getMinY();
            pelota.dy = -pelota.dy;
        }

        if (pelota.y + PelotaModelo.TAMY >= limites.getMaxY()) {
            pelota.y = limites.getMaxY() - PelotaModelo.TAMY;
            pelota.dy = -pelota.dy;
        }
    }

    public Ellipse2D obtenerForma(PelotaModelo pelota) {
        return new Ellipse2D.Double(
                pelota.x,
                pelota.y,
                PelotaModelo.TAMX,
                PelotaModelo.TAMY);
    }
}
