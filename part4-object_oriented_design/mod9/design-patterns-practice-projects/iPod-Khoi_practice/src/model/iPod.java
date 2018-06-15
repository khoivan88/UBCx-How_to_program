package model;

import model.media.AbstractMedia;
import model.media.Movie;
import model.media.Photo;
import model.media.Song;

import java.lang.reflect.Type;
import java.util.*;

public class iPod implements Iterable<AbstractMedia> {

    private String name;
    private Set<AbstractMedia> songs;
    private Set<AbstractMedia> movies;
    private Set<AbstractMedia> photos;
    private List<Set<AbstractMedia>> data;

    // TODO: addData fields here which represent this iPod's Movies, Photos, and Songs, they should be of the Collection type

    public iPod(String name) {
        this.name = name;
        this.songs = new HashSet<>();
        this.movies = new HashSet<>();
        this.photos = new HashSet<>();
        this.data = new ArrayList<>();
        data.add(songs);
        data.add(movies);
        data.add(photos);
    }

    // getters
    public String getName() { return name; }


    public void addData(Song media) {
        songs.add(media);
    }

    public void addData(Movie media) {
        movies.add(media);
    }

    public void addData(Photo media) {
        photos.add(media);
    }

    public void removeData(Song media) {
        songs.remove(media);
    }

    public void removeData(Movie media) {
        movies.remove(media);
    }

    public void removeData(Photo media) {
        photos.remove(media);
    }

    @Override
    public Iterator<AbstractMedia> iterator() {
        return new dataIterator();
    }

    private class dataIterator implements Iterator<AbstractMedia> {
        Iterator songIterator = songs.iterator();
        Iterator movieIterator = movies.iterator();
        Iterator photoIterator = photos.iterator();

        @Override
        public boolean hasNext() {
            return (songIterator.hasNext() || movieIterator.hasNext() || photoIterator.hasNext());
        }

        @Override
        public AbstractMedia next() {
            AbstractMedia m = null;
            if (songIterator.hasNext()) {
                m = (Song) songIterator.next();
            }
            else if (movieIterator.hasNext()) {
                m = (Movie) movieIterator.next();
            }
            else if (photoIterator.hasNext()) {
                m = (Photo) photoIterator.next();
            }
            return m;
        }

    }
}