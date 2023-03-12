/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ec.edu.monster.mvpgrupo05;

import ec.edu.monster.mvpgrupo05.model.FileLoader;
import ec.edu.monster.mvpgrupo05.presenter.FileSelectorPresenter;
import ec.edu.monster.mvpgrupo05.view.FileSelectorJFrame;

/**
 *
 * @author santi
 */
public class MVPGrupo05 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        var loader = new FileLoader();
        var frame = new FileSelectorJFrame();
        var presenter = new FileSelectorPresenter(frame);
        presenter.setLoader(loader);
        presenter.start();
    }

}
