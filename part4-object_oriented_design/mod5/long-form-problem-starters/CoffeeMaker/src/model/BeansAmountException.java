package model;

public class BeansAmountException extends Exception {
    private double beans;

    public BeansAmountException(double beans) {
        super(String.format("%f is not the right amount of beans", beans));
        this.beans = beans;
    }

    public double getBeans() { return beans; }
}
