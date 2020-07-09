/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.encrypted.utils;

/**
 *
 * @author Kevin Chuquimarca ESPE-DCCO
 */
public class EncryptedKey {

    private static int keySeparated;
    private static char charAscii;

    public static String encryptKey(String keyEntered) {
        String keyEncrypted = "";
        for (int i = 0; i < keyEntered.length(); i++) {
            keySeparated = keyEntered.charAt(i);
            if (keySeparated > 64 & keySeparated < 123) {
                keySeparated = keySeparated + 4;
                charAscii = (char) (keySeparated);
                keyEncrypted = keyEncrypted + charAscii;
            } else {
                keySeparated = keySeparated - 10;
                charAscii = (char) (keySeparated);
                keyEncrypted = keyEncrypted + charAscii;
            }
        }
        return keyEncrypted;
    }

    public static String decryptKey(String keyEntered) {
        String keyDecrypted = "";
        for (int i = 0; i < keyEntered.length(); i++) {
            keySeparated = keyEntered.charAt(i);
            if (keySeparated > 68 & keySeparated < 127) {
                keySeparated = keySeparated - 4;
                charAscii = (char) (keySeparated);
                keyDecrypted = keyDecrypted + charAscii;
            } else {
                keySeparated = keySeparated + 10;
                charAscii = (char) (keySeparated);
                keyDecrypted = keyDecrypted + charAscii;
            }
        }
        return keyDecrypted;
    }
}
