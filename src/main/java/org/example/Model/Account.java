package org.example.Model;

public class Account {
    int id;

    String username;

    float balance;

    String status;

    boolean employee;


    public Account() {
    }

    public Account(int id, String username) {
        this.id = id;
        this.username = username;
        this.status = "Pending";
        this.balance = 0;
    }

    public Account(String username) {
        this.username = username;
        this.status = "Pending";
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
