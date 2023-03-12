/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.monster.controlador.util;

import ec.edu.monster.modelo.entidades.PeempEmple;
import java.security.SecureRandom;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author santi
 */
public class GenerarUsuario {

    private static final int PASSWORD_LENGTH = 8;
    private static final String ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final String dominio = "@gmail.com";

    static public String generarContraseniaTemp() {
        SecureRandom secureRandom = new SecureRandom();
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < PASSWORD_LENGTH; i++) {
            int randomIndex = secureRandom.nextInt(ALPHABET.length());
            password.append(ALPHABET.charAt(randomIndex));
        }
        return password.toString();
    }

    static private String removeNumbersFromEmail(String email) {
        int i = 0;
        while (i < email.length() && !Character.isDigit(email.charAt(i))) {
            i++;
        }
        return email.substring(0, i) + email.substring(email.indexOf("@"));
    }

    static public String generarCorreo(String nombre, String apellido, List<PeempEmple> listaEmple) {
        int contUsuariosSimilares = 0;
        nombre = nombre.toLowerCase();
        apellido = apellido.toLowerCase();
        String email = nombre + apellido + dominio;
        contUsuariosSimilares = listaEmple.stream().filter(emple -> email.equals(removeNumbersFromEmail(emple.getPeempEmail()))).collect(Collectors.toList()).size();
        return nombre + apellido + contUsuariosSimilares + dominio;
    }
}
