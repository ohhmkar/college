import java.util.Random;
import java.util.Scanner;

public class ATMTeller {
    public static void main(String args[]){
        try(Scanner in = new Scanner(System.in)){
            System.out.print("No of Accounts: ");
            int n = Integer.parseInt(in.nextLine().trim());

            SavingsAccount[] accounts = new SavingsAccount[n];
            for(int i = 0; i < n; i++){
                System.out.println();
                System.out.println("Enter details for Account " + (i + 1));
                System.out.print("Enter Name: ");
                String name = in.nextLine();

                System.out.print("Enter Balance: Rs. ");
                double balance = Double.parseDouble(in.nextLine().trim());

                System.out.print("Enter Interest Rate: ");
                double interestRate = Double.parseDouble(in.nextLine().trim());

                System.out.print("Enter Min Balance: Rs. ");
                double minBalance = Double.parseDouble(in.nextLine().trim());

                long accNo = generateAccountNumber();
                accounts[i] = new SavingsAccount(name, balance, accNo, interestRate, minBalance);
                System.out.println("Account created with Acc No.: " + accNo);
            }

            while(true){
                System.out.println();
                System.out.println("1. Display all accounts");
                System.out.println("2. Deposit");
                System.out.println("3. Withdraw");
                System.out.println("4. Transfer");
                System.out.println("5. Add Interest");
                System.out.println("6. Exit");
                System.out.print("Choose option: ");
                int choice = Integer.parseInt(in.nextLine().trim());

                switch(choice){
                    case 1 -> {
                        for(SavingsAccount account : accounts){
                            account.display();
                        }
                    }
                    case 2, 3, 4, 5 -> {
                        System.out.print("Enter Account Number: ");
                        long sourceAccNo = Long.parseLong(in.nextLine().trim());
                        SavingsAccount source = findAccount(accounts, sourceAccNo);

                        if(source == null){
                            System.out.println("Transaction Failed! Reason: Account not found.");
                            break;
                        }

                        try{
                            switch(choice){
                                case 2 -> {
                                    System.out.print("Enter Deposit Amount: Rs. ");
                                    double depositAmount = Double.parseDouble(in.nextLine().trim());
                                    source.deposit(depositAmount);
                                }
                                case 3 -> {
                                    System.out.print("Enter Withdrawal Amount: Rs. ");
                                    double withdrawalAmount = Double.parseDouble(in.nextLine().trim());
                                    source.withdraw(withdrawalAmount);
                                }
                                case 4 -> {
                                    System.out.print("Enter Destination Account Number: ");
                                    long destinationAccNo = Long.parseLong(in.nextLine().trim());
                                    SavingsAccount destination = findAccount(accounts, destinationAccNo);

                                    if(destination == null){
                                        System.out.println("Transaction Failed! Reason: Destination account not found.");
                                    }
                                    else{
                                        System.out.print("Enter Transfer Amount: Rs. ");
                                        double transferAmount = Double.parseDouble(in.nextLine().trim());
                                        source.transfer(destination, transferAmount);
                                    }
                                }
                                case 5 -> source.addInterest();
                                default -> {
                                }
                            }
                        }
                        catch(NegativeAmountException | InsufficientAmountException ex){
                            System.out.println("Transaction Failed! Reason: " + ex.getMessage());
                        }
                    }
                    case 6 -> {
                        System.out.println("Exiting banking system.");
                        return;
                    }
                    default -> System.out.println("Invalid option.");
                }
            }
        }
    }

    private static SavingsAccount findAccount(SavingsAccount[] accounts, long accNo){
        for(SavingsAccount account : accounts){
            if(account.accNo == accNo){
                return account;
            }
        }
        return null;
    }

    private static long generateAccountNumber(){
        Random rand = new Random();
        StringBuilder accNum = new StringBuilder();
        for(int i = 0; i < 14; i++){
            accNum.append(rand.nextInt(10));
        }
        return Long.parseLong(accNum.toString());
    }
}
