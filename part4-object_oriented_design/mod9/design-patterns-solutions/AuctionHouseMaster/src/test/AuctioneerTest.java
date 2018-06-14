package test;

import model.Auctioneer;
import model.Bidder;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AuctioneerTest {

    private static double DELTA = 0.05;

    private Auctioneer auctioneer;
    private Bidder b1, b2, b3;


    @Before
    public void setUp() {
       auctioneer = new Auctioneer("Paul");
       b1 = new Bidder("Anthony Estey", 40.00, auctioneer);
       b2 = new Bidder("Alan Turing", 30.00, auctioneer);
       b3 = new Bidder("John Smith", 50.00, auctioneer);
    }

    @Test
    public void testgetCurrentBid() {
        checkCurrentBid(0);
        auctioneer.acceptBid(0.00);
        checkCurrentBid(0);
        auctioneer.acceptBid(100.00);
        checkCurrentBid(100.00);
        auctioneer.acceptBid(100.50);
        checkCurrentBid(100.50);
    }

    @Test
    public void testnotifyObservers() {
        auctioneer.addObserver(b1);
        auctioneer.addObserver(b2);
        auctioneer.acceptBid(100.00);
        checkCurrentBid(100.00, b1);
        checkCurrentBid(100.00, b2);
        checkCurrentBid(100.00, b3);
    }





    private void checkCurrentBid(double bid) {
        assertEquals(auctioneer.getCurrentBid(), bid, DELTA);
    }
    private void checkCurrentBid(double bid, Bidder b) { assertEquals(b.getCurrentBid(), bid, DELTA); }


}