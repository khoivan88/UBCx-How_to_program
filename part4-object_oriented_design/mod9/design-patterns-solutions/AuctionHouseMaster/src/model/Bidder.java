package model;

import java.util.Random;

public class Bidder implements Observer {

    private String name;
    private double personalBid;
    private double currentBid;
    private double maxBid;

    public Bidder(String name, double maxBid, Auctioneer auctioneer) {
        this.name = name;
        personalBid = 0.0;
        currentBid = 0.0;
        this.maxBid = maxBid;
        auctioneer.addObserver(this);
    }

    // getters
    public String getName() { return name; }
    public double getPersonalBid() { return personalBid; }
    public double getCurrentBid() { return currentBid; }
    public double getMaxBid() { return maxBid; }

    @Override
    public void update(Subject auctioneer, Object arg) {
        this.currentBid = (double) arg;
        System.out.println("Update received for: " + name + ", current bid is at: $" + currentBid);

        if (currentBid < maxBid) {
            makeBid(currentBid);
        } else {
            System.out.println(name + " can't bid any higher!");
        }
    }

    /**
     * This is a utility function which randomly generates a number from currentBid to maxBid
     * and sets it as this Bidder's personalBid
     *
     * @param currentBid the current bid
     */
    private void makeBid(double currentBid) {
        Random rand = new Random();
        personalBid = (double) rand.nextInt((int) 10) + (currentBid + 1);

        System.out.println(name + "'s bid is: $" + personalBid);
    }
}



