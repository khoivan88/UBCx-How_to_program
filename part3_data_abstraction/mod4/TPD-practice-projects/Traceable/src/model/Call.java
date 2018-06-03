package model;

public class Call implements Traceable {

    private CellPhone cellphone;

    @Override
    public String getLocation() {
        return null;
    }

    @Override
    public Object getTrace() {
        return cellphone;
    }

    @Override
    public void track() {

    }
}
