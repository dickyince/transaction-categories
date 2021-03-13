package com.coding.exercise;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class FileTransactionDAO implements TransactionDAO {
    private String fileLocation;

    public FileTransactionDAO(String fileLocation) {
        this.fileLocation = fileLocation;
    }

    @Override
    public List<Transaction> getTransactionsByCategory(String category) {
        return null;
    }

    @Override
    public Map<String, BigDecimal> getTotalsForCategories() {
        return null;
    }

    @Override
    public BigDecimal getMonthlyAveragesByCategory(String category) {
        return null;
    }

    @Override
    public Transaction getHighestByCategoryAndYear(String category, int year) {
        return null;
    }

    @Override
    public Transaction getLowestByCategoryAndYear(String category, int year) {
        return null;
    }
}
