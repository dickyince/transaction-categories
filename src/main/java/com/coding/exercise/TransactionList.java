package com.coding.exercise;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface TransactionList {
    public TransactionList getByCategory(String category);

    public TransactionList getByMonth(LocalDate month);

    public TransactionList getByYear(LocalDate year);

    public BigDecimal getTotalAmount();

    public BigDecimal getAverageAmount();

    public Transaction getTransactionWithHighestAmount();

    public Transaction getTransactionWithLowestAmount();
}
