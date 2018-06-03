package model;

import java.util.ArrayList;

public class Order {
    private int ticketNum;
    private String customer;
    private boolean finished;
    private String instruction;
    private ArrayList<Integer> comboID;
    private double price;

    public Order(int ticketNum, String customer) {
        this.ticketNum = ticketNum;
        this.customer = customer;
        finished = false;
        comboID = new ArrayList<Integer>();
    }

    public int getTicketNum() {
        return ticketNum;
    }

    public void setTicketNum(int ticketNum) {
        this.ticketNum = ticketNum;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public ArrayList<Integer> getComboID() {
        return comboID;
    }

//    public void setComboID(String comboID) {
//        this.comboID = comboID;
//    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTotalPrice() {
        double sum = 0;
        for (int i: comboID) {
            switch (i) {
                case 1:
                    sum += 1;
                    break;
                case 2:
                    sum += 2;
                    break;
                case 3:
                    sum += 3;
                    break;
                case 4:
                    sum += 4;
                    break;
                case 5:
                    sum += 5;
                    break;
                case 6:
                    sum += 6;
                    break;
            }
        }
        return sum;
    }

}
