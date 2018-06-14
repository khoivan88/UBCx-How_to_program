package model;

public abstract class Doable {

    protected boolean complete;

    public Doable() {
        complete = false;
    }

    // getters
    public boolean getStatus() { return complete; }

    // abstract methods
    public abstract String getDescription();
    public abstract void complete();
    public abstract void display(String indentSpace);


}