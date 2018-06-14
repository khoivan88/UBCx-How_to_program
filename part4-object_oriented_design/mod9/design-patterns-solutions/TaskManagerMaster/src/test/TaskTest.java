package test;

import model.Task;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TaskTest {

    private Task t;

    @Before
    public void setUp() {
        t = new Task("Get a coffee", "08/16/2017", "JJ Bean");
    }

    @Test
    public void testGetters() {
        assertEquals(t.getDate(), "08/16/2017");
        assertEquals(t.getLocation(), "JJ Bean");
        assertEquals(t.getDescription(), "Get a coffee on 08/16/2017 @JJ Bean");
    }

    @Test
    public void testSetters() {
        assertEquals(t.getDate(), "08/16/2017");
        t.setDate("09/16/2017");
        assertEquals(t.getDate(), "09/16/2017");
        assertEquals(t.getLocation(), "JJ Bean");
        t.setLocation("Starbucks");
        assertEquals(t.getLocation(), "Starbucks");
    }

    @Test
    public void testcomplete() {
        assertFalse(t.getStatus());
        t.complete();
        assertTrue(t.getStatus());
    }


}