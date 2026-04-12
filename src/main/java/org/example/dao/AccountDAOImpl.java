package org.example.dao;


import org.example.model.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;


import static org.example.util.DbConnection.getConnection;


public class AccountDAOImpl implements AccountDAO {

    @Override
    public void  createAccount(Account account) throws SQLException{
        try {
            String sql = "insert into account(acctNo,name,email,phone,city,balance) values(?,?,?,?,?,?)";
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, account.getAcctNo());
            preparedStatement.setString(2, account.getName());
            preparedStatement.setString(3, account.getEmail());
            preparedStatement.setString(4, account.getPhone());
            preparedStatement.setString(5, account.getCity());
            preparedStatement.setDouble(6, account.getBalance());

            preparedStatement.execute();
            System.out.println("Account Done");
        } catch (Exception ex) {

        }
    }

    @Override
    public void UpdateBalance(int id , double balance) throws SQLException {
        String sql = "update  account set balance =? where id = ?";
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setDouble(1, balance);
        preparedStatement.setInt(2, id);
        int count = preparedStatement.executeUpdate();
        System.out.println("Update Successfullu : " + count);
    }
    @Override
    public void getAccount(String acctNo) throws SQLException {
        String sql = "select * from account where acctNo = ?";
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, acctNo);

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            System.out.println(
                    resultSet.getInt("id") + " | " +
                            resultSet.getString("acctNo") + " | " +
                            resultSet.getString("name") + " | " +
                            resultSet.getString("city") + " | " +
                            resultSet.getString("phone") + " | " +
                            resultSet.getString("email") + " | " +
                            resultSet.getDouble("balance")
            );
        }
    }
}