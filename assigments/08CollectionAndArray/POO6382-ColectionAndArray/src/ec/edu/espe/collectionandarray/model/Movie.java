/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.collectionandarray.model;

/**
 *
 * @author Kevin Chuquimarca ESPE-DCCO
 */
public class Movie {
    private static int indexCounter = 10001;
    private int idMovie;
    private String title;
    private String duration;
    private String gender;
    private float priceMovie;
    
    public Movie(String title, String duration, String gender, float priceMovie) {
        this.idMovie = 1;
        this.idMovie = indexCounter = 1;
        this.idMovie = indexCounter +1;
        this.indexCounter = this.indexCounter + 1;
        this.title = title;
        this.duration = duration;
        this.gender = gender;
        this.priceMovie = priceMovie;
    }

    @Override
    public String toString() {
        return "Movie{" + "idMovie=" + idMovie + ", title=" + title + ", duration=" + duration + ", gender=" + gender + ", priceMovie=" + priceMovie + '}';
    }

    /**
     * @return the idMovie
     */
    public int getIdMovie() {
        return idMovie;
    }

    /**
     * @param idMovie the idMovie to set
     */
    public void setIdMovie(int idMovie) {
        this.idMovie = idMovie;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the duration
     */
    public String getDuration() {
        return duration;
    }

    /**
     * @param duration the duration to set
     */
    public void setDuration(String duration) {
        this.duration = duration;
    }

    /**
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @return the priceMovie
     */
    public float getPriceMovie() {
        return priceMovie;
    }

    /**
     * @param priceMovie the priceMovie to set
     */
    public void setPriceMovie(float priceMovie) {
        this.priceMovie = priceMovie;
    }

    public int getIndexCounter() {
        return indexCounter;
    }
    
}
