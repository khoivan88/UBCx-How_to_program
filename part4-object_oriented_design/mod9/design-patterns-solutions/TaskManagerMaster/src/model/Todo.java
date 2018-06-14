package model;

import java.util.LinkedList;
import java.util.List;


public class Todo extends Doable {

    private String description;
    private List<Doable> subs;

    public Todo(String description) {
        super();
        this.description = description;
        subs = new LinkedList<>();
    }

    // getters
    public List<Doable> getSubTasks() { return subs; }

    /**
     * Adds a given Doable to subs
     * @param d the Doable object we wish to add
     * @return true if the Doable object is successfully added, else return false
     */
    public boolean addDoable(Doable d) {
        if (!subs.contains(d)) {
            subs.add(d);
            return true;
        } else {
            return false;

        }
    }

    /**
     * Removes given Doable from subs
     * @param d the Doable object we wish to remove
     * @return true if the Doable object is successfully removed, else return false
     */
    public boolean removeDoable(Doable d) {
        if (subs.contains(d)) {
            subs.remove(d);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String getDescription() {
        return description;
    }

    /**
     * This implementation differs from that of Task. All the subs must be
     * complete for the top-level to be completed.
     */
    @Override
    public void complete() {
        boolean isAllDone = true;
        for (Doable d : subs) {
            if (!d.getStatus()) {
                isAllDone = false;
            }
        }
        complete = isAllDone;
    }

    @Override
    public void display(String indentSpace) {
        System.out.println(indentSpace + getDescription());
        for (Doable d : subs) {
            d.display(indentSpace + indentSpace);
        }
    }


}