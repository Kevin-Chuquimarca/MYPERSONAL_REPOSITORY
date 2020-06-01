package ec.edu.espe.File.view;

import ec.edu.espe.File.model.Keyboard;
import ec.edu.espe.File.model.Smartphone;
import java.io.IOException;
import java.util.Scanner;

public class FarmerSystem {

    public static void main(String[] args) throws IOException {
        System.out.println("Chuquimarca Kevin --> 01Files \n");
        Keyboard in = new Keyboard();
        int election;
        int number = 1;
        String answer;
        float pricePhone;
        int key;
        String namePhone;
        String brandPhone;
        String colorPhone;
        float pPhoneDollars;
        float pPhoneCents;
        do {
            System.out.println("Smartphone number :" + number);
            Scanner scanner = new Scanner(System.in);   //read of dates
            key = in.getInt("enter the id[7 characters]: ", 7);
            namePhone = in.getString("enter the name phone: ");
            brandPhone = in.getString("enter the brand phone: ");
            colorPhone = in.getString("enter the color phone: ");
            System.out.println("enter the price phone[$ 0000,00]: ");
            pPhoneDollars = in.getInt("Dollars[0000]: ", 4);
            pPhoneCents = in.getInt("Cents[00]: ", 2);
            pricePhone = pPhoneDollars + (pPhoneCents / 100);
            Smartphone smartPhone = new Smartphone(key, namePhone, brandPhone, colorPhone, pricePhone);
            System.out.println("Choose the metod of the saved in the file");
            System.out.println(" 1: Attributes \n 2: Object \n 3: Cancel saved \n 4: Finish saved");
            election = scanner.nextInt();

            switch (election) {
                case 1:
                    smartPhone.writeInFile(smartPhone);
                    break;
                case 2:
                    smartPhone.writeClassFile(smartPhone);
                    break;
                case 3:
                    election = 2;
                    number--;
                    break;
                case 4:
                    election = 3;
                default:
                    System.out.println("Fail, please insert the correct option");
                    break;
            }
            answer = in.getString("Do you want to save more data [yes/no]: ");
            if ("no".equals(answer)) {
                election = 3;
            }
            number++;
        } while (election == 1 | election == 2);
    }
}
