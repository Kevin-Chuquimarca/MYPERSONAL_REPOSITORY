/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.encrypted.controller;

import ec.edu.espe.encrypted.utils.EncryptedKey;
import ec.edu.espe.encrypted.utils.FileManager;
import ec.edu.espe.encrypted.model.UserToRegister;
import ec.edu.espe.encrypted.utils.DataValidation;

/**
 *
 * @author Kevin Chuquimarca ESPE-DCCO
 */
public class RegisterLogin {

    private UserToRegister user;
    private FileManager file;
    
    DataValidation in = new DataValidation();

    public boolean Login() {
        boolean access = true;
        file = new FileManager("LoginList.csv");
        String answer = "";
        String name = in.getString("Enter your name of user: ");
        if (file.findUser(name)) {
            String key = in.getString("Enter your key of user: ");
            if (key.equals(EncryptedKey.decryptKey(searchUserKey(name)))) {
                System.out.println("Correct key");
                answer = "Welcome " + name;
            } else {
                System.out.println("Incorrect key");
                answer = "Access denied";
                access = false;
            }
        }
        else{
            access = false;
        }
        System.out.println(answer);
        return access;
    }

    public String searchUserKey(String keyEntered) {
        String[] userSearched = null;
        int cont = 0;
        file = new FileManager("LoginList.csv");
        file.findUser(keyEntered);
        file.getLineSeekered();
        while (cont < 1) {
            userSearched = file.getLineSeekered().split(",");
            cont++;
        }
        return userSearched[1];
    }

    public String registerNewUser() {
        String answer;
        String name = in.getString("Enter the name of new user: ");
        String key = in.getString("Enter the key of new user: ");
        String question = in.getStringAnswer("You want to save your "
                + "user data:");
        if ("yes".equals(question)) {
            user = new UserToRegister(name, EncryptedKey.encryptKey(key));
            file = new FileManager("LoginList.csv");
            file.writeFile(user.toString());
            System.out.println("Information saved");
            answer = "User register";
        } else {
            answer = "Unregistered user";
        }
        return answer;
    }
}
