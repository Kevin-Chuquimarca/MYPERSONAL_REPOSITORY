package ec.edu.espe.File.utils;

import ec.edu.espe.File.controller.Keyboard;
import ec.edu.espe.File.model.Smartphone;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class FileManager {

    public void dataEntry() throws IOException {
        Keyboard in = new Keyboard();
        float pricePhone;
        int key;
        String namePhone;
        String brandPhone;
        String colorPhone;
        float pPhoneDollars;
        float pPhoneCents;
        key = in.getInt("enter the id[7 characters]: ", 7);
        namePhone = in.getString("enter the name phone: ");
        brandPhone = in.getString("enter the brand phone: ");
        colorPhone = in.getString("enter the color phone: ");
        System.out.println("enter the price phone[$ 0000,00]: ");
        pPhoneDollars = in.getInt("Dollars[0000]: ", 4);
        pPhoneCents = in.getInt("Cents[00]: ", 2);
        pricePhone = pPhoneDollars + (pPhoneCents / 100);
        int option = in.getInt("selection [1 Attribute/ 2 Class]: ", 1);
        if (option == 1){
            writeInFile( key, namePhone, brandPhone, colorPhone, pricePhone);
        }
        else{
            writeClassFile();
        }
        
    }

    public void writeInFile( int key1, String namePhone1, String brandPhone1, String colorPhone1, float pricePhone1) throws IOException {

        try {
            File file = new File("file.txt");
            FileWriter fWriter;
            BufferedWriter bWriter;
            if (file.exists()) {
                fWriter = new FileWriter(file, true);
                bWriter = new BufferedWriter(fWriter);
                bWriter.newLine();
                bWriter.write(key1 + "," + namePhone1 + "," + brandPhone1 + "," + colorPhone1 + "," + pricePhone1);
            } else {
                fWriter = new FileWriter(file);
                bWriter = new BufferedWriter(fWriter);
                bWriter.write(key1 + "," + namePhone1 + "," + brandPhone1 + "," + colorPhone1 + "," + pricePhone1);
            }
            bWriter.close();
            fWriter.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public void writeClassFile() {
        Smartphone smartPhone1 = null;
        FileOutputStream fileClass = null;
        try {
            fileClass = new FileOutputStream("fileClass.txt");
            ObjectOutputStream direction = new ObjectOutputStream(fileClass);
            direction.writeObject(smartPhone1);
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
