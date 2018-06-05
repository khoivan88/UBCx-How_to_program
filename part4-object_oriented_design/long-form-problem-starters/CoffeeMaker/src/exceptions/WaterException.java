package exceptions;

public class WaterException extends Exception {
    private double cupsWaterRequired;

    public WaterException (double water) {
        super(water + " cups is not enough water to make coffee!");
        cupsWaterRequired = water;
    }
}
