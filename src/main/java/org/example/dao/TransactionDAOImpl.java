package org.example.dao;

import org.example.util.DbConnection;

import java.sql.*;

public  class TransactionDAOImpl implements TransactionDAO{
    @Override
    public void addTransaction(String  fromAcc, String  toAcc, double amount,
                               String type) throws SQLException {
        Connection connection = DbConnection.getConnection();
        String sql = "INSERT INTO transactions(from_acc,to_acc,amount,type) " +
                "VALUES(?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString (1, fromAcc);


            preparedStatement.setString (2, toAcc);


        preparedStatement.setDouble(3, amount);
        preparedStatement.setString(4, type);
        preparedStatement.execute();
        System.out.println("Transaction Completed");
    }
    @Override
    public void getTransactionHistory(String  acctNo) throws SQLException {
        Connection connection = DbConnection.getConnection();
        String sql = "SELECT * FROM  transactions WHERE from_acc = ? " +
                "OR to_acc = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString (1, acctNo);
        preparedStatement.setString (2, acctNo);
      ResultSet rs =  preparedStatement.executeQuery();
      System.out.println("Transaction History");
      while (rs.next()) {

          System.out.println("ID:"+ rs.getInt("id"));
          System.out.println("Type:"+ rs.getString("type"));
          System.out.println("Amount:"+ rs.getDouble("amount"));
          System.out.println("from_acc:"+ rs.getInt("from_acc"));
          System.out.println("to_acc:"+ rs.getInt("to_acc"));

      }
    }
        }



