package com.coding.exercise;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MemoryTransactionList implements TransactionList{
    private List<Transaction> transactions;

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    @Override
    public TransactionList getByCategory(String category) {
        if(category == null) {
            return null;
        }
        List<Transaction> categoryTransactions = new ArrayList<>();
        for(Transaction t : transactions){
            if(category.equalsIgnoreCase(t.getCategory())){
                categoryTransactions.add(t);
            }
        }
        MemoryTransactionList categoryTransactionList = new MemoryTransactionList();
        categoryTransactionList.setTransactions(categoryTransactions);
        categoryTransactionList.sortTransactionsByDate();
        return categoryTransactionList;
    }

    @Override
    public TransactionList getByMonth(LocalDate month) {
        if (month == null) {
            return null;
        }
        List<Transaction> monthTransactions = new ArrayList<>();
        for(Transaction t : transactions) {
            if(month.getMonth().equals(t.getDate().getMonth())){
                monthTransactions.add(t);
            }
        }
        MemoryTransactionList monthTransactionList = new MemoryTransactionList();
        monthTransactionList.setTransactions(monthTransactions);
        return monthTransactionList;
    }

    @Override
    public TransactionList getByYear(LocalDate year) {
        if(year == null) {
            return null;
        }
        List<Transaction> yearTransactions = new ArrayList<>();
        for(Transaction t : transactions) {
            if(year.getYear() == t.getDate().getYear()) {
                yearTransactions.add(t);
            }
        }
        MemoryTransactionList yearTransactionList = new MemoryTransactionList();
        yearTransactionList.setTransactions(yearTransactions);
        return yearTransactionList;
    }

    @Override
    public BigDecimal getTotalAmount() {
        BigDecimal totalAmount = new BigDecimal("0");
        for( Transaction t : transactions ) {
            totalAmount = totalAmount.add(t.getAmount());
        }
        return totalAmount;
    }

    @Override
    public BigDecimal getAverageAmount() {
        BigDecimal averageAmount = getTotalAmount();
        BigDecimal divisor = new BigDecimal(transactions.size());
        averageAmount = averageAmount.divide(divisor, 2, RoundingMode.DOWN);
        return averageAmount;
    }

    @Override
    public Transaction getTransactionWithHighestAmount() {
        sortTransactionsByAmount();
        return transactions.get(0);
    }

    @Override
    public Transaction getTransactionWithLowestAmount() {
        sortTransactionsByAmount();
        return transactions.get(transactions.size() - 1);
    }

    private void sortTransactionsByDate() {
        transactions.sort(Comparator.comparing(t -> t.getDate()));
    }

    private void sortTransactionsByAmount() {
        transactions.sort(Comparator.comparing(t -> t.getAmount(), Comparator.reverseOrder()));
    }
}
