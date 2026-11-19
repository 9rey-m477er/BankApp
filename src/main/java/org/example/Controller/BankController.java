package org.example.Controller;
import java.sql.SQLException;
import java.util.Scanner;

import org.example.DAO.AccountDAO;
import org.example.Model.Account;
import org.example.Service.*;

public class BankController {
    private final AccountService as = new AccountService();
    private final CustomerService cs = new CustomerService();
    private Scanner sc;

    public BankController(Scanner sc){
        this.sc = sc;
    }

    public void handleCreateAccount() {
        System.out.printf("Enter Account name:");
        String name = sc.nextLine().trim();
        System.out.printf("Enter new password:");
        String password = sc.nextLine().trim();
        try{
            Account a = as.createAccount(name, password);
            System.out.printf("Account created");
            System.out.printf(a.toString());
        }catch(SQLException e){
            System.out.printf(e.getMessage());
        }
    }
}
