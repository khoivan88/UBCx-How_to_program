package model;

public class Auctioneer extends Subject {
    private String name;
    private double currentBid;

    public Auctioneer(String name, double currentBid) {
        this.name = name;
        this.currentBid = currentBid;
    }

    public Auctioneer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public double getCurrentBid() {
        return currentBid;
    }

    //REQUIRES: bid > currentBid
    //MODIFIES: this
    //EFFECTS: If the bid is smaller than the currentBid, the method should print out
    //         "That bid isn't larger than the current bid!".
    //          If the new bid is indeed larger than the currentBid, then the currentBid
    //          should be reset to the new bid, and all observers should be notified.
    public void acceptBid(double bid) {
        if (bid <= currentBid) {
            System.out.println("That bid isn't larger than the current bid of: $" + currentBid);
        } else {
            currentBid = bid;
            System.out.println("The highest bid is currently: $" + bid);
            notifyObserver(currentBid);
//            removeBidderNotAffordable();
        }
    }

    private void removeBidderNotAffordable() {
        for (Observer observer: getObservers()) {
            Bidder bidder = (Bidder) observer;
            if (bidder.getMaxBid() < currentBid) {
                removeObserver(observer);
            }
        }

    }

    public void notifyObserver(double newBidAmt) {
        System.out.println("Notifying bidders of the new highest bid...");
        super.notifyObserver(this, newBidAmt);

    }
}
