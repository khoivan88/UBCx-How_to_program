package model;

import java.util.ArrayList;
import java.util.List;

public class Room extends Choice {

    private List<Choice> choices;
    private int id;

    public Room(int id) {
        super("Enter Room " + id + ".");
        this.id = id;
        choices = new ArrayList<>();
        choices.add(0, null); //to simplify choices during gameplay

    }

    //EFFECTS: prints all possible next choices
    public void printOutcome() {
        System.out.println("You are now in Room " + id + ".\n");
        System.out.println("You have the following options: ");

        int counter = 1;

        for (int i=1; i < choices.size(); i++) {
            System.out.print("\tOption " + i + ": ");
            choices.get(i).printOptionMessage();
        }

//        for (Monster m: monsters) {
//            System.out.print("\tOption " + counter + ": ");
//            m.printOptionMessage();
//            counter++;
//        }
//
//        for (Treasure t: treasures) {
//            System.out.print("\tOption " + counter + ": ");
//            t.printOptionMessage();
//            counter++;
//        }
//
//        for (Room r: rooms) {
//            System.out.print("\tOption " + counter + ": ");
//            r.printOptionMessage();
//            counter++;
//        }
    }

    //getters for gameplay
    public void addChoice(Choice c) {
        choices.add(c);
    }

//    //MODIFIES: this
//    //EFFECTS: adds m to next possible monsters
//    public void addMonster(Monster m) {
//        choices.add(m);
//    }
//
//    //MODIFIES: this
//    //EFFECTS: adds t to next possible treasures
//    public void addTreasure(Treasure t) {
//        choices.add(t);
//    }
//
//    //MODIFIES: this
//    //EFFECTS: adds r to next possible rooms
//    public void addRoom(Room r) {
//        choices.add(r);
//    }

    //getters for gameplay
    public Choice getChoice(int i) {
        return choices.get(i);
    }

//    public Monster getMonster(int i) {
//        return (Monster) choices.get(i);
//    }
//
//    public Treasure getTreasure(int i) {
//        return (Treasure) choices.get(i);
//    }
//
//    public Room getRoom(int i) {
//        return (Room) choices.get(i);
//    }

    public int getChoiceRange() {
        return choices.size();
    }

//    public int getMonsterRange() {
//        return choices.size();
//    }
//
//    public int getTreasureRange() {
//        return choices.size();
//    }
//
//    public int getRoomRange() {
//        return choices.size();
//    }

}
