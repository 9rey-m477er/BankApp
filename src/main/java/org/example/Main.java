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
                    bc.newCustomer();
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
                            case "1":{
                                System.out.println("Enter Account ID: ");
                                int targetID = sc.nextInt();

                                break;
                            }
                            case "2":{
                                break;
                            }
                            case "3": {
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
                    while(active[2]){
                        bc.login();
                        active[2] = false;
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
