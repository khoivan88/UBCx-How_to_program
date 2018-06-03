package tests;

import model.Date;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DateTest {
    Date date;

    @Before
    public void setUp() {
        date = new Date(5,13,2018);
    }

    @Test
    public void testGetShortDate() {
        assertEquals("05/13/2018", date.getShortDate());
    }

    @Test
    public void testGetLongDate() {
        assertEquals("May 13, 2018", date.getLongDate());
    }
}
