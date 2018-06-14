package model;


import model.media.AbstractMedia;
import model.media.*;

public class Main {

    private static iPod nano = new iPod("John");
    private static Movie m1 = new Movie("Dunkirk (2017)", "Christopher Nolan", "Drama",  107);
    private static Song s1 = new Song("Writing's on the Wall", "Sam Smith", "Ballad", 3.02);
    private static Photo p1 = new Photo("Moonrise", "Ansel Adams", "Landscape", "Yosemite");

    // TODO: add more examples of media files you might find on an iPod below

    public static void main(String[] args) {

       // TODO: add the static objects you've declared before this method to the iPod (nano)

        System.out.println(nano.getName() +"'s iPod contains: ");
        // TODO: Use the Iterator Design Pattern to make the following for-each loop run
        for (AbstractMedia m : nano) {
            System.out.println(m.getName() + " by: " + m.getCreator());
        }
    }


}