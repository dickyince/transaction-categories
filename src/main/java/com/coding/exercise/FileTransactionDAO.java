package com.coding.exercise;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class FileTransactionDAO implements TransactionDAO {
    private String fileLocation;

    public FileTransactionDAO(String fileLocation) {
        this.fileLocation = fileLocation;
    }

    @Override
    public List<Transaction> getTransactionsByCategory(String category) {
        List<Transaction> transactions = readJSONFile();
        if(transactions != null) {
            List<Transaction> categoryTransactions = new ArrayList<>();
            for(Transaction t : transactions) {
                if(category == null) {
                    if(t.getCategory() == null) {
                        categoryTransactions.add(t);
                    }
                }
                else if(category.equals(t.getCategory())) {
                    categoryTransactions.add(t);
                }
            }
            categoryTransactions.sort(Comparator.comparing(Transaction::getDate).reversed());
            return categoryTransactions;
        }
        return null;
    }

    @Override
    public Map<String, BigDecimal> getTotalsForCategories() {
        List<Transaction> transactions = readJSONFile();
        if(transactions != null) {
            Map<String, BigDecimal> totals = new HashMap<>();
            for(Transaction t : transactions) {
                String category = t.getCategory();
                BigDecimal amount = t.getAmount();
                if(totals.get(category) != null) {
                    amount = amount.add(totals.get(category));
                }
                totals.put(category, amount);
            }
            return totals;
        }
        return null;
    }

    @Override
    public BigDecimal getMonthlyAveragesByCategory(String category) {
        List<Transaction> transactions = getTransactionsByCategory(category);
        if(transactions != null){
            Map<String, BigDecimal> months = new HashMap<>();
            for(Transaction t : transactions) {
                LocalDate date = t.getDate();
                String month = date.getMonth().getValue() + ":" + date.getYear();
                BigDecimal amount = months.get(month);
                if(amount == null) {
                    months.put(month, t.getAmount());
                }
                else {
                    months.put(month, amount.add(t.getAmount()));
                }
            }
            if(months.size() > 0) {
                BigDecimal number = new BigDecimal(months.size());
                BigDecimal amount = new BigDecimal("0.00");
                for (BigDecimal a : months.values()) {
                    amount = amount.add(a);
                }
                return amount.divide(number, 2, RoundingMode.DOWN);
            }
        }
        return null;
    }

    @Override
    public Transaction getHighestByCategoryAndYear(String category, int year) {
        List<Transaction> transactions = getTransactionsByCategory(category);
        if(transactions != null && transactions.size() > 0) {
            Transaction highest = new Transaction();
            highest.setAmount(new BigDecimal("0.00"));
            for(Transaction t : transactions) {
                if(t.getDate().getYear() == year) {
                    highest = getHighest(highest, t);
                }
            }
            if(highest.getVendor() != null) {
                return highest;
            }
        }
        return null;
    }

    @Override
    public Transaction getLowestByCategoryAndYear(String category, int year) {
        List<Transaction> transactions = getTransactionsByCategory(category);
        if(transactions != null && transactions.size() > 0) {
            Transaction lowest = new Transaction();
            for(Transaction t : transactions) {
                if(t.getDate().getYear() == year) {
                    lowest = getLowest(lowest, t);
                }
            }
            if(lowest.getVendor() != null) {
                return lowest;
            }
        }
        return null;
    }

    private List<Transaction> readJSONFile() {
        JSONParser parser = new JSONParser();
        try {
            JSONArray data = (JSONArray) parser.parse(new FileReader(fileLocation));
            if(data != null) {
                List<Transaction> transactions = new ArrayList<>();
                DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/LLL/yyyy");
                for (Object object : data) {
                    JSONObject json = (JSONObject) object;
                    Transaction transaction = new Transaction();

                    transaction.setDate(LocalDate.parse((CharSequence) json.get("date"), dateFormat));
                    transaction.setVendor((String) json.get("vendor"));
                    transaction.setType(TransactionType.valueOf((String) json.get("type")));
                    transaction.setAmount(new BigDecimal((String) json.get("amount")).setScale(2, RoundingMode.DOWN));
                    transaction.setCategory((String) json.get("category"));

                    transactions.add(transaction);
                }
                return transactions;
            }
            // I would log this exception and/or try to recover from it here but I'll just print to stdout just now
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Transaction getHighest(Transaction t1, Transaction t2) {
        if(t1.getAmount().compareTo(t2.getAmount()) < 0) {
            return t2;
        }
        return t1;
    }

    private Transaction getLowest(Transaction t1, Transaction t2) {
        if(t1.getAmount() == null || t1.getAmount().compareTo(t2.getAmount()) > 0) {
            return t2;
        }
        return t1;
    }
}
