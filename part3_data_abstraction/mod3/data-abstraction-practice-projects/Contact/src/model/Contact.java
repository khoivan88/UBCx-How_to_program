package model;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Contact {
    private String name;
    private int number;
    private ContactType type;


    private ArrayList<String> callLog;

    public Contact(String name, int number, ContactType type) {
        this.name = name;
        this.number = number;
        this.type = type;
        callLog = new ArrayList<String>();
    }

    public Contact(String name, int number) {
        this.name = name;
        this.number = number;
        callLog = new ArrayList<String>();
    }

    public Contact(String name) {
        this.name = name;
        callLog = new ArrayList<String>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public ContactType getType() {
        return type;
    }

    public void setType(String type) {
        this.type = (ContactType)type;
    }

    public enum ContactType {
        WORK, FRIEND, FAMILY
    }

    public ArrayList<String> getCallLog() {
        return callLog;
    }

    private void addToLog(String date) {
        callLog.add(date);
    }

    public void call(String date) {
         addToLog(date);
    }
}


