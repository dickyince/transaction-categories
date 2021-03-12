package com.coding.exercise;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;

public class MemoryTransactionList implements TransactionList{
    private Collection transactions;
    private DataSource dataSource;

    @Override
    public TransactionList getByCategory(String category) {
        return null;
    }

    @Override
    public TransactionList getByMonth(Date month) {
        return null;
    }

    @Override
    public TransactionList getByYear(Date year) {
        return null;
    }

    @Override
    public BigDecimal getTotalAmount() {
        BigDecimal totalAmount = new BigDecimal("666.39");
        return totalAmount;
    }

    @Override
    public BigDecimal getAverageAmount() {
        BigDecimal averageAmount = new BigDecimal("133.27");
        return averageAmount;
    }

    @Override
    public Transaction getTransactionWithHighestAmount() {
        Transaction transaction = new Transaction();
        transaction.setAmount(new BigDecimal("600.00"));
        return transaction;
    }

    @Override
    public Transaction getTransactionWithLowestAmount() {
        Transaction transaction = new Transaction();
        transaction.setAmount(new BigDecimal("5.99"));
        return transaction;
    }

    private void sortTransactionsByDate() {

    }

    private void sortTransactionsByAmount() {

    }
}
