package com.busbooking;

import java.util.Arrays;

public class Bus {
    private int busId;
    private String busType;
    private String seatType;
    private int totalSeats;
    private boolean[] seats;
    public Bus(int busId, String busType, String seatType, int totalSeats) {
        super();
        this.busId = busId;
        this.busType = busType;
        this.seatType = seatType;
        this.totalSeats = totalSeats;
        this.seats = new boolean[totalSeats];
    }
    public int getAvailableSeats() {
        int count = 0;
        for (boolean seat : seats) {
            if (seat == false) { count++; }
        }
        return count;
    }
    public void showAvailableSeats() {
        System.out.println("Available seats for Bus " + busId + ":");
        for (int i = 0; i < totalSeats; i++) {
            if (!seats[i]) {
                System.out.print((i + 1) + " "); // print 1-based seat number
            }
        }
        System.out.println();
    }
    
    public boolean bookSeat(int seatNumber){
        if (seatNumber < 0 || seatNumber >= totalSeats) return false;
        if (seats[seatNumber] == false) {
            seats[seatNumber] = true;
            return true;
        }
        return false;
    }
    public boolean cancelSeat(int seatNumber) {
        if (seatNumber < 0 || seatNumber >= totalSeats) return false;
        if (seats[seatNumber] == true) {
            seats[seatNumber] = false;
            return true;
        }
        return false;
    }
    public int getBusId() { return busId; }
    public String getBusType() { return busType; }
    public String getSeatType() { return seatType; }
    public int getTotalSeats(){ return totalSeats; }
    @Override
    public String toString() {
        return "Bus [busId=" + busId + ", busType=" + busType +
                ", seatType=" + seatType + ", totalSeats=" + totalSeats +
                ", seats=" + Arrays.toString(seats) + "]";
    }
}
