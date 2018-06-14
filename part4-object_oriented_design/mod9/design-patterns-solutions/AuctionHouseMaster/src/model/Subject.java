package model;

import java.util.LinkedList;

public class Subject {

    private LinkedList<Observer> observers = new LinkedList<>();

    public void addObserver(Observer o) {
        if (!observers.contains(o)) {
            observers.add(o);
        }
    }

    public void removeObserver(Observer o) {
        if (observers.contains(o)) {
            observers.remove(o);
        }
    }

    public void notifyObservers(Subject observable, double newBid) {
        for (Observer b : observers) {
            b.update(observable, newBid);
        }
    }


}


