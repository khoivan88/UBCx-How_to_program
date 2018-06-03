package model;

import java.util.ArrayList;

public class CellPhone implements Traceable {

    private ArrayList<Call> callHistory;
    private Person owner;
    private String location;

    @Override
    public String getLocation() {
        return location;
    }

    @Override
    public Object getTrace() {
        return this;
    }

    @Override
    public void track() {

    }
}
