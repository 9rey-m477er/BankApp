package org.example.Service;
import java.sql.Connection;
import java.sql.SQLException;

import org.example.DAO.AccountDAO;
import org.example.Model.Account;
import org.example.Util.DatabaseConnection;

public class AccountService{
    private AccountDAO acDAO;

    public AccountService(){
        acDAO = new AccountDAO();
    }

    public Account login(String user, String password) throws SQLException {
        return acDAO.login(user, password);
    }

    public Account addAccount(Account account) throws SQLException {
        if(account.getUsername().equals("")){
            return null;
        }
        return acDAO.addAccount(account);
    }

    public Account createAccount(String name) throws SQLException{
        Account a = new Account(name);
        int id = acDAO.addAccount(a).getId();
        return a;
    }
}