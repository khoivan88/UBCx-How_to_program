package ui;

import model.Vegetables.Carrot;
import model.Vegetables.Lettuce;
import model.Vegetables.Tomato;
import model.Vegetable;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Vegetable> garden = new ArrayList();
        garden.add(new Carrot());
        garden.add(new Tomato());
        garden.add(new Lettuce());

        for (Vegetable v: garden) {
            System.out.println(v.getName());
            System.out.println(v.getInstructions());
            v.feed();
            v.water();
            v.harvest();
            System.out.println();
        }
    }
}
