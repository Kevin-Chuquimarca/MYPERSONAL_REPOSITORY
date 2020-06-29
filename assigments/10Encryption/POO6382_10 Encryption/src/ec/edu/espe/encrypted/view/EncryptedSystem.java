/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.encrypted.view;

import ec.edu.espe.encrypted.controller.RegisterLogin;

/**
 *
 * @author Kevin Chuquimarca ESPE-DCCO
 */
public class EncryptedSystem {
    public static void main(String[] args) {
        System.out.println("Kevin Chuquimarca --> 10 Encryption");
        RegisterLogin registry = new RegisterLogin();
        registry.registerOfUser();
    }
}
