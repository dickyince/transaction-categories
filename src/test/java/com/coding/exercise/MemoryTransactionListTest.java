package com.coding.exercise;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Collection;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import static org.junit.Assert.assertEquals;

public class MemoryTransactionListTest {

    // Class under test
    private MemoryTransactionList testSubject;

    // Mocks used for test
    private DataSource mockDataSource;

    // Test data
    private Collection<Transaction> testTransactions;

    @Before
    public void setup() {
        testSubject = new MemoryTransactionList();
        mockDataSource = mock(DataSource.class);
        when(mockDataSource.getTransactions()).thenReturn(testTransactions);
        testTransactions = TestHelper.readJsonFile("src/test/resources/testTransactions.json");
    }

    @Test
    public void testGetTotalAmount_true_for_all_transactions() {
        // if
        BigDecimal expectedAmount = new BigDecimal("666.39");
        // when
        BigDecimal totalAmount = testSubject.getTotalAmount();
        // then
        assertEquals(expectedAmount, totalAmount);
    }

    @Test
    public void testGetAverageAmount_true_for_all_transactions() {
        // if
        BigDecimal expectedAmount = new BigDecimal("133.27");
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
}
