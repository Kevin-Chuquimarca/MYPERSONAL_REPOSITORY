/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.encrypted.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
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
    private boolean answer = true;
    private File file;
    private String lineSeekered;

    public FileManager(String fileName) {
        this.fileName = fileName;
    }

    public boolean createFile() {
        file = new File(fileName);
        if (!file.exists()) {
            try {
                file.createNewFile();
                writeFile("Kevin,OizmrIWTI'()");
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
                Logger.getLogger(Object.class.getName()).log(Level.SEVERE,
                        null, ex);
                answer = false;
            }
        } catch (IOException ex) {
            Logger.getLogger(Object.class.getName()).log(Level.SEVERE, null,
                    ex);
            answer = false;
        }
        return answer;
    }

    public boolean findUser(String wordSeekered) {
        createFile();
        boolean flat = false;
        String line;
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferReader = new BufferedReader(fileReader);
            while ((line = bufferReader.readLine()) != null) {
                String searchWord[] = line.split(",");
                if (searchWord[0].equals(wordSeekered)) {
                    flat = true;
                    setLineSeekered(line);
                }
            }
            if (flat == false) {
                System.out.println("The User don't exist");
                answer = false;
            }
        } catch (IOException ex) {
            Logger.getLogger(Object.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
        return answer;
    }

    public String getLineSeekered() {
        return lineSeekered;
    }

    public void setLineSeekered(String dataSeekerLine) {
        this.lineSeekered = dataSeekerLine;
    }
}
