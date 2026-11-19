package org.example.Model;

public class Account {
    int id;

    String username;

    String password;

    float balance;

    boolean employee;


    public Account() {
    }

    public Account(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.balance = 0;
    }

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
        this.balance = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public boolean isEmployee() {
        return employee;
    }

    public void setEmployee(boolean employee) {
        this.employee = employee;
    }
}
