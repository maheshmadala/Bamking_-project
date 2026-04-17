package org.example.service;

import org.example.dao.AccountDAO;
import org.example.dao.AccountDAOImpl;
import org.example.dao.TransactionDAO;
import org.example.dao.TransactionDAOImpl;
import org.example.model.Account;

import java.sql.SQLException;

public class AccountServiceImpl implements AccountService {

    AccountDAO dao = new AccountDAOImpl();
    TransactionDAO tdao = new TransactionDAOImpl();

    @Override
    public void CreateAccount(Account account) throws SQLException {
        dao.CreateAccount(account);
    }

    @Override
    public Account getAccount(String acctNo) throws SQLException {
        return dao.getAccount(acctNo);
    }
    @Override
    public void UpdateBalance(String acctNo,double balance) throws SQLException{
         dao.UpdateBalance(acctNo,balance);
    }
    @Override
    public void deposit( String acctNo, double amount) throws SQLException {

        Account acc = dao.getAccount(acctNo);
        if (acc == null) {
            System.out.println("Account not found");
            return;
        }
        double currentBal = acc.getBalance();

        double newBal = currentBal + amount;

        dao.UpdateBalance(acc.getAcctNo(), newBal);

        tdao.addTransaction( (acctNo), null, amount, "DEPOSIT");

        System.out.println("Deposit Successful");
    }


    @Override
    public void withdraw(String acctNo, double amount) throws SQLException {

        Account acc = dao.getAccount((acctNo));
        if (acc == null) {
            System.out.println("Account not found");
            return;
        }
        double currentBal = acc.getBalance();

        if (currentBal >= amount) {

            double newBal = currentBal - amount;
            dao.UpdateBalance(acctNo, newBal);

            tdao.addTransaction(acctNo, null, amount, "WITHDRAW");

            System.out.println("Withdraw Successful");

        } else {
            System.out.println("Insufficient Balance");
        }
    }


    @Override
    public void transfer(String fromAcc, String  toAcc, double amount) throws SQLException {

        Account acc = dao.getAccount(String.valueOf(fromAcc));
        if (acc == null) {
            System.out.println("Account not found");
            return;
        }
        double currentBal = acc.getBalance();

        if (currentBal >= amount) {


            dao.UpdateBalance(fromAcc, currentBal - amount);


            Account toAccount = dao.getAccount(String.valueOf(toAcc));
            double toBal = toAccount.getBalance();

            dao.UpdateBalance(toAcc, toBal + amount);
            tdao.addTransaction(fromAcc, toAcc, amount, "TRANSFER");

            System.out.println("Transfer Successful");

        } else {
            System.out.println("Insufficient Balance");
        }
    }


    @Override
    public void transactionHistory(String  acctNo) throws SQLException {
        tdao.getTransactionHistory(acctNo);
    }
}