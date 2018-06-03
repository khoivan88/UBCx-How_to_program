package ui;

import model.Artist;
import model.DigitalPainter;
import model.Photographer;

public class Main {
    public static void main(String[] args) {
        Photographer ansel = new Photographer();
        Artist dorothea = new Photographer();
        Photographer dorothea2 = new Photographer();
        DigitalPainter ade = new DigitalPainter();
        Artist michael = new DigitalPainter();

        dorothea.createArt();
//        dorothea.createArt("Migrant Mother");

        dorothea2.createArt("Migrant Mother");

        ade.sellArt();
        ansel.sellArt();
        dorothea.sellArt();
        michael.sellArt();

    }
}
