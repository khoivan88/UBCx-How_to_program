package model;

public class Auctioneer extends Subject {

    private String name;
    private double currentBid;

    public Auctioneer(String name) {
        this.name = name;
        currentBid = 0.0;
    }

    // getters
    public String getName() { return name; }
    public double getCurrentBid() { return currentBid; }

    public void acceptBid(double bid) {
        if  (bid <= currentBid) {
            System.out.println("That bid isn't larger than the current bid of: $" + currentBid);
        } else {
            currentBid = bid;
            System.out.println("The highest bid is currently: $" + bid);
            notifyObservers(currentBid);
        }
    }

    private void notifyObservers(double newBidAmt) {
        System.out.println("Notifying bidders of the new highest bid...");
        super.notifyObservers(this, newBidAmt);
    }


}





