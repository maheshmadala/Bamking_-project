package org.example.service;

import org.example.model.Account;

import java.sql.SQLException;

public interface AccountService {
    void CreateAccount(Account account) throws SQLException;

    void UpdateBalance(String acctNo,double balance) throws SQLException;

    Account getAccount(String acctNo) throws SQLException;

    void deposit( String acctNo, double amount) throws SQLException;

    void withdraw(String  acctNo, double amount) throws SQLException;

    void transfer(String  fromAcc, String toAcc, double amount) throws SQLException;

    void transactionHistory(String  acctNo) throws SQLException;
}

