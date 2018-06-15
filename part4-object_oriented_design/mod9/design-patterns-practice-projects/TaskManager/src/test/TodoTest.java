package test;

import model.Task;
import model.Todo;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TodoTest {

    private Todo td, td1, td2, td3;
    private Task t1, t2, t3, t4, t5;

    @Before
    public void setUp() {
        td = new Todo("Throw a party");
         t1 = new Task("Buy flour", "09/12/2017", "Whole Food");
         t2 = new Task("Get a new cake tin", "09/13/2017", "William Sonoma");
         t3 = new Task("Buy a dozen eggs", "09/12/2017", "Farmer's Market");
         t4 = new Task("Mix flour", "09/14/2017", "Anna's house");
         t5 = new Task("Grill fillet", "09/14/2017", "Anna's grill");

         td1 = new Todo("Send out invitations");
         td2 = new Todo("Get cake ingredients");
         td3 = new Todo("Bake cake and food");

        td2.addDoable(t1);
        td2.addDoable(t2);
        td2.addDoable(t3);

        td3.addDoable(t4);
        td3.addDoable(t5);

        td.addDoable(td1);
        td.addDoable(td2);
        td.addDoable(td3);

    }

    @Test
    public void testIsComplete() {
        assertFalse(td.getStatus());
        td.complete();
        assertFalse(td.getStatus());
        td1.complete();
        assertTrue(td1.getStatus());
        td2.complete();
        assertFalse(t1.getStatus());
        assertFalse(td2.getStatus());
        t1.complete();
        t2.complete();
        assertFalse(td2.getStatus());
        t3.complete();
        assertTrue(td2.getStatus());
        t4.complete();
        t5.complete();
        assertTrue(td.getStatus());
    }
}