package ui;

import model.Task;
import model.Todo;

public class Main {
    public static void main(String[] args) {
        Todo td = new Todo("Throw a party");
        Task t1 = new Task("Buy flour", "09/12/2017", "Whole Food");
        Task t2 = new Task("Get a new cake tin", "09/13/2017", "William Sonoma");
        Task t3 = new Task("Buy a dozen eggs", "09/12/2017", "Farmer's Market");
        Task t4 = new Task("Mix flour", "09/14/2017", "Anna's house");
        Task t5 = new Task("Grill fillet", "09/14/2017", "Anna's grill");

        Todo td1 = new Todo("Send out invitations");
        Todo td2 = new Todo("Get cake ingredients");
        Todo td3 = new Todo("Bake cake and food");

        td2.addDoable(t1);
        td2.addDoable(t2);
        td2.addDoable(t3);

        td3.addDoable(t4);
        td3.addDoable(t5);

        td.addDoable(td1);
        td.addDoable(td2);
        td.addDoable(td3);

        t1.display("\t");
        System.out.println();

        td1.display("\t");
        System.out.println();

        td.display("\t");

    }
}
