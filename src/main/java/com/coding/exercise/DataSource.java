package com.coding.exercise;

import java.util.Collection;

public interface DataSource {
    public Collection<Transaction> getTransactions();
}
