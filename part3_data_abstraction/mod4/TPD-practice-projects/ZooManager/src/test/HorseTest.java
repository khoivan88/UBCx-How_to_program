package test;

import model.Horse;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HorseTest extends AnimalTest {

    @Before
    public void setUp() throws Exception {
        a = new Horse(nm, ct, age, zk, wgt,20);
    }

    @Test
    public void getTopSpeed() {
        assertEquals(20, a.getTopSpeed(), 0.05);
    }
}