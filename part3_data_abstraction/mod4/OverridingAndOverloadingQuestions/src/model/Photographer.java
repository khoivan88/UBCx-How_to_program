package model;

import model.artPieces.Art;
import model.artPieces.Camera;
import model.artPieces.Light;
import model.artPieces.Photo;

import java.util.List;

public class Photographer extends Artist {
    public Camera camera;
    public List<Light> lights;

    public Art createArt() {
        System.out.println("Took new photo");
        return new Art();
    }

    public Art createArt(String title) {
        System.out.println("Took new photo with title" + title + "!");
        return new Art();
    }

//    @Override
//    public void sellArt(){
////        portfolio.clear();
//        System.out.println("Sold piece by cash");
//    }

    public Photo photograph() {return new Photo();}

    public void editPhotos() {}


}
