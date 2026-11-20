package org.example.Model;

public class Account {
    int id;

    String username;

    float balance;

    String status;

    String type;

    public Account() {
    }

    public Account(int id, String username, String type) {
        this.id = id;
        this.username = username;
        this.status = "PENDING";
        this.balance = 0;
        this.type = type;
    }

    public Account(int id, String username, String status, float balance, String type) {
        this.id = id;
        this.username = username;
        this.status = status;
        this.balance = balance;
        this.type = type;
    }

    public Account(String username, String status, float balance, String type) {
        this.username = username;
        this.status = status;
        this.balance = balance;
        this.type = type;
    }

    public Account(String username, String type) {
        this.username = username;
        this.status = "PENDING";
        this.balance = 0;
        this.type = type;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", balance=" + balance +
                ", status='" + status + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
