package com.coding.exercise;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class TestHelper {
    public static Collection<Transaction> readJsonFile(String file) {
        Collection<Transaction> testData = new ArrayList<Transaction>();
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/LLL/yyyy");

        JSONParser parser = new JSONParser();
        try{
            JSONArray data = (JSONArray) parser.parse(new FileReader(file));
            for ( Object object : data ) {
                JSONObject json = (JSONObject) object;
                Transaction transaction = new Transaction();
                transaction.setDate(LocalDate.parse((CharSequence) json.get("date"), dateFormat));
                transaction.setVendor((String) json.get("vendor"));
                transaction.setType(TransactionType.valueOf((String) json.get("type")));
                transaction.setAmount(new BigDecimal((String) json.get("amount")));
                transaction.setCategory((String) json.get("category"));
                testData.add(transaction);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return testData;
    }
}
