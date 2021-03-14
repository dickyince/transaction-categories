package com.coding.exercise;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class FileTransactionDAOTest {

    // Class under test
    private FileTransactionDAO testSubject;

    @Before
    public void setup() {
        testSubject = new FileTransactionDAO("src/test/resources/testTransactions.json");
    }

    @Test
    public void testGetTransactionsByCategory_null_if_file_does_not_exist() {
        // if
        testSubject = new FileTransactionDAO("src/test/resources/non_existent_file.json");
        // when
        List<Transaction> actualResult = testSubject.getTransactionsByCategory("Groceries");
        // then
        assertNull(actualResult);
    }

    @Test
    public void testGetTransactionsByCategory_null_if_json_malformed() {
        // if
        testSubject = new FileTransactionDAO("src/test/resources/malformedTransactions.json");
        // when
        List<Transaction> actualResult = testSubject.getTransactionsByCategory("Groceries");
        // then
        assertNull(actualResult);
    }

    @Test
    public void testGetTransactionsByCategory_Success_for_Groceries_category() {
        // if
        List<Transaction> expectedResult = TestHelper.getGroceriesTransactions();
        // when
        List<Transaction> actualResult = testSubject.getTransactionsByCategory("Groceries");
        // then
        for(int i = 0; i < expectedResult.size(); i++) {
            assertThat(actualResult.get(i)).isEqualToComparingFieldByField(expectedResult.get(i));
        }
    }

    @Test
    public void testGetTransactionsByCategory_Success_for_null_category() {
        // if
        List<Transaction> expectedResult = TestHelper.getNullTransactions();
        // when
        List<Transaction> actualResult = testSubject.getTransactionsByCategory(null);
        // then
        for(int i = 0; i < expectedResult.size(); i++) {
            assertThat(actualResult.get(i)).isEqualToComparingFieldByField(expectedResult.get(i));
        }
    }

    @Test
    public void testGetTotalsForCategories_Success() {
        // if
        Map<String, BigDecimal> expectedResult = TestHelper.getCategoryTotals();
        // when
        Map<String, BigDecimal> actualResult = testSubject.getTotalsForCategories();
        // then
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testGetMonthlyAveragesByCategory_null_for_nonexistent_category() {
        // if
        // Expecting a null return value
        // when
        BigDecimal actualResult = testSubject.getMonthlyAveragesByCategory("nonexistent");
        // then
        assertNull(actualResult);
    }

    @Test
    public void testGetMonthlyAveragesByCategory_Success_for_MyMonthlyDD_category() {
        // if
        BigDecimal expectedResult = TestHelper.getMyMonthlyDDAverages();
        // when
        BigDecimal actualResult = testSubject.getMonthlyAveragesByCategory("MyMonthlyDD");
        // then
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testGetMonthlyAveragesByCategory_Success_for_null_category() {
        // if
        BigDecimal expectedResult = TestHelper.getNullAverages();
        // when
        BigDecimal actualResult = testSubject.getMonthlyAveragesByCategory(null);
        // then
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testGetHighestByCategoryAndYear_null_for_nonexistent_category() {
        // if
        // Expecting a null return value
        // when
        Transaction actualResult = testSubject.getHighestByCategoryAndYear("nonexistent", 2020);
        // then
        assertNull(actualResult);
    }

    @Test
    public void testGetHighestByCategoryAndYear_null_for_year_with_no_transactions() {
        // if
        // Expecting a null return value
        // when
        Transaction actualResult = testSubject.getHighestByCategoryAndYear("Groceries", 0);
        // then
        assertNull(actualResult);
    }

    @Test
    public void testGetHighestByCategoryAndYear_Success_for_Groceries_category() {
        // if
        Transaction expectedResult = TestHelper.getGroceriesHighest();
        // when
        Transaction actualResult = testSubject.getHighestByCategoryAndYear("Groceries", 2020);
        // then
        assertThat(actualResult).isEqualToComparingFieldByField(expectedResult);
    }

    @Test
    public void testGetHighestByCategoryAndYear_Success_for_null_category() {
        // if
        Transaction expectedResult = TestHelper.getNullHighest();
        // when
        Transaction actualResult = testSubject.getHighestByCategoryAndYear(null, 2019);
        // then
        assertThat(actualResult).isEqualToComparingFieldByField(expectedResult);
    }

    @Test
    public void testGetLowestByCategoryAndYear_null_for_nonexistent_category() {
        // if
        // Expecting a null return value
        // when
        Transaction actualResult = testSubject.getLowestByCategoryAndYear("nonexistent", 2020);
        // then
        assertNull(actualResult);
    }

    @Test
    public void testGetLowestByCategoryAndYear_null_for_year_with_not_transactions() {
        // if
        // Expecting a null return value
        // when
        Transaction actualResult = testSubject.getLowestByCategoryAndYear("Groceries", 0);
        // then
        assertNull(actualResult);
    }

    @Test
    public void testGetLowestByCategoryAndYear_Success_for_Groceries_category_year_2020() {
        // if
        Transaction expectedResult = TestHelper.getGroceriesLowest();
        // when
        Transaction actualResult = testSubject.getLowestByCategoryAndYear("Groceries", 2020);
        // then
        assertThat(actualResult).isEqualToComparingFieldByField(expectedResult);
    }

    @Test
    public void testGetLowestByCategoryAndYear_Success_for_null_category_year_2019() {
        // if
        Transaction expectedResult = TestHelper.getNullLowest();
        // when
        Transaction actualResult = testSubject.getLowestByCategoryAndYear(null, 2019);
        // then
        assertThat(actualResult).isEqualToComparingFieldByField(expectedResult);
    }
}
