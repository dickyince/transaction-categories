package com.coding.exercise;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestHelper {

    public static List<Transaction> getGroceriesTransactions() {
        List<Transaction> transactions = new ArrayList<>();

        Transaction transaction = new Transaction();
        transaction.setDate(LocalDate.of(2020, 11, 1));
        transaction.setVendor("Morrisons");
        transaction.setType(TransactionType.CARD);
        transaction.setAmount(new BigDecimal("10.40"));
        transaction.setCategory("Groceries");
        transactions.add(transaction);

        Transaction transaction2 = new Transaction();
        transaction2.setDate(LocalDate.of(2020, 10, 1));
        transaction2.setVendor("M&S");
        transaction2.setType(TransactionType.CARD);
        transaction2.setAmount(new BigDecimal("5.99"));
        transaction2.setCategory("Groceries");
        transactions.add(transaction2);

        return transactions;
    }

    public static List<Transaction> getNullTransactions() {
        List<Transaction> transactions = new ArrayList<>();

        Transaction transaction = new Transaction();
        transaction.setDate(LocalDate.of(2020, 9, 30));
        transaction.setVendor("McMillan");
        transaction.setType(TransactionType.INTERNET);
        transaction.setAmount(new BigDecimal("10.00"));
        transactions.add(transaction);

        Transaction transaction2 = new Transaction();
        transaction2.setDate(LocalDate.of(2019, 8, 27));
        transaction2.setVendor("Random Thing");
        transaction2.setType(TransactionType.INTERNET);
        transaction2.setAmount(new BigDecimal("7.94"));
        transactions.add(transaction2);

        Transaction transaction3 = new Transaction();
        transaction3.setDate(LocalDate.of(2019, 3, 19));
        transaction3.setVendor("Awesome Hotels");
        transaction3.setType(TransactionType.CARD);
        transaction3.setAmount(new BigDecimal("250.94"));
        transactions.add(transaction3);

        return transactions;
    }

    public static Map<String, BigDecimal> getCategoryTotals() {
        Map<String, BigDecimal> totals = new HashMap<>();

        totals.put("MyMonthlyDD", new BigDecimal("640.00"));
        totals.put("Groceries", new BigDecimal("16.39"));
        totals.put(null, new BigDecimal("268.43"));

        return totals;
    }

    public static BigDecimal getMyMonthlyDDAverages() {
        return new BigDecimal("320.00");
    }

    public static BigDecimal getNullAverages() {
        return new BigDecimal("89.47");
    }

    public static Transaction getGroceriesHighest() {
        Transaction transaction = new Transaction();
        transaction.setDate(LocalDate.of(2020, 11, 1));
        transaction.setVendor("Morrisons");
        transaction.setType(TransactionType.CARD);
        transaction.setAmount(new BigDecimal("10.40"));
        transaction.setCategory("Groceries");
        return transaction;
    }

    public static Transaction getNullHighest() {
        Transaction transaction = new Transaction();
        transaction.setDate(LocalDate.of(2019, 3, 19));
        transaction.setVendor("Awesome Hotels");
        transaction.setType(TransactionType.CARD);
        transaction.setAmount(new BigDecimal("250.49"));
        return transaction;
    }

    public static Transaction getGroceriesLowest() {
        Transaction transaction = new Transaction();
        transaction.setDate(LocalDate.of(2020, 10, 1));
        transaction.setVendor("M&S");
        transaction.setType(TransactionType.CARD);
        transaction.setAmount(new BigDecimal("5.99"));
        transaction.setCategory("Groceries");
        return transaction;
    }

    public static Transaction getNullLowest() {
        Transaction transaction = new Transaction();
        transaction.setDate(LocalDate.of(2019, 8, 27));
        transaction.setVendor("Random Thing");
        transaction.setType(TransactionType.INTERNET);
        transaction.setAmount(new BigDecimal("7.94"));
        return transaction;
    }
}
