package test;

import model.Animal;
import model.Zookeeper;
import org.junit.Test;

import static org.junit.Assert.*;

public abstract class AnimalTest {
    Animal a;

    String nm = "Animal Name";
    String ct = "US";
    int age = 5;
    Zookeeper zk = new Zookeeper("Zookeeper Name", 35);
    double wgt = 100;

    @Test
    public void getName() {
        assertEquals("Animal Name", a.getName());
    }

    @Test
    public void getCountry() {
        assertEquals("US", a.getCountry());
    }

    @Test
    public void getAge() {
        assertEquals(5, a.getAge());
    }

    @Test
    public void getCareTaker() {
        assertEquals(zk, a.getCareTaker());
    }

    @Test
    public void getWeight() {
        assertEquals(100, a.getWeight(), 0.05);
    }
}