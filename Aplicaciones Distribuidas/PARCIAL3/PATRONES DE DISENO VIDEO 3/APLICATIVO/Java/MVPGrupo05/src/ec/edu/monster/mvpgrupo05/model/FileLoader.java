/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.monster.mvpgrupo05.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.Serializable;
import java.util.stream.Collectors;

/**
 *
 * @author santi
 */
public class FileLoader implements Serializable {

    /**
     * Generated serial version UID.
     */
    private static final long serialVersionUID = -4745803872902019069L;

//  private static final Logger LOGGER = LoggerFactory.getLogger(FileLoader.class);
    /**
     * Indicates if the file is loaded or not.
     */
    private boolean loaded;

    /**
     * The name of the file that we want to load.
     */
    private String fileName;

    /**
     * Loads the data of the file specified.
     */
    public String loadData() {
        var dataFileName = this.fileName;
        try ( var br = new BufferedReader(new FileReader(new File(dataFileName)))) {
            var result = br.lines().collect(Collectors.joining("\n"));
            this.loaded = true;
            return result;
        } catch (Exception e) {
//      LOGGER.error("File {} does not exist", dataFileName);
            System.out.println(e.getMessage());
        }

        return null;
    }

    /**
     * Sets the path of the file to be loaded, to the given value.
     *
     * @param fileName The path of the file to be loaded.
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * Gets the path of the file to be loaded.
     *
     * @return fileName The path of the file to be loaded.
     */
    public String getFileName() {
        return this.fileName;
    }

    /**
     * Returns true if the given file exists.
     *
     * @return True, if the file given exists, false otherwise.
     */
    public boolean fileExists() {
        return new File(this.fileName).exists();
    }

    /**
     * Returns true if the given file is loaded.
     *
     * @return True, if the file is loaded, false otherwise.
     */
    public boolean isLoaded() {
        return this.loaded;
    }
}
