package ec.edu.espe.FlowControlAndDataTypes.utils;

import java.util.Scanner;

public class Keyboard {

    Scanner string;

    public Keyboard() {
        string = new Scanner(System.in);
    }

    public int getInt(String title, int characters) {
        String data = "";
        while (data.equals("")) {
            System.out.print(title);
            data = string.nextLine();
            if (!data.matches("[0-9]{" + characters + "}")) {
                data = "";
                System.out.println("\nIncorrect data, please repeat the ");
            }
        }
        return Integer.parseInt(data);
    }

    public String getString(String title) {
        String data = "";
        while (data.equals("")) {
            System.out.print(title);
            data = string.nextLine();
            if (!"yes".equals(data) & !"no".equals(data)) {
                data = "";
            }
        }
        return data;
    }
}
