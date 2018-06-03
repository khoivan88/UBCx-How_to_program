package model;

public class Whale extends Animal {

//    private String name;
//    private int age;
//    private Zookeeper caretaker;
//    private double weight;
    private boolean waterType;
    private double maxDiveDepth;

    public Whale(String nm, int age, Zookeeper zk, double wgt, boolean typ, double mdd) {
        super(nm, age, wgt, zk, "");
        waterType = typ;
        maxDiveDepth = mdd;
    }

    // getters
//    public String getName() { return name; }
//    public int getAge() { return age; }
//    public Zookeeper getCaretaker() { return caretaker; }
//    public double getWeight() { return weight; }
    public boolean isWaterType() { return waterType; }
    public double getMaxDiveDepth() { return maxDiveDepth;}


}