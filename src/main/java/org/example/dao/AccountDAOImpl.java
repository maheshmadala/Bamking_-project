package org.example.dao;

import org.example.model.Account;
import org.example.util.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class AccountDAOImpl implements AccountDAO {

    @Override
    public void CreateAccount(Account account) throws SQLException {

        String sql = "insert into account(acctNo,name,email,phone,city,balance) values(?,?,?,?,?,?)";

        Connection connection = DbConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, account.getAcctNo());
        preparedStatement.setString(2, account.getName());
        preparedStatement.setString(3, account.getEmail());
        preparedStatement.setString(4, account.getPhone());
        preparedStatement.setString(5, account.getCity());
        preparedStatement.setDouble(6, account.getBalance());

        preparedStatement.executeUpdate();
        System.out.println("Account Created Successfully");
    }

    @Override
    public void UpdateBalance(int id, double balance) throws SQLException {

        String sql = "update account set balance = ? where id = ?";

        Connection connection = DbConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setDouble(1, balance);
        preparedStatement.setInt(2, id);

        int count = preparedStatement.executeUpdate();
        System.out.println("Updated Rows: " + count);
    }

    @Override
    public Account getAccount(String acctNo) throws SQLException {

        String sql = "select * from account where acctNo = ?";

        Connection connection = DbConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, acctNo);

        ResultSet resultSet = preparedStatement.executeQuery();

        Account account = null;

        if (resultSet.next()) {
            account = new Account();

            account.setId(resultSet.getInt("id"));
            account.setAcctNo(resultSet.getString("acctNo"));
            account.setName(resultSet.getString("name"));
            account.setCity(resultSet.getString("city"));
            account.setPhone(resultSet.getString("phone"));
            account.setEmail(resultSet.getString("email"));
            account.setBalance(resultSet.getDouble("balance"));
        }

        return account;
    }
}