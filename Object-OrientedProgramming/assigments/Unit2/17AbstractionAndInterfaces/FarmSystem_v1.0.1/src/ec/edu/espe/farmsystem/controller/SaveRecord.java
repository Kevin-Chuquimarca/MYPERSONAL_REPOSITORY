/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.farmsystem.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ec.edu.espe.farmsystem.model.FarmAnimal;
import ec.edu.espe.filemanagerlibrary.FileManager;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Kevin Chuquimarca ESPE-DCCO
 */
public class SaveRecord {

    public void saveRecordInTheJson(String fileName, ArrayList<FarmAnimal> farmAnimals) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileManager.deleteFile(fileName + ".json");
        FileManager.writeFile(fileName + ".json", gson.toJson(farmAnimals));
    }
}
