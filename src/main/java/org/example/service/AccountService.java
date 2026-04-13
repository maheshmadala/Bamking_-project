package org.example.service;

import org.example.model.Account;

import java.sql.SQLException;

public interface AccountService {
    void CreateAccount(Account account) throws SQLException;

    void UpdateBalance(int id,double balance) throws SQLException;

    Account getAccount(String acctNo) throws SQLException;



}
