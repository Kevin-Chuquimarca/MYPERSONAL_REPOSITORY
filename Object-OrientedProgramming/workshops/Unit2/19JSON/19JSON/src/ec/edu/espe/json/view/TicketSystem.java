/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.json.view;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ec.edu.espe.json.model.Ticket;
import java.util.ArrayList;

/**
 *
 * @author Kevin Chuquimarca ESPE-DCCO
 */
public class TicketSystem {

    public static void main(String[] args) {
        String ticketJsonString;
        ArrayList<Ticket> tickets = new ArrayList<>();
        tickets.add(new Ticket(2365875, 01, "Enigma code", 1, 6.35F));
        tickets.add(new Ticket(2365876, 02, "Enigma code", 2, 6.25F));
        tickets.add(new Ticket(2365877, 03, "Enigma code", 3, 5.35F));
        tickets.add(new Ticket(2365878, 04, "Enigma code", 4, 4.35F));
        tickets.add(new Ticket(2365879, 05, "Enigma code", 5, 5.45F));
        
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        ticketJsonString = gson.toJson(tickets);
        System.out.println(ticketJsonString);
        
        System.out.println(tickets.get(2));
        Ticket ticket = tickets.get(2);
        System.out.println("key: " + ticket.getKey());
        System.out.println("priceTicket: " + ticket.getTicketPrice());
    }
}
