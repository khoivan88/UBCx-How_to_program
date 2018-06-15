package model.media;

public class Song extends AbstractMedia {

    private double length;

    public Song(String name, String creator, String genre, double length) {
        super(name, creator, genre);
        this.length = length;
    }

    // getters
    public double getLength() { return length; }


}