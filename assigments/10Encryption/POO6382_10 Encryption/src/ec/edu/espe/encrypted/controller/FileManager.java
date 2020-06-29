/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.encrypted.controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kevin Chuquimarca ESPE-DCCO
 */
public class FileManager {

    private String fileName;
    private boolean answer;
    private File file;

    public FileManager(String fileName) {
        this.fileName = fileName;
    }

    public boolean createFile() {
        file = new File(fileName);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(Object.class.getName()).log(Level.SEVERE, null, ex);
                answer = false;
            }
        }
        return answer;
    }

    public boolean writeFile(String informationToSave) {
        createFile();
        try (FileWriter fileWriter = new FileWriter(file, true);
                PrintWriter printWriter = new PrintWriter(fileWriter)) {
            printWriter.println(informationToSave);
            printWriter.close();
            try {
                fileWriter.close();
            } catch (IOException ex) {
                Logger.getLogger(Object.class.getName()).log(Level.SEVERE, null, ex);
                answer = false;
            }
        } catch (IOException ex) {
            Logger.getLogger(Object.class.getName()).log(Level.SEVERE, null, ex);
            answer = false;
        }
        return answer;
    }
}
