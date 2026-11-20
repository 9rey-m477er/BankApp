package org.example.Controller;
import java.sql.SQLException;
import java.util.Scanner;

import org.example.DAO.AccountDAO;
import org.example.Model.Account;
import org.example.Model.Customer;
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
            Account a = as.createAccount(name);
            System.out.println("Account created");
            //System.out.printf(a.toString());
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public void newCustomer(){
        System.out.printf("Enter customer name: ");
        String name = sc.nextLine().trim();
        System.out.printf("Enter new password: ");
        String password = sc.nextLine().trim();
        try{
            Customer c = cs.createCustomer(name, password);
            System.out.println("Customer created");
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void login(){
        System.out.printf("Enter username:");
        String name = sc.nextLine().trim();
        System.out.printf("Enter password:");
        String password = sc.nextLine().trim();

        try{
            Account a = as.login(name, password);
            System.out.printf("Account created");
            System.out.printf(a.toString());
        }catch(SQLException e){
            System.out.printf(e.getMessage());
        }
    }
}
