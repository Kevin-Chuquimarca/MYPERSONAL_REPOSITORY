/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ec.edu.monster.mvcgrupo05;

import ec.edu.monster.mvcgrupo05.controller.PatientController;
import ec.edu.monster.mvcgrupo05.model.Fatigue;
import ec.edu.monster.mvcgrupo05.model.PatientModel;
import ec.edu.monster.mvcgrupo05.model.Health;
import ec.edu.monster.mvcgrupo05.model.Nourishment;
import ec.edu.monster.mvcgrupo05.view.PatientView;

/**
 *
 * @author santi
 */
public class MVCGrupo05 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PatientController patientController = new PatientController(new PatientModel(new Health(), new Fatigue(), new Nourishment()), new PatientView());
        patientController.updateView();
    }

}
