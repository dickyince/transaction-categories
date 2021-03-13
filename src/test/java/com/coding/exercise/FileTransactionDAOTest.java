package com.coding.exercise;

import org.junit.Before;

public class FileTransactionDAOTest {

    // Class under test
    private FileTransactionDAO testSubject;

    @Before
    public void setup() {
        testSubject = new FileTransactionDAO("src/test/resources/testTransactions.json");
    }
}
