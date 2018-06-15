package model;


import model.media.AbstractMedia;
import model.media.*;

public class Main {

    private static iPod nano = new iPod("John");
    private static Movie m1 = new Movie("Dunkirk (2017)", "Christopher Nolan", "Drama",  107);
    private static Song s1 = new Song("Writing's on the Wall", "Sam Smith", "Ballad", 3.02);
    private static Photo p1 = new Photo("Moonrise", "Ansel Adams", "Landscape", "Yosemite");

    // TODO: addData more examples of media files you might find on an iPod below
    private static Song s2 = new Song("My church", "Marren Morris", "Country", 3.40);
    private static Song s3 = new Song("Woman, Amen", "Dirk Bentley", "Country", 3.19);


    public static void main(String[] args) {

       // TODO: addData the static objects you've declared before this method to the iPod (nano)
        nano.addData(m1);
        nano.addData(s1);
        nano.addData(p1);
        nano.addData(s2);
        nano.addData(s3);

        System.out.println(nano.getName() +"'s iPod contains: ");
        // TODO: Use the Iterator Design Pattern to make the following for-each loop run
        for (AbstractMedia m : nano) {
            System.out.println(m.getName() + " by: " + m.getCreator());
        }
    }


}