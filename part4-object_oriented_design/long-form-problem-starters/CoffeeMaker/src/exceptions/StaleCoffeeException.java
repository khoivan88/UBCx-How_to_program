package exceptions;

public class StaleCoffeeException extends Exception {
    private int timeSinceLastBrew;

    public StaleCoffeeException(int time) {
        super(String.format("The coffee has been sitting for %d mins and now stale!\nPlease brew a fresh pot", time));
        timeSinceLastBrew = time;
    }
}
