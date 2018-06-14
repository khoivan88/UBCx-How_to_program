package model.media;

public abstract class AbstractMedia {

    protected String name;
    protected String creator;
    protected String genre;

    public AbstractMedia(String name, String creator, String genre) {
        this.name = name;
        this.creator = creator;
        this.genre = genre;
    }

    // getters
    public String getName() { return name; }
    public String getCreator() { return creator; }
    public String getGenre() { return genre; }


}