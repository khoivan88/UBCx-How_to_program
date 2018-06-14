package model;

public abstract class Book {
    protected static final double FLAT_RATE_SHIPPING = 2.00;
    protected static final String MIN_BOX_SIZE = "medium";
    protected String title;
    protected double price;
    protected Box box;

    public Book(String title, double price) {
        this.title = title;
        this.box = null; // book starts off unpackaged
        this.price = price;
    }

    // REQUIRES: model.Box must be medium or large
    // MODIFIES: this
    // EFFECTS:  If the book fits in the given box, then the two are associated (the book is packaged).
    public abstract Box packageBook(Box b);

    public String getTitle() {
        return title;
    }

    public void setBox(Box box) {
        this.box = box;
    }

    // EFFECTS: Returns the flat rate for shipping a standard sized book
    public abstract double calculateShipping();

    // EFFECTS: returns the minimum required size of box for packaging this book
    public abstract String getMinBoxSize();
}
