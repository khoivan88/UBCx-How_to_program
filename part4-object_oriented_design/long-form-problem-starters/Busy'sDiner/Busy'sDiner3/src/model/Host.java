package model;

import java.util.List;

public class Host extends FOHEmployee {

    private static final String PREFIX = "HOST - ";

    public Host(Dish dish) {
        super(dish);
    }

    @Override
    public String getPrefix() {
        return PREFIX;
    }

    public double getCash() {
        System.out.println(ERROR + "Host has no cash!");
        return 0.0;
    }

    public List<Order> getActiveOrders() {
        System.out.println(ERROR + "Host does not have any active orders!");
        return null;
    }

    public Order takeOrder() {
        System.out.println(ERROR + "Hosts can't take orders!");
        return null;
    }

    public void takePayment(Order order) {
        System.out.println(ERROR + "Host can't take payment!");
    }

}
