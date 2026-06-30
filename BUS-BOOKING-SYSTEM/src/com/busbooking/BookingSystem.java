package com.busbooking;

import java.util.ArrayList;
import java.util.List;
import
public class BusbookingSystem {
    private List<Customer> customers;
    private List<Bus> buses;
    private List<Ticket> tickets;
    private int customerIdCounter;
    private int busIdCounter;
    private int ticketIdCounter;
    private Customer currentCustomer;

    public BusbookingSystem(){
        customers= new ArrayList<>();
        buses = new ArrayList<>();
        tickets = new ArrayList<>();
        customerIdCounter = 1;
        busIdCounter = 1 ;
        ticketIdCounter = 1;
        currentCustomer = null;
        initializeBuses();
    }

    public void initializeBuses(){
        buses.add(new Bus(busIdCounter++,"AC","Seater",30));
        buses.add(new Bus(busIdCounter++,"Non-AC","Seater",40));
        buses.add(new Bus(busIdCounter++,"AC","Sleeper",20));
        buses.add(new Bus(busIdCounter++,"Non-AC","Sleeper",25));
    }
    public void signUp(Scanner scanner){
        System.out.println("Enter your name");
        String name = scanner.nextLine();

        System.out.println("Enter your password");
        String password = scanner.nextLine();

        System.out.println("Enter your age");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter your gender");
        String gender = scanner.nextLine();

        Customer customer = new Customer(customerIdCounter++,name,password,age,gender);
        customers.add(customer);
        System.out.println("sign up successful! Your customer ID is : " + customer.getCustomerId());

    }

    public boolean login(Scanner scanner){
        System.out.println("enter your customer ID:");
        int id =scanner.nextInt();
        scanner.nextLine();

        System.out.println("enter your password");
        String password = scanner.nextLine();

        for(Customer customer:customers) {
            if (customer.getCustomerId() == id && customer.getPassword().equals(password)) {
                currentCustomer = customer;
                System.out.println("Login successful! Welcome." + customer.getName());
                return true;
            }
        }
        System.out.println("invalid credentials!");
        return false;
    }

    public void showAvailableBuses(){
        System.out.println("\nAvailable Buses:");
        for (Bus bus : buses){
            System.out.println(bus);
        }
    }

    public void bookTicket (Scanner scanner){
        if (currentCustomer==null){
            System.out.println("PLease login first!");
            return;
        }

        showAvailableBuses();

        System.out.println("\nEnter bus ID:");
        int busID = scanner.nextInt();
        scanner.nextLine();

        Bus selectedBus = null;
        for (Bus bus : buses){
            if (bus.getBusId() == busID){selectedBus = bus;
                break;}
        }
        if (selectedBus==null){
            System.out.println("Invalid bus ID!");
            return;
        }

        selectedBus.showAvailableSeats();
        System.out.println("Enter number of tickets to book:");
        int numberOfTickets = scanner.nextInt();
        scanner.nextLine();

        if(numberOfTickets > selectedBus.getAvailableSeats()){
            System.out.println("NOt enough seats available!");
            return;
        }

        List<Integer> seatsToBook = new ArrayList<>();
        for (int i =0;i<numberOfTickets;i++){
            System.out.println("Enter seat number for tickets " + (i+1) + ":");
            int seatNumber = scanner.nextInt();
            scanner.nextLine();
        }

        if (seatNumber < 0 || seatNumber >= selectedBus.getTotalSeats()){
            System.out.println("Invalid seat numbers!");
            return;
        }
        if (!selectedBus.bookSeat(seatNumber)){
            System.out.println("Seat"+(seatNumber+1)+"is already booked!");
            return;
        }
        seatsToBook.add(seatNumber);

        double baseFare = selectedBus.getBusType().equals("AC") ? 1000 :500 ;
        baseFare += selectedBus.getSeatType().equals("Sleeper") ? 500 : 0;
        double totalFare = baseFare*numberOfTickets;

        Ticket ticket=new Ticket()(ticketIdCounter++,selectedBus,
                numberOfTickets,totalFare,currentCustomer.getCustomerId());
        for (int seat: seatsToBook) {ticket.addBookedSeat(seat):}
        ticket.add(ticket);

        System.out.println("\nBooking successful!");
        System.out.println("Ticket IDD : "+ticket.getTicketId());
        System.out.println("Total Fare : "+ totalFare);
        System.out.println("Booked Seats : " + seatsToBook);

    }

    public void viewTicket(){
        if (currentCustomer == null){
            System.out.println("PLease login first!");
            return;
        }
        System.out.println("\nYour Tickets : ");
        boolean found = false;
        for (Ticket ticket : tickets){
            if (ticket.getCustomerId() == currentCustomer.getCustomerId()){
                System.out.println(ticket);
                found=true;
            }
        }
        if (!found) System.out.println("No tickets found!");
    }

    public void cancelTicket(Scanner scanner){
        if (currentCustomer==null){
            System.out.println("PLease login!");
            return;
        }

        viewTicket();
        System.out.println("\nEnter ticket ID to cancel:");
        int ticketId = scanner.nextInt();
        scanner.nextLine();

        Ticket ticketToCancel = null;
        for (Ticket ticket : tickets){
            if (ticket.getTicketId()==ticketId
                    && ticket.getCustomerId() == currentCustomer.getCustomerId()){
                ticketToCancel=ticket;
                break;
            }
        }
        if (ticketToCancel==null){
            System.out.println("invalid ticket Id!");
            return;
        }
        Bus bus = ticketToCancel.getBus();
        for (int seat : ticketToCancel.getBookedSeats()){
            bus.cancelSeat(seat);
        }

        tickets.remove(ticketToCancel);
        System.out.println("Ticket cancelled successfully!");
        System.out.println("Refund amount: "+ticketToCancel.getFare());
    }

    public void showBusSummary(){
        System.out.println("\nBus Summary: ");
        for (Bus bus : buses){
            System.out.println("Bus ID: "+bus.getBudId());
            System.out.println("Type: "+bus.getBusType());
            System.out.println("Seat type: "+ bus.getSeatType());
            System.out.println("Total Seats: "+bus.getTotalSeats());
            System.out.println("Booked Seats: "+ (bus.getTotalSeats() - bus.getAvailableSeats()));
            System.out.println("Available Seats: " + bus.getAvailableSeats());
            System.out.println();
        }
    }
}