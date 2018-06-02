package model;

import java.util.ArrayList;

public class Calendar {

    private Date date;
    private ArrayList<Entry> entries;
    private String email;

    public Calendar(Date date, String email) {
        this.date = date;
        this.email = email;
        entries = new ArrayList<Entry>();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public ArrayList<Entry> getEntries() {
        return entries;
    }

//    public void setEntries(ArrayList<Entry> entries) {
//        this.entries = entries;
//    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
