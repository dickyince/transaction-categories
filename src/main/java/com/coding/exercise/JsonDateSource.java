package com.coding.exercise;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

public class JsonDateSource implements DataSource{
    private String fileLocation;

    @Override
    public Collection<Transaction> getTransactions() {
//        ObjectMapper objectMapper = new ObjectMapper();
//        try {
//            return objectMapper.readValue(new File(fileLocation), Transaction.class);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        return null;
    }

    public void setFileLocation(String fileLocation) {
        this.fileLocation = fileLocation;
    }
}
