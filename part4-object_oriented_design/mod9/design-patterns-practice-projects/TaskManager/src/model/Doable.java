package model;

public abstract class Doable {
    protected boolean complete;

//    public Doable(String description) {
//        this.description = description;
//        this.complete = false;
//    }

    public Doable() {
        this.complete = false;
    }

    public boolean getStatus() {
        return complete;
    }

    abstract public String getDescription();

    abstract public void complete();

    abstract public void display(String indentSpace);

}
