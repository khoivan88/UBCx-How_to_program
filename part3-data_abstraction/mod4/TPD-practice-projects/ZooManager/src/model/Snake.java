package model;

public class Snake extends Animal {

//    private String name;
//    private int age;
//    private Zookeeper caretaker;
//    private double weight;
    private double length;
    private boolean venom;

    public Snake(String nm, int age, Zookeeper zk, double wgt, double len, boolean vn) {
        super(nm, age, wgt, zk, "");
        length = len;
        venom = vn;
    }

    // getters
//    public String getName() { return name; }
//    public int getAge() { return age; }
//    public Zookeeper getCaretaker() { return caretaker; }
//    public double getWeight() { return weight; }
    public double getLength() { return length; }
    public boolean isVenom() { return venom; }


}