package exceptions;

public class WaterException extends Exception {
    private double cupOfWater;

    public WaterException (double water) {
        super(water + " cups is not enough water to make coffee!");
        cupOfWater = water;
    }
}
