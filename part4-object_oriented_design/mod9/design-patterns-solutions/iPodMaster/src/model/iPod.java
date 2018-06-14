package model;

import model.media.AbstractMedia;
import model.media.Movie;
import model.media.Photo;
import model.media.Song;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class iPod implements Iterable<AbstractMedia> {

    private String name;
    private Set<AbstractMedia> movies = new HashSet<>();
    private Set<AbstractMedia> photos = new HashSet<>();
    private Collection<AbstractMedia> songs = new HashSet<>();

    public iPod(String name) {
        this.name = name;
    }

    // getters
    public String getName() { return name; }

    /**
     *
     * @param m the movie we wish to add into the set
     */
    public void addMovie(Movie m) {
        movies.add(m);
    }

    /**
     *
     * @param p the photo we want to add into the set
     */
    public void addPhoto(Photo p) {
        photos.add(p);
    }

    /**
     *
     * @param s the song we want to add into the set
     */
    public void addSong(Song s) {
        songs.add(s);
    }


    @Override
    public Iterator<AbstractMedia> iterator() {
        return new AbstractMediaIterator();
    }

    private class AbstractMediaIterator implements Iterator<AbstractMedia> {
        Iterator movieIterator = movies.iterator();
        Iterator photoIterator = photos.iterator();
        Iterator songIterator = songs.iterator();

        @Override
        public boolean hasNext() {
            return (movieIterator.hasNext() || photoIterator.hasNext() || songIterator.hasNext());
        }

        @Override
        public AbstractMedia next() {
            AbstractMedia m = null;
            if (movieIterator.hasNext()) {
                m = (Movie) movieIterator.next();
            } else if (photoIterator.hasNext()) {
                m = (Photo) photoIterator.next();
            } else if (songIterator.hasNext()) {
                m = (Song) songIterator.next();
            }

            return m;
        }


    }


}