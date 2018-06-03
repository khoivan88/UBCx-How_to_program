package model;

public class Fingerprint implements Traceable {

    private Person person;
    private String policePrecint;

    public Fingerprint(Person person) {
        this.person = person;
    }

    @Override
    public String getLocation() {
        return null;
    }

    @Override
    public Object getTrace() {
        return person;
    }

    @Override
    public void track() {

    }
}
