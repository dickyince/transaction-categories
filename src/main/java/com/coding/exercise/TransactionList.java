package com.coding.exercise;

import java.math.BigDecimal;
import java.util.Date;

public interface TransactionList {
    public TransactionList getByCategory(String category);

    public TransactionList getByMonth(Date month);

    public TransactionList getByYear(Date year);

    public BigDecimal getTotalAmount();

    public BigDecimal getAverageAmount();

    public Transaction getTransactionWithHighestAmount();

    public Transaction getTransactionWithLowestAmount();
}
