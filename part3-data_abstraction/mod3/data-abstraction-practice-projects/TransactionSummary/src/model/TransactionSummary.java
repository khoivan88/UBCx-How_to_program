package model;

import java.util.ArrayList;
import java.util.List;

public class TransactionSummary {

    private String name;
    private List<Transaction> transactions;

    public TransactionSummary(String name) {
        this.name = name;
        transactions = new ArrayList<Transaction>();
    }

    // getters
    public String getName() {
        return name;
    }
    public List<Transaction> getTransactions() {
        return transactions;
    }
    public int getNumTransactions() {
        return transactions.size();
    }

    // REQUIRES: t is not already within transactions
    // MODIFIES: this
    // EFFECTS: adds the given transaction t to the list of transactions
    public void addTransaction(Transaction t) {
        transactions.add(t);
    }

    // REQUIRES: transactions is non-empty
    // EFFECTS: computes the average amount of money spent on a transaction
    public double averageTransactionCost() {
        return Math.round(transactions.stream().mapToDouble(i->i.getAmount()).average().getAsDouble());
    }

    // REQUIRES: transactions is non-empty
    // EFFECTS:  returns the average cost of all transactions of type specificType in this
    //           TransactionSummary
    public double specificTypeAverage(TransactionType specificType) {
        double num = 0;
        double sum = 0;
        for (Transaction t: transactions) {
            if (t.getType().equals(specificType)) {
                sum += t.getAmount();
                num++;
            }
        }
        if (num == 0) {
            return 0;
        } else {
            return sum/num;
        }
    }

    // REQUIRES: transactions is non-empty
    // EFFECTS: returns the largest transaction (in terms of cost) in this TransactionSummary
    public Transaction largestTransaction() {
        Transaction temp = transactions.get(0);
        for (Transaction t: transactions) {
            if (t.getAmount() > temp.getAmount()) {
                temp = t;
            }
        }
        return temp;
    }

    // EFFECTS: returns true if the given transaction is contained within the list of transactions
    public boolean contains(Transaction t) {
        return transactions.contains(t);
    }


}
