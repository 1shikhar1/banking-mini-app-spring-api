package com.monocept.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import com.monocept.model.Account;
import com.monocept.model.Transaction;
import com.monocept.service.AccountService;

public class AccountRepository {
	private static AccountRepository instance = null;
	
	private AccountRepository() {
		
	}
	
	public static AccountRepository getInstance() {
		if (instance == null)
			instance = new AccountRepository();
		return instance;
	}
	
	public Connection connectDB() {
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/bank?" + "user=root&password=root");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 
		return conn;
	}
	
	
	public void addAccount(Account account) throws SQLException {
	    Connection conn = null;
	    conn = connectDB();
	    
	    
	    String query = "INSERT INTO accounts values(\""+account.getName()+"\","+account.getBalance()+",\""+account.getPassword()+"\");";
	    
	    
	    System.out.println(query);
	    
	    PreparedStatement p = conn.prepareStatement(query);
	    System.out.println("no of rows: "+p.executeUpdate());
	 
		conn.close();
	}
	
	public void addTransaction(Transaction transaction) throws SQLException {
	    Connection conn = null;
	    conn = connectDB();
	    
	    
	    String query = "INSERT INTO transactions values(\""+transaction.getName()+"\","+transaction.getAmount()+",\""+transaction.getType()+"\",\""+transaction.getTime()+"\")";
	    
	    
	    System.out.println(query);
	    
	    PreparedStatement p = conn.prepareStatement(query);
	    System.out.println("no of rows: "+p.executeUpdate());
	 
		conn.close();
	}
	
	public List<Transaction> getTransactions(String userName) throws SQLException{
		List<Transaction> transactions = new ArrayList<>();
		
	    Connection conn = null;
	    conn = connectDB();
	    
	    String sql = "select * from transactions where name=\""+userName+"\"";
	    System.out.println(sql);
	    PreparedStatement p = conn.prepareStatement(sql);
	    ResultSet rs = p.executeQuery();
	    
	    while (rs.next()) {

            String name = rs.getString("name");
            double amount = rs.getDouble("amount");
            String type = rs.getString("type");
            Timestamp time = Timestamp.valueOf(rs.getString("time"));
            
            transactions.add(new Transaction(name,amount,type,time));
	    }
	    return transactions;
	}
	
	public List<Account> getAccounts() throws SQLException{
		List<Account> accounts = new ArrayList<>();
		
	    Connection conn = null;
	    conn = connectDB();
	    
	    String sql = "select * from accounts";
	    System.out.println(sql);
	    PreparedStatement p = conn.prepareStatement(sql);
	    ResultSet rs = p.executeQuery();
	    
	    while (rs.next()) {

            String name = rs.getString("name");
            double balance = rs.getDouble("balance");
            String password = rs.getString("password");
            
            accounts.add(new Account(name,balance,password));
	    }
	    return accounts;
	}
	
	public Account findAccount(String name) throws SQLException {
		Account account = null;
	    Connection conn = null;
	    conn = connectDB();
	    
	    String sql = "select * from accounts where name=\""+name+"\"";
	    
	    System.out.println(sql);
	    PreparedStatement p = conn.prepareStatement(sql);
	    ResultSet rs = p.executeQuery();
	    
	    while (rs.next()) {
    	
            String name2 = rs.getString("name");
            double amount = rs.getDouble("balance");
            String type = rs.getString("password");
            
            account = new Account(name2,amount,type);
	    }
	    
	    return account;
	}
	
	public void updateBalance(String name, double balance) throws SQLException {
	    Connection conn = null;
	    conn = connectDB();
	    
	    String query = "Update accounts SET balance = "+balance+" where name = \""+name+"\"";
	    
	    System.out.println(query);
	    
	    PreparedStatement p = conn.prepareStatement(query);
	    System.out.println("no of rows: "+p.executeUpdate());
	 
		conn.close();
	}
	
}
