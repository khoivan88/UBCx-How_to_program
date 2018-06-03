package model;


import java.util.ArrayList;
import java.util.List;

public class Zookeeper {

    private String name;
    private int age;
    private List<Animal> animalList;
    private Animal favourite;

    // TODO: follow the instructions on the webpage to implement this class


    public Zookeeper(String name, int age) {
        this.name = name;
        this.age = age;
        animalList = new ArrayList<Animal>();
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public List<Animal> getAnimalList() {
        return animalList;
    }

    public Animal getFavourite() {
        return favourite;
    }

    public void setFavourite(Animal newFavorite) {
        favourite = newFavorite;
    }

    public void addToList(Animal a) {
        animalList.add(a);
    }

    public boolean removeFromList(Animal a) {
        if (animalList.contains(a)) {
            animalList.remove(a);
            return true;
        }
        return false;
    }
}