/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.monster.controlador.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author santi
 */
public class SHA1 {

    static public String getHashSHA1(String input) throws NoSuchAlgorithmException {
        try {
            // Crear una instancia de MessageDigest con el algoritmo SHA1
            MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
            // Actualizar el digest con los datos a hashear
            messageDigest.update(input.getBytes());
            // Obtener el hash en formato de bytes
            byte[] hash = messageDigest.digest();
            // Convertir el hash a hexadecimal
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                hexString.append(String.format("%02x", b));
            }
            return hexString.toString().toUpperCase();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
