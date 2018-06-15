package model;

import java.util.LinkedList;

public class Subject {
    private LinkedList<Observer> observers;

    public Subject() {
        this.observers = new LinkedList<>();
    }

    public void addObserver(Observer b) {
        if (!observers.contains(b)) {
            observers.add(b);
        }
    }

    public void removeObserver(Observer o) {
        if (observers.contains(o)) {
            observers.remove(o);
        }
    }

    public void notifyObserver(Subject subject, double bid) {
        for (Observer observer: observers) {
            observer.update(subject, bid);
        }
    }

    public LinkedList<Observer> getObservers() {
        return observers;
    }
}
