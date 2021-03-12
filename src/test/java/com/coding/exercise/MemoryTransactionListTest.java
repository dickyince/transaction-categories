package com.coding.exercise;

import org.junit.Before;
import org.junit.Test;
import org.mockito.internal.matchers.apachecommons.ReflectionEquals;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MemoryTransactionListTest {

    // Class under test
    private MemoryTransactionList testSubject;

    @Before
    public void setup() {
        testSubject = new MemoryTransactionList();
        testSubject.setTransactions(TestHelper.readJsonFile("src/test/resources/testTransactions.json"));
    }

    @Test
    public void testGetTotalAmount_true_for_all_transactions() {
        // if
        BigDecimal expectedAmount = new BigDecimal("924.82");
        // when
        BigDecimal totalAmount = testSubject.getTotalAmount();
        // then
        assertEquals(expectedAmount, totalAmount);
    }

    @Test
    public void testGetAverageAmount_true_for_all_transactions() {
        // if
        BigDecimal expectedAmount = new BigDecimal("132.11");
        // when
        BigDecimal averageAmount = testSubject.getAverageAmount();
        // then
        assertEquals(expectedAmount, averageAmount);
    }

    @Test
    public void testGetTransactionWithHighestAmount_true_for_all_transactions() {
        // if
        BigDecimal expectedAmount = new BigDecimal("600.00");
        // when
        BigDecimal highestAmount = testSubject.getTransactionWithHighestAmount().getAmount();
        // then
        assertEquals(expectedAmount, highestAmount);
    }

    @Test
    public void testGetTransactionWithLowestAmount_true_for_all_transactions() {
        // if
        BigDecimal expectedAmount = new BigDecimal("5.99");
        // when
        BigDecimal lowestAmount = testSubject.getTransactionWithLowestAmount().getAmount();
        // then
        assertEquals(expectedAmount, lowestAmount);
    }

    @Test
    public void testGetByCategory_true_for_MyMonthlyDD_transactions() {
        // if
        List<Transaction> expectedCollection = TestHelper.readJsonFile("src/test/resources/DDTransactions.json");
        // when
        MemoryTransactionList internetTransactions = (MemoryTransactionList) testSubject.getByCategory("MyMonthlyDD");
        // then
        assertTrue(new ReflectionEquals(expectedCollection).matches(internetTransactions.getTransactions()));
    }

    @Test
    public void testGetByCategory_true_for_Groceries_transactions() {
        // if
        List<Transaction> expectedCollection = TestHelper.readJsonFile("src/test/resources/groceriesTransactions.json");
        // when
        MemoryTransactionList groceriesTransactions = (MemoryTransactionList) testSubject.getByCategory("Groceries");
        // then
        assertTrue(new ReflectionEquals(expectedCollection).matches(groceriesTransactions.getTransactions()));
    }

    @Test
    public void testGetTotalAmount_true_for_Groceries_transactions() {
        // if
        BigDecimal expectedAmount = new BigDecimal("16.39");
        // when
        TransactionList groceriesTransactions = testSubject.getByCategory("Groceries");
        BigDecimal totalAmount = groceriesTransactions.getTotalAmount();
        // then
        assertEquals(expectedAmount, totalAmount);
    }

    @Test
    public void testGetByMonth_true_for_October_transactions() {
        // if
        List<Transaction> expectedCollection = TestHelper.readJsonFile("src/test/resources/octoberTransactions.json");
        LocalDate october = LocalDate.of(2021, 10, 01);
        // when
        MemoryTransactionList octoberTransactions = (MemoryTransactionList) testSubject.getByMonth(october);
        // then
        assertTrue(new ReflectionEquals(expectedCollection).matches(octoberTransactions.getTransactions()));
    }

    @Test
    public void testGetAverageAmount_true_for_October_transactions() {
        // if
        BigDecimal expectedAmount = new BigDecimal("215.33");
        LocalDate october = LocalDate.of(2021, 10, 01);
        // when
        TransactionList octoberTransactions = testSubject.getByMonth(october);
        BigDecimal totalAmount = octoberTransactions.getAverageAmount();
        // then
        assertEquals(expectedAmount, totalAmount);
    }

    @Test
    public void testGetByYear_true_for_2021_transactions() {
        // if
        List<Transaction> expectedTransactions = new ArrayList<>();
        LocalDate twentyOne = LocalDate.of(2012, 01, 01);
        // when
        MemoryTransactionList twentyOneTransactions = (MemoryTransactionList) testSubject.getByYear(twentyOne);
        // then
        assertTrue(new ReflectionEquals(expectedTransactions).matches(twentyOneTransactions.getTransactions()));
    }

    @Test
    public void testGetTransactionWithHighestAmount_true_for_2019_transactions() {
        // if
        BigDecimal expectedAmount = new BigDecimal("250.49");
        LocalDate nineteen = LocalDate.of(2019, 01,01);
        // when
        TransactionList nineteenTransactions = testSubject.getByYear(nineteen);
        BigDecimal highestAmount = nineteenTransactions.getTransactionWithHighestAmount().getAmount();
        // then
        assertEquals(expectedAmount, highestAmount);
    }

    @Test
    public void testGetTransactionWithLowestAmount_true_for_2019_transactions() {
        // if
        BigDecimal expectedAmount = new BigDecimal("7.94");
        LocalDate nineteen = LocalDate.of(2019, 01,01);
        // when
        TransactionList nineteenTransactions = testSubject.getByYear(nineteen);
        BigDecimal lowestAmount = nineteenTransactions.getTransactionWithLowestAmount().getAmount();
        // then
        assertEquals(expectedAmount, lowestAmount);
    }
}
