package ec.edu.espe.File.model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Smartphone implements Serializable {

    private int id;
    private String name;
    private String brand;
    private String color;
    private float price;

    public Smartphone(int id, String name, String brand, String color, float price) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.color = color;
        this.price = price;
    }

    public void writeInFile(Smartphone smartPhone) throws IOException {
        try {
            File file = new File("file.txt");
            FileWriter fWriter;
            BufferedWriter bWriter;
            if (file.exists()) {
                fWriter = new FileWriter(file, true);
                bWriter = new BufferedWriter(fWriter);
                bWriter.newLine();
                bWriter.write(smartPhone.id + "," + smartPhone.name + "," + smartPhone.brand + "," + smartPhone.color + "," + smartPhone.price);
            } else {
                fWriter = new FileWriter(file);
                bWriter = new BufferedWriter(fWriter);
                bWriter.write(smartPhone.id + "," + smartPhone.name + "," + smartPhone.brand + "," + smartPhone.color + "," + smartPhone.price);
            }
            bWriter.close();
            fWriter.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public void writeClassFile(Smartphone smartPhone) {
        FileOutputStream fileClass = null;
        try {
            fileClass = new FileOutputStream("fileClass.txt");
            ObjectOutputStream direction = new ObjectOutputStream(fileClass);
            direction.writeObject(smartPhone);
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        } finally {
            try {
                fileClass.close();
            } catch (IOException ex) {
            }
        }
    }
}
