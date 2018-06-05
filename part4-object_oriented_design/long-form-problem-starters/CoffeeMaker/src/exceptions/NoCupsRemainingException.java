package exceptions;

public class NoCupsRemainingException extends Exception {
    public NoCupsRemainingException() {
        super("Not enough coffee!");
    }
}
