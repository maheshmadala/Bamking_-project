package org.example.service;

import org.example.dao.AccountDAO;
import org.example.dao.AccountDAOImpl;
import org.example.model.Account;

import java.sql.SQLException;

public class AccountServiceImpl implements AccountService {

    AccountDAO dao = new AccountDAOImpl();

    @Override
    public void CreateAccount(Account account) throws SQLException {
        dao.CreateAccount(account);
    }

    @Override
    public Account getAccount(String acctNo) throws SQLException {
        return dao.getAccount(acctNo);
    }
    @Override
    public void UpdateBalance(int id,double balance) throws SQLException{
         dao.UpdateBalance(id,balance);
    }
}
