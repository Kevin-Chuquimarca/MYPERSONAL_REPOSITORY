/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.collectionandarray.view;

import ec.edu.espe.collectionandarray.model.Movie;
import ec.edu.espe.collectionandarray.model.Room;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Kevin Chuquimarca ESPE-DCCO
 */
public class FarmSystem {

    public static void main(String[] args) {
        System.out.println("Kevin Chuquimarca --> 08 colection and array");
        
        Collection<Movie> movies = new ArrayList<>();
        Collection<Room> rooms = new ArrayList<>();

        movies.add(new Movie("Avengers End Game", "2.30.25", "Science Fiction", 3.50f));
        movies.add(new Movie("Avatar", "2.10.25", "Science Fiction", 3.75f));
        movies.add(new Movie("Titanic", "1.50.25", "Romantic", 3.25f));
        movies.add(new Movie("Toy Story 4", "1.50.25", "Animated", 3.50f));
        movies.add(new Movie("Nemo", "1.40.25", "Animated", 3.25f));
        movies.add(new Movie("Batman", "2.05.25", "Science Fiction", 3.00f));

        movies.forEach((mov) -> {
            System.out.println("movie " + mov);
        });

        for (int j = 0; j < 5; j++) {
            rooms.add(new Room((j + 1), 150, "2D", 1.50f));
            rooms.add(new Room((j + 6), 175, "3D", 2.50f));
        }

        rooms.forEach((rm) -> {
            System.out.println("room " + rm);
        });
    }
}
