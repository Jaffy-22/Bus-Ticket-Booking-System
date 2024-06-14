package com.ladera.travelPoints;

import com.ladera.ticketbooking.TicketBooking;
import java.util.Scanner;

public class ChennaiToCoimbatore extends TravelPoints {

    public static boolean[] agsFreq = new boolean[50]; 
    public static boolean[] bsrFreq = new boolean[50];
    private static boolean agsInitialized = false;
    private static boolean bsrInitialized = false;

    public ChennaiToCoimbatore() {
    }

    @Override
public void sourceDestination() {
    Scanner scan = new Scanner(System.in);
    System.out.println("Traveling From Chennai To Coimbatore.");
    System.out.print("Enter Your Desired Travelling Date: ");
    date = scan.nextLine();

    System.out.println("Choose Your Travels:\n  1.AGS Travels\n  2.BSR Travels");
    int userChoice = scan.nextInt();

    TicketBooking seat = new TicketBooking(50); // Assuming 50 seats

    if (userChoice == 1) {
        if (!agsInitialized) {
            agsFreq = new boolean[50];
            seat.randomizeSeats(agsFreq);
            agsInitialized = true;
        }
        handleBooking(scan, seat, "AGS Travels", agsFreq, "10:20 am", "7:00 pm");
    } else if (userChoice == 2) {
        if (!bsrInitialized) {
            bsrFreq = new boolean[50];
            seat.randomizeSeats(bsrFreq);
            bsrInitialized = true;
        }
        handleBooking(scan, seat, "BSR Travels", bsrFreq, "9:00 pm", "7:00 am");
    } else {
        System.out.println("Invalid choice. Please restart the program.");
    }
}


    private void handleBooking(Scanner scan, TicketBooking seat, String travelName, boolean[] freqArray, String departureTime, String arrivalTime) {
        System.out.println("Departure Time : " + departureTime);
        System.out.println("Arrival Time : " + arrivalTime);
        System.out.println("Total No Of Seats: " + seat.totalSeats);
        System.out.println("Total Available Seats: " + seat.availableSeats);
        seat.displayAvailableSeats(freqArray);
        System.out.print("Enter The Number Of Seats To Be Booked: ");
        int numberOfSeats = scan.nextInt();
        scan.nextLine(); // Consume newline

        for (int i = 1; i <= numberOfSeats; i++) {
            System.out.println("Enter The Passenger " + i + " Details:");
            System.out.print("Name: ");
            passengerName = scan.nextLine();
            System.out.print("Age: ");
            passengerAge = scan.nextInt();
            scan.nextLine(); // Consume newline
            System.out.print("Aadhar: ");
            passengerAadhar = scan.nextLine();

            int seatNumber;
            do {
                System.out.print("Enter Seat Number: ");
                seatNumber = scan.nextInt();
                scan.nextLine(); // Consume newline

                if (seatNumber < 1 || seatNumber > seat.totalSeats) {
                    System.out.println("Invalid seat number. Please enter a number between 1 and " + seat.totalSeats + ".");
                } else if (freqArray[seatNumber - 1]) {
                    System.out.println("Seat " + seatNumber + " is already booked. Please choose another seat.");
                } else {
                    freqArray[seatNumber - 1] = true;
                    seat.bookedSeats++;
                    seat.availableSeats--;
                    System.out.println("Booking Confirmed for Passenger: " + passengerName);
                    break;
                }
            } while (true);
        }
        System.out.println("Thank You For Choosing " + travelName);
    }
}
