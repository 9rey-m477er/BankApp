package org.example.Controller;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import org.example.DAO.AccountDAO;
import org.example.DAO.CustomerDAO;
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

    public void createAccountHandler(Customer c) {
        System.out.printf("Enter Account name:");
        String name = sc.nextLine().trim();
        System.out.println("Enter Account type: ");
        System.out.println("1. Checking ");
        System.out.println("2. Savings ");
        String input = sc.nextLine().trim();
        String type = "";
        switch (input){
            case "2": type = "SAVINGS"; break;
            default: type = "CHECKING"; break;
        }
        try{
            Account a = as.createAccount(name, type, c.getId());
            System.out.println("Account created");
            //System.out.printf(a.toString());
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public void newCustomerHandler(){
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

    public Customer login(){
        System.out.printf("Enter username:");
        String name = sc.nextLine().trim();
        System.out.printf("Enter password:");
        String password = sc.nextLine().trim();

        try{
            Customer c = cs.login(name, password);
            if(c == null){
                System.out.println("Login failed");
                return null;
            }
            System.out.println("Login successful");
            return c;

        }catch(SQLException e){
            System.out.printf(e.getMessage());
        }
        return null;
    }

    public void getAccountInformationHandler() throws SQLException {
        System.out.println("Enter Account ID: ");
        String target = sc.nextLine();
        int targetID = Integer.parseInt(target);
        System.out.println(as.getInfo(targetID));
    }

    public boolean withdrawHandler(Customer c) throws SQLException {
        System.out.println("Enter an amount: ");
        String input = sc.nextLine();
        float amount = Float.parseFloat(input);
        return as.withdraw(accountChoice(c), amount);
    }
    public boolean depositHandler(Customer c) throws SQLException {
        System.out.println("Enter an amount: ");
        String input = sc.nextLine();
        float amount = Float.parseFloat(input);
        return as.deposit(accountChoice(c),amount);
    }
    public boolean transferHandler(Customer c) throws SQLException {
        System.out.println("Enter an amount: ");
        String input = sc.nextLine();
        float amount = Float.parseFloat(input);
        return as.withdraw(accountChoice(c),amount);
    }

    public List<Account> customerAccountsHandler(Customer c) throws SQLException {
        return as.getCustomerAccounts(c.getId());
    }

    public Account accountChoice(Customer c) throws SQLException {
        List<Account> cList = as.getCustomerAccounts(c.getId());
        if(cList.isEmpty()){
            System.out.println("You have no accounts");
            return null;
        }
        int index = 1;
        for(Account a: cList){
            System.out.println(index+". " + a.toString());
            index++;
        }
        System.out.println(index +". Cancel");
        String input = sc.nextLine().trim();
        int choice = Integer.parseInt(input);
        if(choice == index){
            return null;
        }
        return cList.get(choice - 1);
    }
    public void PendingHandler() throws SQLException {
        List<Account> p = as.getPendingAccounts();
        if(p.size() <= 0){
            System.out.println("No pending accounts.");
            //return null;
        }
        else{
            for(Account a: p){
                System.out.println(a.toString());
                System.out.println("1. Approve");
                System.out.println("2. Deny");
                String input = sc.nextLine().trim();
                switch(input){
                    case "1": as.approveStatus(a.getId()); break;
                    case "2": as.denyStatus(a.getId()); break;
                    default:
                        System.out.println("Invalid input, skipping current account");
                }
            }
        }

    }
}
