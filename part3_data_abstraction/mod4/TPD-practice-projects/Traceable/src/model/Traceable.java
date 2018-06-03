package model;

public interface Traceable {

    String getLocation();

    Object getTrace();

    void track();
}
