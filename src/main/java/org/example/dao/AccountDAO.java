package org.example.dao;

import org.example.model.Account;

import java.sql.SQLException;

public interface AccountDAO{
    void CreateAccount(Account account) throws SQLException;

    Account getAccount(String acctNo) throws SQLException;

    void UpdateBalance (int id,double balance) throws SQLException;


}
