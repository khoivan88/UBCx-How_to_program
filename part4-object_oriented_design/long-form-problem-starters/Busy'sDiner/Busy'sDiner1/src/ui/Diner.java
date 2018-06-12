package ui;

import model.Chef;
import model.Server;
import model.Order;

public class Diner {

    public static void main(String[] args) {
        Server server = new Server();
        Chef chef = new Chef();

        for (int i=0; i < 2 ; i++) {
            System.out.println("Table " + (i + 1) + ":\n");

            server.greet();
            server.describeDish();
            Order o = server.takeOrder();

            chef.makeDish(o);

            System.out.println();

            doOrderRoutine(server, o);
            System.out.println();
        }

        System.out.println();
//        server.doDishes();
        chef.doDishes();
    }

    private static void doOrderRoutine(Server e, Order o) {
//        if (o.needsToBePrepared())
//            e.makeDish(o);
        System.out.println();
        if (o.isReadyToBeServed())
            e.deliverFood(o);
        if(o.isReadyToBePaid())
            e.takePayment(o);
    }

}
