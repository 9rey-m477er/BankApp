package org.example;
import org.example.Controller.BankController;
import org.example.Model.Customer;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    private final Scanner sc = new Scanner(System.in);
    private final BankController bc = new BankController(sc);

    public static void main(String[] args) throws SQLException {
        new Main().start();
    }

    public void start() throws SQLException {
        boolean[] active = {true, false, false};
        while (active[0]) {
            System.out.println("Bank Application");
            System.out.println("1. New Customer Registration");
            System.out.println("2. Employee View");
            System.out.println("3. Customer Login");
            System.out.println("4. Exit");
            String input = sc.nextLine().trim();

            switch (input) {
                case "1":{ //Customer Registration Menu
                    bc.newCustomerHandler();
                break;
                }

                case "2":{ //Employee Menu
                    active[1] = true;
                    while(active[1]){
                        System.out.println("Employee View");
                        System.out.println("1. View Account Information");
                        System.out.println("2. View Pending Applications");
                        System.out.println("3. Exit");

                        String employeeInput = sc.nextLine().trim();
                        switch(employeeInput){
                            case "1":{ //View Account Info
                                bc.getAccountInformationHandler();
                                break;
                            }
                            case "2":{//Pending Applications
                                bc.PendingHandler();
                                break;
                            }
                            case "3": {//Exit
                                active[1] = false;
                                break;
                            }
                            default:{
                                System.out.println("Invalid Input");
                                break;
                            }
                        }
                    }
                    break;
                }
                case "3":{ //Customer Login
                    active[2] = true;
                    Customer c = bc.login();
                    while(active[2]){
                        System.out.println("Customer Service");
                        System.out.println("1. Open New Account");
                        System.out.println("2. Withdraw");
                        System.out.println("3. Deposit");
                        System.out.println("4. Transfer Funds Between Accounts");
                        System.out.println("5. Exit");

                        String customerInput = sc.nextLine().trim();
                        switch(customerInput){
                            case "1":{ //Open New Account
                                    bc.createAccountHandler(c);

                                break;
                            }
                            case "2":{//Withdraw
                                bc.withdrawHandler(c);
                                break;
                            }
                            case "3":{//Deposit
                                bc.depositHandler(c);
                                break;
                            }
                            case "4":{//Transfer Funds
                                bc.transferHandler(c);
                                break;
                            }
                            case "5": {//Exit
                                active[2] = false;
                                break;
                            }
                            default:{
                                System.out.println("Invalid Input");
                                break;
                            }
                        }

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
