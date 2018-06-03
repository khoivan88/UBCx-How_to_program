package test;

import model.Elephant;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ElephantTest extends AnimalTest {

    @Before
    public void setUp() throws Exception {
        a = new Elephant(nm, age, wgt, zk, ct);
    }

}