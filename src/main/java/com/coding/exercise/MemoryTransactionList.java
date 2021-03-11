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
        return null;
    }

    @Override
    public BigDecimal getAverageAmount() {
        return null;
    }

    @Override
    public Transaction getTransactionWithHighestAmount() {
        return null;
    }

    @Override
    public Transaction getTransactionWithLowestAmount() {
        return null;
    }

    private void sortTransactionsByDate() {

    }

    private void sortTransactionsByAmount() {

    }
}
