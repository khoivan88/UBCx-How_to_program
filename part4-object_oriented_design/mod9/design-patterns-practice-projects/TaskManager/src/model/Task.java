package model;

public class Task extends Doable {

//    private boolean complete;
    private String description;
    private String date;
    private String location;


    public Task(String description, String date, String location) {
//        complete = false;
        super();
        this.description = description;
        this.date = date;
        this.location = location;
    }

    // getters
    public String getDate() { return date; }
    public String getLocation() { return location; }
//    public boolean getStatus() { return complete; }

    // setters
    public void setDate(String date) { this.date = date; }
    public void setLocation(String location) { this.location = location; }

    public String getDescription() {
        return description + " on " + getDate() + " @" + getLocation();
    }

    public void complete() {
        if (!complete) {
            complete = true;
        }
    }

    public void display(String indentSpace) {
        System.out.println(indentSpace + this.getDescription());
    }


}