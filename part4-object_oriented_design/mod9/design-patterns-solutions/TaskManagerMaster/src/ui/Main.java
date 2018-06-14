package ui;

import model.Task;
import model.Todo;

public class Main {

    public static void main(String[] args) {
        Todo holdParty, sendInvites, acquireCake, makeFood;
        Task getFlour, getEggs, getTin, mixFlour, grillFish;
        getFlour = new Task("Buy flour", "09/12/2017", "Whole Foods");
        getEggs = new Task("Buy a dozen eggs", "09/12/2017", "Farmer's Market");
        getTin = new Task("Get a new cake tin", "09/13/2017", "Williams Sonoma");
        mixFlour = new Task("Mix flour", "09/14/2017", "Anna's house");
        grillFish = new Task("Grill fillet of sole", "09/14/2017", "Anna's grill");
        holdParty = new Todo("Throw party");
        sendInvites = new Todo("Send out invitations");
        acquireCake = new Todo("Get cake ingredients");
        makeFood = new Todo("Bake cake and food");

        holdParty.addDoable(sendInvites);
        holdParty.addDoable(acquireCake);
        holdParty.addDoable(makeFood);
        makeFood.addDoable(mixFlour);
        makeFood.addDoable(grillFish);
        acquireCake.addDoable(getFlour);
        acquireCake.addDoable(getTin);
        acquireCake.addDoable(getEggs);

        holdParty.display("  ");
    }


}