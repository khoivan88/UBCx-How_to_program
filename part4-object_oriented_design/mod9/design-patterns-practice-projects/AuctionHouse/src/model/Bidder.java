package model;

import java.util.Random;

public class Bidder implements Observer {
    private String name;
    private double personalBid;
    private double currentBid;
    private double maxBid;
    private Auctioneer auctioneer;

    public Bidder(String name, double maxBid) {
        this.name = name;
        this.maxBid = maxBid;
    }

    public Bidder(String name, double maxBid, Auctioneer auctioneer) {
        this.name = name;
        this.maxBid = maxBid;
        this.auctioneer = auctioneer;
        auctioneer.addObserver(this);
    }

    public String getName() {
        return name;
    }

    public double getPersonalBid() {
        return personalBid;
    }

    public double getCurrentBid() {
        return currentBid;
    }

    public double getMaxBid() {
        return maxBid;
    }

    @Override
    //MODIFIES: this
    //EFFECTS: print out that this Bidder has been updated with the most recent high bid.
    //          Then, given that the most recent bid is less than this Bidder's maxBid,
    //              it should call the method makeBid(double currentBid),
    //          if the current bid is equal to or greater than the maxBid,
    //              the method should print out "I can't bid any higher!".
    public void update(Subject auctioneer, Object bid) {
        this.currentBid = (double) bid;
        System.out.format("Bidder %s has been updated with the most recent high bid: $%.2f\n", this.name, this.currentBid);
        if (this.currentBid < maxBid) {
            makeBid(this.currentBid);
        } else {
            System.out.println("I can't bid any higher!");
            auctioneer.removeObserver(this);
        }
    }

    //MODIFIES: this
    //EFFECTS: take in the Bidder's currentBid field as a parameter and
    //         generate a random number in the range [currentBid + 1, currentBid + 10].
    public void makeBid(double currentBid) {
        double random = new Random().nextDouble();
        double lowerLimit = currentBid + 1;
        double upperLimit = this.maxBid;
        if (currentBid + 10 <= upperLimit) {
            upperLimit = currentBid + 10;
        }
        double newBid = lowerLimit + (random * (upperLimit - lowerLimit));
        this.personalBid = newBid;
        System.out.format("%s's bid is: $%.2f\n", name, personalBid);

    }
}
