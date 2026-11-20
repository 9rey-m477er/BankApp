package org.example.DAO;
import org.example.Model.Account;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.example.Util.DatabaseConnection;

public class AccountDAO {
    public Account addAccount(Account account, int cID) throws SQLException {
        Connection connection = DatabaseConnection.getConnection();
        try{
            String sql = "INSERT INTO Account (username, type) VALUES (?,?)";
            String joined = "INSERT INTO account_holders (customer_id, account_id) VALUES (?,?)";
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, account.getUsername());
            ps.setString(2, account.getType());

            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()){
                int generated_account_id = (int) rs.getLong(1);
                PreparedStatement ps2 = connection.prepareStatement(joined, Statement.RETURN_GENERATED_KEYS);
                ps2.setInt(1,cID);
                ps2.setInt(2,generated_account_id);
                ps2.executeUpdate();
                return new Account(generated_account_id, account.getUsername(), account.getType());
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public Account getAccountByID(int id) throws SQLException {
        Connection connection = DatabaseConnection.getConnection();
        try{
            String sql = "Select * FROM Account where (id) = (?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                Account ac = new Account(rs.getInt("id"), rs.getString("username"), rs.getString("status"), rs.getFloat("balance"), rs.getString("type"));
                return ac;
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    public boolean updateBalance(int id, float balance) throws SQLException {
        Connection connection = DatabaseConnection.getConnection();
        try{
            String sql = "UPDATE ACCOUNT set balance = (?) where (id) = (?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setFloat(1, balance);
            ps.setInt(2,id);
            return (ps.executeUpdate() > 0);
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    public String accountInformation(int id) throws SQLException {
        Connection connection = DatabaseConnection.getConnection();
        try{
            String sql = "Select * FROM account where (id) = (?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                Account ac = new Account(rs.getInt("id"), rs.getString("username"), rs.getString("status"), rs.getFloat("balance"), rs.getString("type"));
                return ac.toString();
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    public List<Account> getAccountsByCustomerID(int cID) throws SQLException {
        Connection connection = DatabaseConnection.getConnection();
        List<Account> accounts = new ArrayList<>();
        try{
            String sql = "SELECT a.id, a.username, a.type, a.balance, a.status "
                    + "FROM account a "
                    + "JOIN account_holders ah ON a.id = ah.account_id "
                    + "WHERE ah.customer_id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,cID);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Account ac = new Account(rs.getInt("id"), rs.getString("username"), rs.getString("status"), rs.getFloat("balance"), rs.getString("type"));
                accounts.add(ac);
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return accounts;
    }

    public List<Account> getAccountsByStatus(String status) throws SQLException {
        Connection connection = DatabaseConnection.getConnection();
        List<Account> accounts = new ArrayList<>();
        try{
            String sql = "SELECT a.id, a.username, a.type, a.balance, a.status "
                    + "FROM account a "
                    + "JOIN account_holders ah ON a.id = ah.account_id "
                    + "WHERE status = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,status);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Account ac = new Account(rs.getInt("id"), rs.getString("username"), rs.getString("status"), rs.getFloat("balance"), rs.getString("type"));
                accounts.add(ac);
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return accounts;
    }

    public boolean updateStatus(int id, String status) throws SQLException {
        Connection connection = DatabaseConnection.getConnection();
        try{
            String sql = "UPDATE ACCOUNT set status = (?) where (id) = (?) and status = 'PENDING'";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, status);
            ps.setInt(2,id);
            return (ps.executeUpdate() > 0);
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return false;
    }
    public boolean approve(int id) throws SQLException {
        String status = "APPROVED";
        return updateStatus(id, status);
    }

    public boolean deny(int id) throws SQLException {
        String status = "DENIED";
        return updateStatus(id, status);
    }
}
