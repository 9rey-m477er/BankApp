package org.example.DAO;

import org.example.Model.Account;
import org.example.Model.Customer;
import org.example.Util.DatabaseConnection;

import java.sql.*;

public class CustomerDAO {
    public Customer addCustomer(Customer c) throws SQLException {
        Connection connection = DatabaseConnection.getConnection();
        try{
            String sql = "INSERT INTO customers (name, password) VALUES (?,?)";
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, c.getName());
            ps.setString(2,c.getPassword());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()){
                int generated_customer_id = (int) rs.getLong(1);
                return new Customer(generated_customer_id, c.getName(), c.getPassword());
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
