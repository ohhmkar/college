
/**
 * This program handles the bank account transactions of 2 accounts
 *
 * @author Omkar Anil Gajare
 * @version 25/2/26
 */
public class BankAccountTest
{
    public static void main(String args[]){
        BankAccount ba1 = new BankAccount(1234,"Omkar",true,10000);
        BankAccount ba2 = new BankAccount(5678,"Anil",false,20000);
        
        ba1.withdrawMoney(5000);
        ba1.depositMoney(10000);
        ba2.depositMoney(50000);
        ba2.withdrawMoney(100000);
        ba2.withdrawMoney(15000);
        
        ba1.displayDetails();
        ba2.displayDetails();
    }
}