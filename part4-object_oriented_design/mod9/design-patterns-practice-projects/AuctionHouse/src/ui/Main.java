package ui;

import model.Auctioneer;
import model.Bidder;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static Scanner userInput = new Scanner(System.in);
    private static Auctioneer auctioneer;
    private static Bidder b1, b2, b3, b4, b5, b6;
    private static ArrayList<Bidder> bidders;

    public static void main(String[] args) {
        boolean itemSold = false;
        String userResponse = "";
        populateAuctionHouse();

        System.out.print("Bidding starts at $1.00, enter your initial bid: ");
        auctioneer.acceptBid(userInput.nextDouble());
        displayHighestBid();

        while (!itemSold) {
            System.out.println("\nWould you like to bid again? (y/n): ");
            userResponse = userInput.next();

            if (userResponse.equalsIgnoreCase("y")) {
                System.out.print("Enter your new bid: ");
                auctioneer.acceptBid(userInput.nextDouble());
                displayHighestBid();
            } else {
                System.out.println("Item has been sold at: $" + gethighestBid());
                itemSold = true;
            }
        }
    }

    private static void populateAuctionHouse() {
        auctioneer = new Auctioneer("John Smith");
        b1 = new Bidder("Anthony Estey", 100.00);
        b2 = new Bidder("Ian Cavers", 55.00);
        b3 = new Bidder("Elisa Baniassad", 65.00);
        b4 = new Bidder("James Yoo", 5.00);
        b5 = new Bidder("Amy Zhu", 5.50);
        b6 = new Bidder("James Xiao", 8.49);
        auctioneer.addObserver(b1);
        auctioneer.addObserver(b2);
        auctioneer.addObserver(b3);
        auctioneer.addObserver(b4);
        auctioneer.addObserver(b5);
        auctioneer.addObserver(b6);
        addBiddersToList();
    }

    private static void addBiddersToList() {
        bidders = new ArrayList<>();
        bidders.add(b1);
        bidders.add(b2);
        bidders.add(b3);
        bidders.add(b4);
        bidders.add(b5);
        bidders.add(b6);
    }

    private static void displayHighestBid() {
        System.out.println("The current highest bid is at: " + gethighestBid());
    }

    private static double gethighestBid() {
        double max = 0.0;
        for (Bidder b : bidders) {
            if (max < b.getPersonalBid()) {
                max = b.getPersonalBid();
            }
        }
        if (max == 0) {
            return auctioneer.getCurrentBid();
        } else {
            return max;
        }
    }


}