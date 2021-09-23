package banking_application;

import java.util.Scanner;

public class BankingApplication {
    public static void main(String[]args) {
        BankAccount object1 = new BankAccount("Mark Java", "ZIO875903");
        object1.showMenu();
    }
}

class BankAccount
{
    int balance;
    int previousTransaction;
    String customerName;
    String customerId;

    BankAccount(String cname, String cid)
    {
        customerName = cname;
        customerId = cid;
    }

    void deposit(int amount)
    {
        if(amount!=0){
            balance = balance+amount;
            previousTransaction = amount;
        }
    }

    void withdraw(int amount)
    {
        if(amount != 0 && amount < balance){
            balance = balance - amount;
            previousTransaction = -amount;
        }
        else
        {
            System.out.println("\n******************************");
            System.out.println("Insufficient Funds");
            System.out.println("******************************");
        }
    }

    void getPreviousTransaction()
    {
        if(previousTransaction >0)
        {
            System.out.println("Deposited: "+previousTransaction);
        }
        else if(previousTransaction<0)
        {
            System.out.println("Withdrawn: "+Math.abs(previousTransaction));
        }
        else
        {
            System.out.println("No transaction occcured");
        }

    }

    void showMenu()
    {
        char option = '\0';
        char option1 = '\0';
        Scanner scan = new Scanner(System.in);
        System.out.println("\n");
        System.out.println("*******************************");
        System.out.println("Welcome "+customerName);
        System.out.println("Your ID is: "+customerId);
        System.out.println("*******************************");
        System.out.println("\n");
        
        do
        {
            System.out.println("A. Check Balance");
            System.out.println("B. Deposit");
            System.out.println("C. Withdraw");
            System.out.println("D. Previous transaction");
            System.out.println("E. Exit");
            System.out.println("===============================");
            System.out.println("Enter an option");
            System.out.println("===============================");
            option1 = scan.next().charAt(0);
            option = Character.toUpperCase(option1);
            System.out.println("\n");

            switch(option)
            {
                case 'A' :
                    System.out.println("---------------------------------");
                    System.out.println("Balance = "+balance);
                    System.out.println("---------------------------------");
                    System.out.println("\n");
                    break;

                case 'B' :
                    System.out.println("---------------------------------");
                    System.out.println("Enter amount to deposit");
                    System.out.println("---------------------------------");
                    int damount = scan.nextInt();
                    deposit(damount);
                    System.out.println("\n");
                    break;
                
                case 'C' :
                    System.out.println("---------------------------------");
                    System.out.println("Enter amount to withdraw");
                    System.out.println("---------------------------------");
                    int wamount = scan.nextInt();
                    withdraw(wamount);
                    System.out.println("\n");
                    break;

                case 'D' :
                    System.out.println("---------------------------------");
                    getPreviousTransaction();
                    System.out.println("---------------------------------");
                    System.out.println("\n");
                    break;

                case 'E':
                    System.out.println("*********************************");
                    break;

                default:
                    System.out.println("Invalid Option! Please choose again");
                    break;
                
            }


        }while(option != 'E');

        System.out.println("Thank You for using our services");
        scan.close();
    }
}
