package tests;

import model.Time;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TimeTest {
    Time t;

    @Before
    public void setUp() {
        t = new Time(20, 8);
    }

    @Test
    public void testGetTime() {
        assertEquals("20: 08", t.getTime());
    }
}
