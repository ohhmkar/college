
/**
 * Simple Bank Account Management System
 *
 * @author Omkar Anil Gajare
 * @version 25/2/26
 */
public class BankAccount
{
    //Instance Variables    
    long accountNumber;
    String name;
    boolean accountType; //true for Savings and false for Current
    int balance;
    //Parametarized Constructor
    BankAccount(long acn, String name, boolean at, int bal){
        accountNumber = acn;
        this.name = name;
        accountType = at;
        balance = bal;
    }
    /**
     * Method to deposit money into the account
     * Param: deposit amount
     */
    void depositMoney(int depositAmount){
            balance += depositAmount;
            System.out.println("Account Number: "+accountNumber);
            System.out.println("Amount deposited: $"+depositAmount);
            System.out.println("Updated balance: $"+balance);
            System.out.println();
    }
    /**
     * Method to withdraw money into the account
     * Param: withdrawl amount
     */ 
    void withdrawMoney(int withdrawAmount){
        if(withdrawAmount > balance){
            System.out.println("Insufficient Balance");
            return;
        }
        else if(withdrawAmount<0){
            System.out.println("Deposit amount should be positive!");
            return;
        }
        else{
            balance -= withdrawAmount;
            System.out.println("Account Number: "+accountNumber);
            System.out.println("Amount withdrawn: $"+withdrawAmount);
            System.out.println("Updated balance: $"+balance);
        }
        System.out.println();
    }
    /**
     * Method to display bank account details
     */ 
    void displayDetails(){
        System.out.println("Account Number: "+accountNumber);
        System.out.println("Account Holder: "+name);
        System.out.println("Account Type: "+(accountType? "Savings":"Current"));
        System.out.println();
    }
}