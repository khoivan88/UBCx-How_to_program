package model;

import model.artPieces.Art;

import java.util.List;

public abstract class Artist {
    public String name;
    public List<Art> portfolio;

    public void sellArt(){
//        portfolio.clear();
        System.out.println("Sold piece");
    }

    public void addToPortfolio(Art piece){
        portfolio.add(piece);
    }

    public abstract Art createArt();
//    public Art createArt() {
//        System.out.println("Create art");
//        return new Art();
//    }
}
