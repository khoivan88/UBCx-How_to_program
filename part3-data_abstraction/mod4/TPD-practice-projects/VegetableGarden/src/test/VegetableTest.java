package test;

import model.*;
import model.Vegetables.Carrot;
import model.Vegetables.Lettuce;
import model.Vegetables.Tomato;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VegetableTest {
    Vegetable v;

//    @Before
//    public void setUp() {
//        v = new
//    }

    @Test
    public void testLettuce() {
        v = new Lettuce();
        assertEquals("Lettuce", v.getName());
        v.setName("lettuce 2");
        assertEquals("lettuce 2", v.getName());
        assertEquals("instruction for growing lettuce", v.getInstructions());

        assertEquals(VegType.LEAF, v.getType());
        v.setType(VegType.SEED);
        assertEquals(VegType.SEED, v.getType());
    }

    @Test
    public void testCarrot() {
        v = new Carrot();
        assertEquals("Carrot", v.getName());
        v.setName("lettuce 2");
        assertEquals("lettuce 2", v.getName());
        assertEquals("instructions for growing carrots", v.getInstructions());

        assertEquals(VegType.ROOT, v.getType());
        v.setType(VegType.SEED);
        assertEquals(VegType.SEED, v.getType());
    }

    @Test
    public void testTomato() {
        v = new Tomato();
        assertEquals("Tomato", v.getName());
        v.setName("lettuce 2");
        assertEquals("lettuce 2", v.getName());
        assertEquals("growing instruction for tomatoes", v.getInstructions());

        assertEquals(VegType.SEED, v.getType());
        v.setType(VegType.ROOT);
        assertEquals(VegType.ROOT, v.getType());
    }

}
