package org.example;
import org.example.Controller.BankController;
import java.util.Scanner;

public class Main {
    private final Scanner sc = new Scanner(System.in);
    private final BankController bc = new BankController(sc);

    public static void main(String[] args) {
        new Main().start();
    }

    public void start() {
        boolean[] active = {true, false, false};
        while (active[0]) {
            System.out.println("Bank Application");
            System.out.println("1. Customer Registration");
            System.out.println("2. Employee View");
            System.out.println("3. Customer Login");
            System.out.println("4. Exit");
            String input = sc.nextLine().trim();

            switch (input) {
                case "1":{ //Customer Registration Menu

                    /*System.out.println("Enter a username: ");
                    String username = sc.nextLine().trim();
                    System.out.println("Enter a password: ");
                    String password = sc.nextLine().trim();*/
                    bc.handleCreateAccount();
                break;
                }

                case "2":{ //Customer Registration Menu
                    active[1] = true;
                    while(active[1]){

                    }
                    break;
                }
                case "3":{ //Employee Menu
                    active[2] = true;
                    while(active[2]){

                    }
                    break;
                }

                case "4":{ //Exit
                active[0] = false;
                break;
                }

                default: System.out.printf("Invalid selection. Try again");
            }
        }
    }
}
