package model;

public abstract class Animal {
    protected String name;
    protected String country;
    protected int age;
    protected Zookeeper careTaker;
    protected double weight;

    public Animal(String nm, int age, double wgt, Zookeeper zk, String ct) {
        name = nm;
        this.age = age;
        weight = wgt;
        careTaker = zk;
        country = ct;
    }

    // getters
    public String getName() { return name; }

    public String getCountry() { return country; }

    public int getAge() { return age; }

    public Zookeeper getCareTaker() { return careTaker; }

    public double getWeight() { return weight; }

    // for easy testing, override with specific methods
    public double getTopSpeed() {return 0;};
}
