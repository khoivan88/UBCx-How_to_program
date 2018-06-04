package test;

import exceptions.*;
import model.CoffeeMaker;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static junit.framework.TestCase.fail;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;


public class CoffeeMakerTest {

    CoffeeMaker coffeeMaker;

    @Before
    public void setUp(){
        // TODO: instantiate your test objects here
        coffeeMaker = new CoffeeMaker();
    }

//    @Test
//    public void testTemplate(){
//        // TODO: write some more tests
//        // This is a template for unit tests
//    }

    @Test
    public void testGetTimeSinceLastBrew(){
        assertEquals(0, coffeeMaker.getTimeSinceLastBrew());
    }

    @Test
    public void testGetCupsRemaining() throws NoCupsRemainingException, StaleCoffeeException, NotEnoughBeansException, TooManyBeansException, WaterException {
        assertEquals(0, coffeeMaker.getCupsRemaining());
        coffeeMaker.brew(2.5,25);
        assertEquals(20, coffeeMaker.getCupsRemaining());
        coffeeMaker.pourCoffee();
        assertEquals(19, coffeeMaker.getCupsRemaining());
    }

    @Test
    public void testAreCupsRemaining() throws NotEnoughBeansException, TooManyBeansException, WaterException {
        assertFalse(coffeeMaker.areCupsRemaining());
        coffeeMaker.brew(2.5,25);
        assertTrue(coffeeMaker.areCupsRemaining());
    }

    @Test
    public void brewNotEnoughBeansNNotEnoughWater() {
        try {
            coffeeMaker.brew(1,10);
            fail("You are not supposed to see this.");
        } catch (NotEnoughBeansException e) {
        } catch (TooManyBeansException e) {
            fail("You are not supposed to see this.");
        } catch (WaterException e) {
            fail("You are not supposed to see this.");
        }
    }

    @Test
    public void brewTooManyBeansNNotEnoughWater() {
        try {
            coffeeMaker.brew(2.8,10);
            fail("You are not supposed to see this.");
        } catch (NotEnoughBeansException e) {
            fail("You are not supposed to see this.");
        } catch (TooManyBeansException e) {
        } catch (WaterException e) {
            fail("You are not supposed to see this.");
        }
    }

    @Test (expected = WaterException.class)
    public void brewEnoughBeansNotEnoughWater() throws Exception {
        coffeeMaker.brew(2.5,10);
    }

    @Test (expected = StaleCoffeeException.class)
    public void pourStaleCoffeeandNotEnoughCups() throws Exception {
        coffeeMaker.brew(2.5,20);
        for (int i = 0; i<20; i++) {
            coffeeMaker.pourCoffee();
        }
        coffeeMaker.setTimeSinceLastBrew(70);
        coffeeMaker.pourCoffee();
    }

    @Test (expected = StaleCoffeeException.class)
    public void pourStaleCoffeeandEnoughCups() throws Exception {
        coffeeMaker.setTimeSinceLastBrew(70);
        coffeeMaker.pourCoffee();
    }

    @Test (expected = NoCupsRemainingException.class)
    public void pourNotEnoughCups() throws Exception {
        coffeeMaker.setTimeSinceLastBrew(20);
        for (int i = 0; i<20; i++) {
            coffeeMaker.pourCoffee();
        }
        assertEquals(0, coffeeMaker.getTimeSinceLastBrew());
        assertEquals(0, coffeeMaker.getCupsRemaining());
        assertFalse(coffeeMaker.areCupsRemaining());
        coffeeMaker.pourCoffee();
    }

}
