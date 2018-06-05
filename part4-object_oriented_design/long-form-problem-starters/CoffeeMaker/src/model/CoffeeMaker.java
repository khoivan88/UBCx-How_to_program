package model;

import exceptions.*;

/**
 * A coffee maker used to train baristas.
 *
 * Class invariant: cups remaining >= 0, time since last brew >= 0
 */

public class CoffeeMaker {
    private double beans;
    private int cupsRemaining;
    private int timeSinceLastBrew;
//    private double cupsWaterRequired;


    public CoffeeMaker(){
        beans = 0;
        cupsRemaining = 0;
        timeSinceLastBrew = 0;
    }

    // getters
    public int getTimeSinceLastBrew() {
        return timeSinceLastBrew;
    }
    public int getCupsRemaining() {
        return cupsRemaining;
    }

    // EFFECTS: return true if there are coffee cups remaining
    public boolean areCupsRemaining() {
        return cupsRemaining >0;
    }

    //REQUIRES: a non-negative integer
    //EFFECTS: sets time since last brew
    public void setTimeSinceLastBrew(int time) {
        timeSinceLastBrew = time;
    }

//    public double getCupsWaterRequired() {
//        return cupsWaterRequired;
//    }
//
//    public void setCupsWaterRequired(double cupsWaterRequired) {
//        this.cupsWaterRequired = cupsWaterRequired;
//    }

    //EFFECTS: sets cups remaining to full (20 cups) and time since last brew to 0
    //          throws NotEnoughBeansException or TooManyBeansException when beans NOT between 2.40 and 2.60 cups
    //          throws WaterException when water < 14.75 cups
    public void brew(double beans, double water) throws WaterException, NotEnoughBeansException, TooManyBeansException {
        double beansLowerLimit = 2.4;
        double beansUpperLimit = 2.6;
        double waterRequired = 14.75;
        if (beans < beansLowerLimit) {
            throw new NotEnoughBeansException(beans);
        } else if (beans > beansUpperLimit) {
            throw new TooManyBeansException(beans);
        } else if (water <= waterRequired) {
            throw new WaterException(water);
        } else {
            cupsRemaining = 20;
            timeSinceLastBrew = 0;
        }
    }

    //MODIFIES: this
    //EFFECTS: subtracts one cup from cups remaining
    //         throw NoCupsRemainingException when cups remaining <= 0
    //         throw StaleCoffeeException when   time since last brew >= 60
    public void pourCoffee() throws NoCupsRemainingException, StaleCoffeeException {
        int timeLimit = 60;
        int cupsLimit = 0;
        if (timeSinceLastBrew >= timeLimit) {
            throw new StaleCoffeeException(timeSinceLastBrew);
        } else if (cupsRemaining <= cupsLimit) {
            throw new NoCupsRemainingException();
        } else {
            cupsRemaining -= 1;
        }
    }


}
