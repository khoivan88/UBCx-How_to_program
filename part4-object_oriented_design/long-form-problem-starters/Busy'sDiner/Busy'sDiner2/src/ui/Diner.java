package ui;

import model.Chef;
import model.Dish;
import model.Server;
import model.Order;

import java.util.ArrayList;
import java.util.List;

public class Diner {

    public static void main(String[] args) {
        Dish turkeySandwiches = generateTurkeyClubSandwich();
        Server server = new Server(turkeySandwiches);
        Chef chef = new Chef();

        for (int i=0; i < 2 ; i++) {
            System.out.println("Table " + (i + 1) + ":\n");

            server.greet();
            server.describeDish();
            Order o = server.takeOrder();

            System.out.println();
            chef.makeDish(o);

            doOrderRoutine(server, o);
            System.out.println();
        }

        System.out.println();
        chef.doDishes();
    }

    private static Dish generateTurkeyClubSandwich() {
        List<String> ingredients = new ArrayList<>();
        ingredients.add("avocado");
        ingredients.add("sriracha");
        ingredients.add("cheddar cheese");
        ingredients.add("bread");
        ingredients.add("lettuce");
        ingredients.add("tomato");
        ingredients.add("turkey");
        ingredients.add("bacon");
        return new Dish("Turkey club sandwich",
                "\"Our trendy sandwich has avocado, sriracha sauce, cheese, veggies, turkey and bacon.\"",
                ingredients,
                "\t1. Pour sriracha\n\t2. Spread avocado\n\t3. Stack meat\n\t4. Place veggies");
    }

    private static void doOrderRoutine(Server s, Order o) {
        System.out.println();
        if (o.isReadyToBeServed())
            s.deliverFood(o);
        if(o.isReadyToBePaid())
            s.takePayment(o);
    }

}
