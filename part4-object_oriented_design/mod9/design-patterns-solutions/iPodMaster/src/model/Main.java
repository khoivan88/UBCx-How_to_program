package model;


import model.media.AbstractMedia;
import model.media.*;

public class Main {

    private static iPod nano = new iPod("John");
    private static Movie m1 = new Movie("Dunkirk (2017)", "Christopher Nolan", "Drama",  107);
    private static Song m2 = new Song("Writing's on the Wall", "Sam Smith", "Ballad", 302);
    private static Photo m3 = new Photo("Moonrise", "Ansel Adams", "Landscape", "Yosemite");

    public static void main(String[] args) {

        nano.addMovie(m1);
        nano.addSong(m2);
        nano.addPhoto(m3);

        System.out.println(nano.getName() +"'s iPod contains: ");
        for (AbstractMedia m : nano) {
            System.out.println(m.getName() + " by: " + m.getCreator());
        }
    }
}
