/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.encrypted.view;

import ec.edu.espe.encrypted.controller.RegisterLogin;
import ec.edu.espe.encrypted.utils.DataValidation;

/**
 *
 * @author Kevin Chuquimarca ESPE-DCCO
 */
public class EncryptedSystem {

    public static void main(String[] args) {
        DataValidation in = new DataValidation();
        System.out.println("Kevin Chuquimarca --> 10 Encryption");
        RegisterLogin registry = new RegisterLogin();
        int option;
        do {
            option = in.getInt(" 1: Login \n 2: Registrar a new user \n 3: Exit \nEnter the option: ", 1);
            switch (option) {
                case 1:
                    registry.Login();
                    break;
                case 2:
                    if (registry.Login()) {
                        System.out.println(registry.registerNewUser());
                    }
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Incorrect option");
                    break;
            }
        } while (option != 3);
    }
}
