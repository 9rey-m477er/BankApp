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

    public Account login(Account ac) throws SQLException {
        return acDAO.login(ac.getUsername(), ac.getPassword());
    }

    public Account addAccount(Account account) throws SQLException {
        if(account.getUsername().equals("") || account.getPassword().length() < 4){
            return null;
        }
        return acDAO.addAccount(account);
    }
}