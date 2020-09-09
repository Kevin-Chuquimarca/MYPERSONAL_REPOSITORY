/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.designpatterns.strategy;

/**
 *
 * @author Kevin Chuquimarca ESPE-DCCO
 */
public class SortApp {

    public static void sortApp() {
        int data[] = {3, 6, 4, 6, 7, 8, 5, 6, 7, 5, 3, 3};
        SortingContext sc = new SortingContext();
        int sortedList[] = sc.sort(data);
        for (int i = 0; i < sortedList.length; i++) {
            System.out.println(sortedList[i]);
        }
    }
}
