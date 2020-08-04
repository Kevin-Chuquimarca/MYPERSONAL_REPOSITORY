/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.nextpremiers.controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import ec.edu.nextpremiers.model.NextPremier;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Kevin Chuquimarca ESPE-DCCO
 */
public class NextMovieRegister {

    public ArrayList<NextPremier> createMovieList() {
        ArrayList<NextPremier> movies;
        Gson gson = new Gson();
        String jsonMovies = passJsonContentToAString();
        java.lang.reflect.Type movieName = new TypeToken<ArrayList<NextPremier>>() {
        }.getType();
        movies = gson.fromJson(jsonMovies, movieName);
        return movies;
    }

    public String passJsonContentToAString() {
        File f = null;
        FileReader fr = null;
        BufferedReader br = null;
        String jsonMovies = "";
        try {
            f = new File("NextPremier.json");
            fr = new FileReader(f);
            br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                jsonMovies = jsonMovies + line;
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (IOException e2) {
                System.out.println(e2);
            }
        }
        return jsonMovies;
    }
}
