package model;

public interface Observer {

    /**
     * This is the method which allows our Subject to update each of its observers
     * @param subj  the Subject
     * @param arg   The argument to the update method
     */
    void update(Subject subj, Object arg);


}


