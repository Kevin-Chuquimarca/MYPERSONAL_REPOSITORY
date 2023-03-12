/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.monster.tuberiayfiltrosgrupo05.filters;

/**
 *
 * @author santi
 */
public class ConvertToCharArrayHandler implements Handler<String, char[]> {

    @Override
    public char[] process(String input) {
        char[] charArray = new char[input.length()];
        for (int i = 0; i < input.length(); i++) {
            charArray[i] = input.charAt(i);
        }
        return charArray;
    }

}
