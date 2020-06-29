/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.encrypted.controller;

import ec.edu.espe.encrypted.model.CustomerKey;
import ec.edu.espe.encrypted.utils.DataValidation;
import java.util.Scanner;

/**
 *
 * @author Kevin Chuquimarca ESPE-DCCO
 */
public class RegisterLogin {

    CustomerKey customer;
    FileManager file;
    Scanner scan = new Scanner(System.in);
    DataValidation in = new DataValidation();

    public void registerOfUser() {
        int option;
        do {
            option = in.getInt(" 1: Login \n 2: Exit \nEnter the option: ", 1);
            switch (option) {
                case 1:
                    registerData();
                    break;
                case 2:
                    break;
                default:
                    System.out.println("Incorrect option");
                    break;
            }
        } while (option != 2);
    }

    public boolean registerData() {
        boolean repeat = false;
        String name = in.getString("Enter the name of user: ");
        String key = in.getString("Enter the key of user: ");
        String question = in.getStringAnswer("You want to save your user data: ");
        if ("yes".equals(question)) {
            customer = new CustomerKey(name, encryptKey(key));
            file = new FileManager("LoginList.csv");
            file.writeFile(customer.toString());
            System.out.println("Information saved");
            repeat = true;
        }
        return repeat;
    }

    public String encryptKey(String key) {
        int auxKey;
        char auxChar;
        String keyEncrypt = "";
        for (int i = 0; i < key.length(); i++) {
            auxKey = key.charAt(i);
            auxKey = auxKey + 1;
            auxChar = (char) (auxKey);
            keyEncrypt = keyEncrypt + auxChar;
        }
        return keyEncrypt;
    }
}
