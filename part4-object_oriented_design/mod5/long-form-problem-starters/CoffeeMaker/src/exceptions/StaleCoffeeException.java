package exceptions;

public class StaleCoffeeException extends Exception {
    private int timeSinceBrew;

    public StaleCoffeeException(int time) {
        super(String.format("The coffee has been sitting for %d hours and now stale!", time));
        timeSinceBrew = time;
    }
}
