package ec.edu.espe.File.controller;

import java.util.Scanner;

public class Keyboard {

    Scanner string;

    public Keyboard() {
        string = new Scanner(System.in);
    }

    public String getString(String title) {
        String data = "";
        while (data.equals("")) {
            System.out.print(title);
            data = string.nextLine();
        }
        return data;
    }

    public int getInt(String title, int characters) {
        String data = "";
        while (data.equals("")) {
            System.out.print(title);
            data = string.nextLine();
            if (!data.matches("[0-9]{" + characters + "}")) {
                data = "";
            }
        }
        return Integer.parseInt(data);
    }
}
