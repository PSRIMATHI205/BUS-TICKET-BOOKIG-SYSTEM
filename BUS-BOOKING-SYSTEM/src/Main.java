

import com.busbooking.BookingSystem;

import java.util.ArrayList;
import java.util.List;
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
            scanner.nextLine();                  switch (choice) {
                case 1: system.signUp(scanner); break;
                case 2: system.login(scanner); break;
                case 3: system.showAvailableBuses(); break;
                case 4: system.bookTicket(scanner); break;
                case 5: system.viewTicket(); break;
                case 6: system.cancelTicket(scanner); break;
                case 7: system.showBusSummary(); break;
                case 8:
                    System.out.println("Thank you for using Bus Ticket Booking System!");scanner.close();
                    return;
                    default:
                        System.out.println("Invalid choice!");
                        }
                    }
                }
            }