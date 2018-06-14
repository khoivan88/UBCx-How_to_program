package model.media;

public class Photo extends AbstractMedia {


    private String location;

    public Photo(String name, String creator, String genre, String location) {
        super(name, creator, genre);
        this.location = location;
    }

    // getters
    public String getLocation() { return location; }


}