package main;

import exceptions.*;
import model.CoffeeMaker;

public class Main {

    public static void main(String[] args){
        CoffeeMaker coffeeMaker = new CoffeeMaker();

        //correct workflow
        try {
            coffeeMaker.brew(2.50, 15);
        } catch (WaterException e) {
            e.getMessage();
            e.printStackTrace();
        } catch (NotEnoughBeansException e) {
            e.getMessage();
            e.printStackTrace();
        } catch (TooManyBeansException e) {
            e.getMessage();
            e.printStackTrace();
        }

        for (int i = 0; i<5; i++) {
            try {
                coffeeMaker.pourCoffee();
            } catch (NoCupsRemainingException e) {
                e.getMessage();
                e.printStackTrace();
            } catch (StaleCoffeeException e) {
                e.getMessage();
                e.printStackTrace();
            }
        }

        //will set off BeansException
        try {
            coffeeMaker.brew(2, 10);
        } catch (WaterException e) {
            e.getMessage();
            e.printStackTrace();
        } catch (NotEnoughBeansException e) {
            e.getMessage();
            e.printStackTrace();
        } catch (TooManyBeansException e) {
            e.getMessage();
            e.printStackTrace();
        }

        try {
            coffeeMaker.brew(2.6, 20);
        } catch (WaterException e) {
            e.printStackTrace();
        } catch (NotEnoughBeansException e) {
            e.printStackTrace();
        } catch (TooManyBeansException e) {
            e.printStackTrace();
        }

        //will set off StaleCoffeeException
        coffeeMaker.setTimeSinceLastBrew(70);
        try {
            coffeeMaker.pourCoffee();
        } catch (NoCupsRemainingException e) {
            e.getMessage();
            e.printStackTrace();
        } catch (StaleCoffeeException e) {
            e.getMessage();
            e.printStackTrace();
        }

    }


}