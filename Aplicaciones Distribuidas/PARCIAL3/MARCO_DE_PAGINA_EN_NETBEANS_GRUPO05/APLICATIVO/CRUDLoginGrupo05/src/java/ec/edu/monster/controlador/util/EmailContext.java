/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.monster.controlador.util;

/**
 *
 * @author santi
 */
public class EmailContext {
    public static String email;
    public static String passSha;

    public static String getEmail() {
        return email;
    }

    public static void setEmail(String email) {
        EmailContext.email = email;
    }

    public static String getPassSha() {
        return passSha;
    }

    public static void setPassSha(String passSha) {
        EmailContext.passSha = passSha;
    }
}
