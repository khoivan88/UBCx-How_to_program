package test;

import model.Auctioneer;
import model.Bidder;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BidderTest {

    private static double DELTA = 0.05;

    private Auctioneer auctioneer;
    private Bidder bidder;

    @Before
    public void setUp() {
        auctioneer = new Auctioneer("John Smith");
        bidder = new Bidder("Paul Carter", 300.00, auctioneer);
    }

    @Test
    public void testGetters() {
        assertEquals(bidder.getName(), "Paul Carter");
        assertEquals(bidder.getCurrentBid(), 0, DELTA);
        assertEquals(bidder.getMaxBid(), 300.00, DELTA);
        assertEquals(bidder.getPersonalBid(), 0.00, DELTA);
    }




}