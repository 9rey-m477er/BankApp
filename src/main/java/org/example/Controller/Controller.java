package org.example.Controller;
import java.util.Scanner;
import org.example.Service.*;
import org.example.DAO.*;
import java.sql.SQLException;

public class Controller {
    private final AccountService as = new AccountService();
    private Scanner sc;

    public Controller(Scanner sc){
        this.sc = sc;
    }
    
}
