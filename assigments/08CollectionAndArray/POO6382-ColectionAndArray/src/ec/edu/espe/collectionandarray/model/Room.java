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
public class Room {
    private int numRoom;
    private int numSeats;
    private String formatRoom;
    private float priceTypeRoom;

    public Room(int numRoom, int numSeats, String formatRoom, float priceTypeRoom) {
        this.numRoom = numRoom;
        this.numSeats = numSeats;
        this.formatRoom = formatRoom;
        this.priceTypeRoom = priceTypeRoom;
    }

    @Override
    public String toString() {
        return "Room{" + "numRoom=" + numRoom + ", numSeats=" + numSeats + ", formatRoom=" + formatRoom + ", priceTypeRoom=" + priceTypeRoom + '}';
    }

    
    
    /**
     * @return the numRoom
     */
    public int getNumRoom() {
        return numRoom;
    }

    /**
     * @param numRoom the numRoom to set
     */
    public void setNumRoom(int numRoom) {
        this.numRoom = numRoom;
    }

    /**
     * @return the numSeats
     */
    public int getNumSeats() {
        return numSeats;
    }

    /**
     * @param numSeats the numSeats to set
     */
    public void setNumSeats(int numSeats) {
        this.numSeats = numSeats;
    }

    /**
     * @return the formatRoom
     */
    public String getFormatRoom() {
        return formatRoom;
    }

    /**
     * @param formatRoom the formatRoom to set
     */
    public void setFormatRoom(String formatRoom) {
        this.formatRoom = formatRoom;
    }

    /**
     * @return the priceTypeRoom
     */
    public float getPriceTypeRoom() {
        return priceTypeRoom;
    }

    /**
     * @param priceTypeRoom the priceTypeRoom to set
     */
    public void setPriceTypeRoom(float priceTypeRoom) {
        this.priceTypeRoom = priceTypeRoom;
    }
    
    
}
