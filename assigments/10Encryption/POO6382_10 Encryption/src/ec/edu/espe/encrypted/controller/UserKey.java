/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.encrypted.controller;

/**
 *
 * @author Kevin Chuquimarca ESPE-DCCO
 */
public class UserKey {

    private static int auxKey;
    private static char auxChar;

    public static String encryptKey(String key) {
        String keyEncrypt = "";
        for (int i = 0; i < key.length(); i++) {
            auxKey = key.charAt(i);
            if (auxKey > 64 & auxKey < 123) {
                auxKey = auxKey + 4;
                auxChar = (char) (auxKey);
                keyEncrypt = keyEncrypt + auxChar;
            } else {
                auxKey = auxKey - 10;
                auxChar = (char) (auxKey);
                keyEncrypt = keyEncrypt + auxChar;
            }
        }
        return keyEncrypt;
    }

    public static String decryptKey(String key) {
        String keyEncrypt = "";
        for (int i = 0; i < key.length(); i++) {
            auxKey = key.charAt(i);
            if (auxKey > 68 & auxKey < 127) {
                auxKey = auxKey - 4;
                auxChar = (char) (auxKey);
                keyEncrypt = keyEncrypt + auxChar;
            } else {
                auxKey = auxKey + 10;
                auxChar = (char) (auxKey);
                keyEncrypt = keyEncrypt + auxChar;
            }
        }
        return keyEncrypt;
    }
}
