/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.encrypted.model;

/**
 *
 * @author Kevin Chuquimarca ESPE-DCCO
 */
public class UserToRegister {
    private String nameUser;
    private String userkey;

    public UserToRegister(String nameUser, String userKey) {
        this.nameUser = nameUser;
        this.userkey = userKey;
    }

    @Override
    public String toString() {
        return nameUser + "," + userkey;
    }
}
