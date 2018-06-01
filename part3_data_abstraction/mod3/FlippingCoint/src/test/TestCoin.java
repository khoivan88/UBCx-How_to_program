package test;

import model.Coin;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class TestCoin {
    private Coin coin;

    @Before
    public void setup() {
        coin = new Coin();
    }

    // Make sure we do not get the same result everytime
    @Test
    public void testFlipCoin(){
        boolean valid = false;
        int flipTimes = 10;
        String initStatus = coin.checkStatus();
        for (int i = 0; i < flipTimes; i++) {
            coin.flip();
            if (coin.checkStatus() != initStatus) {
                valid = true;
            }
        }

        assertTrue(valid);
    }
}
