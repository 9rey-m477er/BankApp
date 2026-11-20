package org.example.Service;

import org.example.DAO.CustomerDAO;
import org.example.Model.Customer;

import java.sql.SQLException;

public class CustomerService {
    private CustomerDAO cDAO;

    public CustomerService(){
        cDAO = new CustomerDAO();
    }

    public Customer createCustomer(String name, String password) throws SQLException {
        Customer c = new Customer(name, password);
        int id = cDAO.addCustomer(c).getId();
        return c;
    }

    public Customer login(String user, String password) throws SQLException {
        return cDAO.login(user, password);
    }
}
