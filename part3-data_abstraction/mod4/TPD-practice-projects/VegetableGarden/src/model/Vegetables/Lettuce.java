package model.Vegetables;

import model.VegType;
import model.Vegetable;

public class Lettuce extends Vegetable {

    public Lettuce() {
        super("Lettuce", VegType.LEAF);
        setInstructions("instruction for growing lettuce");
    }

    @Override
    public void feed() {
        System.out.println("feed lettuce");
    }

    @Override
    public void water() {
        System.out.println("water lettuce");
    }

    @Override
    public void harvest() {
        System.out.println("harvest lettuce");
    }
}
