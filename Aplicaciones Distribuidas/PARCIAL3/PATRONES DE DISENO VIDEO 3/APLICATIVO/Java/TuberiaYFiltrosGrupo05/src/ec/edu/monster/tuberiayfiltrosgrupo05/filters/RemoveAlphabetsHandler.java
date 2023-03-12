/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.monster.tuberiayfiltrosgrupo05.filters;

/**
 *
 * @author santi
 */
public class RemoveAlphabetsHandler implements Handler<String, String> {

    @Override
    public String process(String input) {
        return input.replaceAll("[a-zA-Z]", "");
    }

}
