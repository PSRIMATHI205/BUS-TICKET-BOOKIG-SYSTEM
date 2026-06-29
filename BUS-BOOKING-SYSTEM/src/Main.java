//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        for (int i = 1; i <= 5; i++) {
package com.busticketbooking;
import java.util.Scanner;
            public class Main {
                public static void main(String[] args) {
                    BookingSystem system = new BookingSystem();
                    Scanner scanner = new Scanner(System.in);
                    while (true) {
                        System.out.println("\nBus Ticket Booking System");
                        System.out.println("1. Sign Up");
                        System.out.println("2. Login");
                        System.out.println("3. Show Available Buses");
                        System.out.println("4. Book Ticket");
                        System.out.println("5. View Tickets");
                        System.out.println("6. Cancel Ticket");
                        System.out.println("7. Show Bus Summary");
                        System.out.println("8. Exit");
                        System.out.println("Enter your choice:");
                        int choice = scanner.nextInt();
                        scanner.nextLine(); // consume newline after menu choice
                        switch (choice) {
                            case 1: system.signUp(scanner); break;
                            case 2: system.login(scanner); break;
                            case 3: system.showAvailableBuses(); break;
                            case 4: system.bookTicket(scanner); break;
                            case 5: system.viewTickets(); break;
                            case 6: system.cancelTicket(scanner); break;
                            case 7: system.showBusSummary(); break;
                            case 8:
                                System.out.println(
                                        "Thank you for using Bus Ticket Booking System!");
                                scanner.close();
                                return; // exits main(), ends the program
                            default:
                                System.out.println("Invalid choice!");
                        }
                    }
                }
            }            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            System.out.println("i = " + i);
        }
    }
}
