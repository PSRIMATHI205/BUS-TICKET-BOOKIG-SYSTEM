package com.busbooking;

import java.util.ArrayList;
import java.util.List;
public class Ticket {
    private int ticketId;
    private int customerId;
    private Bus bus;
    private int numberOfTickets;
    private double fare;
    private List<Integer> bookedSeats; // stores 0-based seat indices
    public Ticket(int ticketId, Bus bus, int numberOfTickets,
                  double fare, int customerId) {
        super();
        this.ticketId = ticketId;
        this.bus = bus;
        this.numberOfTickets = numberOfTickets;
        this.fare = fare;
        this.customerId = customerId;
        this.bookedSeats = new ArrayList<>();
    }
    // Called after each successful bookSeat()
    public void addBookedSeat(int seatNumber) {
        bookedSeats.add(seatNumber);
    }
    public int getTicketId() { return ticketId; }
    public List<Integer> getBookedSeats() { return bookedSeats; }
    public Bus getBus() { return bus; }
    public int getNumberOfTickets() { return numberOfTickets; }
    public double getFare() { return fare; }
    public int getCustomerId() { return customerId; }
    @Override
    public String toString() {
        return "Ticket [ticketId=" + ticketId + ", customerId=" + customerId +
                ", bus=" + bus + ", numberOfTickets=" + numberOfTickets +
                ", fare=" + fare + ", bookedSeats=" + bookedSeats + "]";
    }
}

