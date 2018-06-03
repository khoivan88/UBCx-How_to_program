package model;

public abstract class Entry {
    private Date date;
    private Time time;
    private String label;
    private boolean isRepeating;
    private int interval;

    //REQUIRES: date and time is in the future
    public Entry(Date date, Time time, String label) {
        this.date = date;
        this.time = time;
        this.label = label;
        this.isRepeating = false;
    }

    //getters:
    public Date getDate() {
        return date;
    }
    public Time getTime() {
        return time;
    }
    public String getLabel() {
        return label;
    }

    public boolean isRepeating() {
        return isRepeating;
    }

    public int getIntervalOfRepetition() {
        return interval;
    }

    public void setInterval(int interval) {
        this.interval = interval;
    }
}
