package model;

public class Horse extends Animal {

    private double topSpeed;

    public Horse(String nm, String ct, int age, Zookeeper zk, double wgt, double ts) {
        super(nm, age, wgt, zk, ct);
        topSpeed = ts;
    }

    // getters
    public double getTopSpeed() { return topSpeed; }


}