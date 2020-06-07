package ec.edu.espe.File.model.view;

import ec.edu.espe.File.controller.Archive;
import java.io.IOException;

public class FarmerSystem {

    public static void main(String[] args) throws IOException {
        System.out.println("Chuquimarca Kevin --> 01Files \n");
        Archive archive = new Archive(null);
        archive.menu();
    }
}
