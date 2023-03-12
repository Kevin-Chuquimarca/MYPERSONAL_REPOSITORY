/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ec.edu.monster.tuberiayfiltrosgrupo05.filters;

/**
 *
 * @author santi
 */
public interface Handler<I, O> {

    public O process(I input);
}
