package com.coding.exercise;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface TransactionDAO {
    public List<Transaction> getTransactionsByCategory(String category);

    public Map<String, BigDecimal> getTotalsForCategories();

    public BigDecimal getMonthlyAveragesByCategory(String category);

    public Transaction getHighestByCategoryAndYear(String category, int year);

    public Transaction getLowestByCategoryAndYear(String category, int year);
}
