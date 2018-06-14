package model.media;

public class Movie extends AbstractMedia {


    private double length;

    public Movie(String name, String creator, String genre, double length) {
        super(name, creator, genre);
        this.length = length;
    }

    // getters
    public double getLength() { return length; }


}