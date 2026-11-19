package org.example.DAO;
import org.example.Model.Account;
import java.sql.*;

import org.example.Util.DatabaseConnection;

import javax.xml.crypto.Data;

public class AccountDAO {
    public Account addAccount(Account account) throws SQLException {
        Connection connection = DatabaseConnection.getConnection();
        try{
            String sql = "INSERT INTO Account (username, password) VALUES (?,?)";
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, account.getUsername());
            ps.setString(2, account.getPassword());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()){
                int generated_account_id = (int) rs.getLong(1);
                return new Account(generated_account_id, account.getUsername(), account.getPassword());
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    public Account login(String username, String password) throws SQLException {
        Connection connection = DatabaseConnection.getConnection();
        try{
            String sql = "Select * FROM Account where (username) = (?) and (password) = (?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                Account ac = new Account(rs.getInt("account_id"), rs.getString("username"), rs.getString("password"));
                return ac;
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }
    public Account getAccountByID(int id) throws SQLException {
        Connection connection = DatabaseConnection.getConnection();
        try{
            String sql = "Select * FROM Account where (account_id) = (?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                Account ac = new Account(rs.getInt("account_id"), rs.getString("username"), rs.getString("password"));
                return ac;
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

}
