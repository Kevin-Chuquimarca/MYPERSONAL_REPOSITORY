/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.table.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import ec.edu.espe.filemanagerlibrary.FileManager;
import ec.edu.espe.table.model.FlashDrive;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 *
 * @author Kevin Chuquimarca ESPE-DCCO
 */
public class FlashDriveRecord {

    public static ArrayList<FlashDrive> consultFlashDrive(String fileName)
            throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        ArrayList<FlashDrive> flashDrives;
        FileManager.createFile(fileName);
        String moviesJson = new String(Files.readAllBytes(Paths.get(fileName)));
        if (gson.fromJson(moviesJson, ArrayList.class) != null) {
            java.lang.reflect.Type typeMovies
                    = new TypeToken<ArrayList<FlashDrive>>() {
                    }.getType();
            flashDrives = gson.fromJson(moviesJson, typeMovies);
            return flashDrives;
        }
        return null;
    }
}
