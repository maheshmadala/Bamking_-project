package org.example.dao;

import java.sql.SQLException;

public interface TransactionDAO {

    void addTransaction(String fromAcc,String  toAcc,double amount,
                        String type) throws SQLException;

    void getTransactionHistory(String  acctNo) throws SQLException;
}
