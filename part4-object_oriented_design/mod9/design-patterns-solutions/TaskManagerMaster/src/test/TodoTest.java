package test;

import model.Task;
import model.Todo;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TodoTest {

    private Todo todo1, todo2;
    private Task t1, t2, t3, t4, t5, t6;

    @Before
    public void setUp() {
        todo1  = new Todo("Become a TA");
        todo2 = new Todo("Become a professor");
        t1 = new Task("Pass CPSC110 final", "04/04/2016", "DMP110");
        t2 = new Task("Apply to TA", "05/12/2016", "Home");
        t3 = new Task("Go to TA orientation", "08/14/2016", "ICICS/CS");
        todo1.addDoable(t1);
        todo1.addDoable(t2);
        todo1.addDoable(t3);
        t4 = new Task("Defend dissertation", "09/08/2020", "X836");
        t5 = new Task("Acquire tenure", "11/10/2025", "UBC");
        t6 = new Task("Acquire cake", "11/12/2025", "Home");
    }

    @Test
    public void testGetters() {
        assertEquals(todo1.getDescription(), "Become a TA");
        assertEquals(todo2.getDescription(), "Become a professor");
        assertTrue(todo1.getSubTasks().contains(t1));
        assertTrue(todo1.getSubTasks().contains(t3));
        assertFalse(todo1.getSubTasks().contains(todo2));
        todo1.addDoable(todo2);
        assertTrue(todo1.getSubTasks().contains(todo2));
    }

    @Test
    public void testremoveDoable() {
        assertTrue(todo1.getSubTasks().contains(t1));
        todo1.removeDoable(t1);
        assertFalse(todo2.getSubTasks().contains(t1));
    }

    @Test
    public void testcomplete() {
        assertFalse(todo1.getStatus());
        todo1.complete();
        assertFalse(todo1.getStatus());
        t1.complete();
        t2.complete();
        assertFalse(todo1.getStatus());
        t3.complete();
        todo1.complete();
        assertTrue(todo1.getStatus());
    }

    @Test
    public void testDisplay() {
        todo2.addDoable(todo1);
        todo2.addDoable(t4);
        todo2.addDoable(t5);
        todo2.addDoable(t6);
        todo2.display("  ");
    }




}