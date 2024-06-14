package com.ladera.ticketbooking;

import java.util.Random;

public class TicketBooking {
    public int availableSeats;
    public int bookedSeats;
    public int totalSeats;
    public boolean[] seats;

    public TicketBooking() {
    }

    public TicketBooking(int totalSeats) {
        this.totalSeats = totalSeats;
        this.seats = new boolean[totalSeats];
        this.availableSeats = totalSeats;
        this.bookedSeats = 0;
    }

    public void randomizeSeats(boolean[] arr) {
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextBoolean();
            if (arr[i]) {
                bookedSeats++;
            }
        }
        availableSeats = totalSeats - bookedSeats;
    }

    public void displayAvailableSeats(boolean seats[]) {
        System.out.println("Available Seats:");
        for (int i = 0; i < seats.length; i++) {
            if (!seats[i]) {
                System.out.print((i + 1) + " ");
            }
        }
        System.out.println();
    }
}
