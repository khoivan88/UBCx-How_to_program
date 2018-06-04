package exceptions;

public class BeansAmountException extends Exception {
    private double beans;

    protected BeansAmountException(double beans) {
        super(String.format("%f is not the right amount of beans", beans));
        this.beans = beans;
    }

    protected BeansAmountException(double beans, String message){
        super("\n" + beans + message + "\nPlease add between 2.4 and 2.6 cups of coffee bean.");
        this.beans = beans;
    }

    protected double getBeans() { return beans; }
}
