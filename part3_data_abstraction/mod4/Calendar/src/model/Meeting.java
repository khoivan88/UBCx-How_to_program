package model;

import java.util.ArrayList;

public class Meeting extends Event {
    private ArrayList<String> attendees;

    public Meeting(Date date, Time time, String label, Reminder reminder) {
        super(date, time, label, reminder);
        this.attendees = new ArrayList<String>();
    }

    public ArrayList<String> getAttendee() {
        return attendees;
    }

    //REQUIRES: email != null
    public void addAttendee(String email) {
        if (!attendees.contains(email)) {
            attendees.add(email);
        }
    }

    //REQUIRES:
    //EFFECTS: return true if successfully removed (person in the list of attendees);
    //          else, return false
    public boolean removeAttendee(String person) {
        if (attendees.contains(person)) {
            attendees.remove(person);
            return true;
        }
        return false;
    }

    public void sentInvites() {
        System.out.print("Inviting: ");
        for (String attendee: attendees) {
            System.out.print(attendee + ", ");
        }
    }
}
