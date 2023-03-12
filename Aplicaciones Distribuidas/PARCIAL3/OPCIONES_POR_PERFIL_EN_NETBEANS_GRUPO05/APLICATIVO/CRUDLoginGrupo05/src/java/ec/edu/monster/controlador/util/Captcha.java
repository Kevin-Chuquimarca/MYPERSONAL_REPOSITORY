/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.monster.controlador.util;

import java.util.Random;

/**
 *
 * @author santi
 */
public class Captcha {
    private static final String CHAR_LIST = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
    private static final int RANDOM_STRING_LENGTH = 6;
    public static String valor;

    public static String generateCaptcha() {
        StringBuilder captchaBuilder = new StringBuilder();
        Random random = new Random();

        while (captchaBuilder.length() < RANDOM_STRING_LENGTH) {
            int index = (int) (random.nextFloat() * CHAR_LIST.length());
            captchaBuilder.append(CHAR_LIST.charAt(index));
        }
        valor = captchaBuilder.toString();
        return captchaBuilder.toString();
    }
}
