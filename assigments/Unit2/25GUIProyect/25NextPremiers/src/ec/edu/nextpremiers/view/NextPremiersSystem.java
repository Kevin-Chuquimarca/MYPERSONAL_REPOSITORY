/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.nextpremiers.view;

import java.io.IOException;

/**
 *
 * @author Kevin Chuquimarca ESPE-DCCO
 */
public class NextPremiersSystem {

    public static void main(String[] args) throws IOException {
        FrmCinema cinema = new FrmCinema();
        cinema.showDataMovie();
        cinema.setVisible(true);
    }
}
