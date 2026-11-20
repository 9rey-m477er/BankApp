package org.example.Service;
import java.sql.SQLException;
import java.util.List;

import org.example.DAO.AccountDAO;
import org.example.Model.Account;
import org.example.Model.Customer;

public class AccountService{
    private AccountDAO acDAO;

    public AccountService(){
        acDAO = new AccountDAO();
    }

    public Account addAccount(Account account, Customer c) throws SQLException {
        if(account.getUsername().equals("")){
            return null;
        }
        return acDAO.addAccount(account, c.getId());
    }

    public Account createAccount(String name, String type, int cID) throws SQLException{
        Account a = new Account(name, type);
        int id = acDAO.addAccount(a,cID).getId();
        return acDAO.getAccountByID(id);
    }
    public boolean deposit(Account a, float amount) throws SQLException {
        if(amount <= 0){
            return false;
        }
        else{
            a.setBalance(a.getBalance() + amount);
        }
        return acDAO.updateBalance(a.getId(), a.getBalance());
    }
    public boolean withdraw(Account a, float amount) throws SQLException {
        if(amount > a.getBalance() && amount > 0){
            return false;
        }
        else{
            a.setBalance(a.getBalance() - amount);
        }
        return acDAO.updateBalance(a.getId(), a.getBalance());
    }

    public String getInfo(int id) throws SQLException {
        return acDAO.accountInformation(id);
    }

    public List<Account> getCustomerAccounts(int cID) throws SQLException {
        return acDAO.getAccountsByCustomerID(cID);
    }
    public List<Account> getPendingAccounts() throws SQLException {
        return acDAO.getAccountsByStatus("PENDING");
    }

    public boolean approveStatus(int id) throws SQLException {
        return acDAO.approve(id);
    }
    public boolean denyStatus(int id) throws SQLException {
        return acDAO.deny(id);
    }
    public Account getAccountByID(int id) throws SQLException {
        return acDAO.getAccountByID(id);
    }

}