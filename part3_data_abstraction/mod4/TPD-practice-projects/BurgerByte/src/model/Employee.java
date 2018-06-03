package model;

public abstract class Employee {

    public static final double BASE_WAGE = 10.00;

    protected String name;
    protected int age;
    protected double hoursWorked;
    protected boolean atWork;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
        hoursWorked = 0;
        atWork = false;
    }

    // getters
    public String getName() { return name; }

    public int getAge() { return age; }

    public boolean isAtWork() { return atWork; }

    public double getHoursWorked() { return hoursWorked; }

    // MODIFIES: this
    // EFFECTS: adds hours to the hoursWorked field
    public void logHoursWorked(double hours) {
        hoursWorked += hours;
    }

//     REQUIRES: hours >= 0
//     MODIFIES: this
//     EFFECTS: opens this Manager's BurgerByte, sets atWork to true, and logs
//              hours worked
    public abstract void startWork(double hours);

    // MODIFIES: this
    // EFFECTS: closes this Manager's BurgerByte, set atWork to false
    public abstract void leaveWork();

    // EFFECTS: returns the total amount of wages this Manager made
    public abstract double computeWage();
}
