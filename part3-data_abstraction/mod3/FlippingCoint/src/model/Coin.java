package model;

import java.util.Random;

public class Coin {
    private String status;

    public Coin() {
        Random rand = new Random();
        int selection = rand.nextInt(2);
        if (selection == 0) {
            this.status = "tail";
        } else {
            this.status = "head";
        }
    }

    //MODIFIES: this
    //EFFECTS: stimulate the flipping coin by randomly produce head or tail and
    //          set the state of this.status to the result of flip()
    public void flip() {
        Random rand = new Random();
        int selection = rand.nextInt(2);
        if (selection == 0) {
            this.status = "tail";
        } else {
            this.status = "head";
        }
    }

    //EFFECT: return the status of the coin as String
    public String checkStatus() {
        return this.status;
    }

    public void flipMulTimes() {
        int headCount = 0;
        int tailCount = 0;
        int times = 5000;
        for (int i = 0; i < times; i++) {
            flip();
            if (this.status == "head") {
                headCount++;
            } else {
                tailCount++;
            }
        }
        System.out.format("After %d flips, there are %d heads and %d tails.\n", times, headCount, tailCount);
    }

}
