/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ec.edu.monster.tuberiayfiltrosgrupo05;

import ec.edu.monster.tuberiayfiltrosgrupo05.filters.ConvertToCharArrayHandler;
import ec.edu.monster.tuberiayfiltrosgrupo05.filters.RemoveAlphabetsHandler;
import ec.edu.monster.tuberiayfiltrosgrupo05.filters.RemoveDigitsHandler;
import ec.edu.monster.tuberiayfiltrosgrupo05.pipeline.Pipeline;
import java.util.Scanner;

/**
 *
 * @author santi
 */
public class TuberiaYFiltrosGrupo05 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese un valor: ");
        String input = scanner.nextLine();
        var filters = new Pipeline<>(new RemoveAlphabetsHandler())
                .addHandler(new RemoveDigitsHandler())
                .addHandler(new ConvertToCharArrayHandler());
        char[] result = filters.execute(input);
        for (char res : result) {
            System.out.println(res);
        }
    }
}
