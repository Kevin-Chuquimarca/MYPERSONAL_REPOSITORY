package ec.edu.espe.File.controller;

import ec.edu.espe.File.model.Smartphone;
import ec.edu.espe.File.utils.Keyboard;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Archive implements Serializable {

    private Smartphone smartPhone;

    public Archive(Smartphone smartPhone) {
        this.smartPhone = smartPhone;
    }

    public void menu() throws IOException {
        Keyboard in = new Keyboard();
        int election;
        int number = 1;
        boolean repeat = false;
        String answer;
        do {
            System.out.println("Smartphone number :" + number);
            readData();
            System.out.println("Choose the metod of the saved in the file");
            do{
                election = in.getInt(" 1: Attributes \n 2: Object \n 3: Cancel saved \n 4: Finish saved", 1);
            }while(election < 1 | election > 4);
            switch (election) {
                case 1:
                    writeInFile();
                    break;
                case 2:
                    writeClassFile();
                    break;
                case 3:
                    election = 1;
                    number--;
                    break;
                case 4:
                    election = 3;
                    repeat = true;
                    break;
            }
            while (false == repeat & election != 4) {
                answer = in.getString("Do you want to save more data [yes/no]: ");
                if (!"no".equals(answer) & !"yes".equals(answer)) {
                    repeat = false;
                }
                if ("no".equals(answer)) {
                    election = 3;
                    repeat = true;
                }
                if ("yes".equals(answer)) {
                    election = 1;
                    repeat = true;
                }
            } 
            number++;
            repeat = false;
        } while (election == 1 | election == 2);
    }

    public void readData() {
        Keyboard in = new Keyboard();
        float pricePhone;
        int key = in.getInt("enter the id[7 characters]: ", 7);
        String namePhone = in.getString("enter the name phone: ");
        String brandPhone = in.getString("enter the brand phone: ");
        String colorPhone = in.getString("enter the color phone: ");
        System.out.println("enter the price phone[$ 0000,00]: ");
        int pPhoneDollars = in.getInt("Dollars[0000]: ", 4);
        float pPhoneCents = in.getInt("Cents[00]: ", 2);
        pricePhone = pPhoneDollars + (pPhoneCents / 100);
        System.out.println("\n$" + pricePhone + "\n");
        smartPhone = new Smartphone(key, namePhone, brandPhone, colorPhone, pricePhone);
    }

    public void writeInFile() throws IOException {
        try {
            java.io.File file = new java.io.File("file.txt");
            FileWriter fWriter;
            BufferedWriter bWriter;
            if (file.exists()) {
                fWriter = new FileWriter(file, true);
                bWriter = new BufferedWriter(fWriter);
                bWriter.newLine();
                bWriter.write(smartPhone.getId() + "," + smartPhone.getName() + "," + smartPhone.getBrand() + "," + smartPhone.getColor() + "," + smartPhone.getPrice());
            } else {
                fWriter = new FileWriter(file);
                bWriter = new BufferedWriter(fWriter);
                bWriter.write(smartPhone.getId() + "," + smartPhone.getName() + "," + smartPhone.getBrand() + "," + smartPhone.getColor() + "," + smartPhone.getPrice());
            }
            bWriter.close();
            fWriter.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public void writeClassFile() {
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
