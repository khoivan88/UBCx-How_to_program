package model.Vegetables;

import model.VegType;
import model.Vegetable;

public class Tomato extends Vegetable {

    public Tomato() {
        super("Tomato", VegType.SEED);
        setInstructions("growing instruction for tomatoes");
    }

    @Override
    public void feed() {
        System.out.println("feed tomato");
    }

    @Override
    public void water() {
        System.out.println("water tomato");
    }

    @Override
    public void harvest() {
        System.out.println("harvest tomato");
    }
}
