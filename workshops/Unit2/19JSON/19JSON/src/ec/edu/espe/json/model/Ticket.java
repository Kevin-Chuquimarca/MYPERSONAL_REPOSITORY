/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.json.model;

/**
 *
 * @author Kevin Chuquimarca ESPE-DCCO
 */
public class Ticket {

    private int key;
    private int seat;
    private String titleMovie;
    private int roomAssignment;
    private float ticketPrice;

    public Ticket(int key, int seat, String titleMovie, int roomAssignment, float priceTicket) {
        this.key = key;
        this.seat = seat;
        this.titleMovie = titleMovie;
        this.roomAssignment = roomAssignment;
        this.ticketPrice = priceTicket;
    }

    @Override
    public String toString() {
        return "Ticket{" + "key=" + key + ", seat=" + seat + ", titleMovie=" + titleMovie + ", roomAssignment=" + roomAssignment + ", priceTicket=" + ticketPrice + '}';
    }

    /**
     * @return the key
     */
    public int getKey() {
        return key;
    }

    /**
     * @param key the key to set
     */
    public void setKey(int key) {
        this.key = key;
    }

    /**
     * @return the seat
     */
    public int getSeat() {
        return seat;
    }

    /**
     * @param seat the seat to set
     */
    public void setSeat(int seat) {
        this.seat = seat;
    }

    /**
     * @return the titleMovie
     */
    public String getTitleMovie() {
        return titleMovie;
    }

    /**
     * @param titleMovie the titleMovie to set
     */
    public void setTitleMovie(String titleMovie) {
        this.titleMovie = titleMovie;
    }

    /**
     * @return the roomAssignment
     */
    public int getRoomAssignment() {
        return roomAssignment;
    }

    /**
     * @param roomAssignment the roomAssignment to set
     */
    public void setRoomAssignment(int roomAssignment) {
        this.roomAssignment = roomAssignment;
    }

    /**
     * @return the ticketPrice
     */
    public float getTicketPrice() {
        return ticketPrice;
    }

    /**
     * @param ticketPrice the ticketPrice to set
     */
    public void setTicketPrice(float ticketPrice) {
        this.ticketPrice = ticketPrice;
    }
}
