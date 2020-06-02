package ec.edu.espe.File.view;

import ec.edu.espe.File.controller.Keyboard;
import ec.edu.espe.File.utils.FileManager;
import java.io.IOException;
import java.util.Scanner;

public class FarmerSystem {

    public static void main(String[] args) throws IOException {
        System.out.println("Chuquimarca Kevin --> 01Files \n");
        Keyboard in = new Keyboard();
        int election = 1;
        int number = 1;
        String answer;
        FileManager fileManager = null;
        do {
            System.out.println("Smartphone number :" + number);
            Scanner scanner = new Scanner(System.in);   //read of dates
            
            switch (election) {
                case 1:
                    try{
                        fileManager.dataEntry();
                    }catch (IOException ex){
                    }
                    break;
                case 2:
                    election = 2;
                    number--;
                    break;
                case 3:
                    election = 3;
                default:
                    System.out.println("Fail, please insert the correct option");
                    break;
            }
            System.out.println("Choose the metod of the saved in the file");
            election = in.getInt(" 1: Save \n 3: Cancel saved \n 4: Finish saved: ", 1);
            answer = in.getString("Do you want to save more data [yes/no]: ");
            if ("no".equals(answer)) {
                election = 3;
            }
            number++;
        } while (election == 1 | election == 2);
    }
}
