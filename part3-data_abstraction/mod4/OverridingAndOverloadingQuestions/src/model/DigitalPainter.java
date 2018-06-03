package model;

import model.artPieces.Art;
import model.artPieces.Software;
import model.artPieces.Tablet;

import java.util.List;

public class DigitalPainter extends Artist {
    public Tablet tablet;
    public List<Software> programsAvail;

    public Art createArt() {
        System.out.println("Made new painting");
        System.out.println("I am a digital painter!");
        return new Art();
    }

    public Art createArt(String title) {
        System.out.println("Made new painting with title " + title + "!");
        System.out.println("I am a digital painter!");
        return new Art();
    }

    @Override
    public void sellArt() {
//        portfolio.clear();
        System.out.println("Sold piece using PayPal");
    }

    public Art draw() {return new Art();}

    public void mixColour() {}


}
