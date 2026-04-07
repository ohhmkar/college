import java.io.*;
/**
 * Main Class, implements bubble sort in this file
 * @author Omkar Anil Gajare
 * @version 1/4/26
 */
public class BankingInterface {
    /** Executes the full banking workflow from input to final summaries. */
    public static void main(String args[]) throws IOException {
        DataInputStream in = new DataInputStream(System.in);
        System.out.println("Enter number of customers: ");
        int noOfCustomers = Integer.parseInt(in.readLine());
        Customer[] c = new Customer[noOfCustomers];

        for (int i = 1; i <= noOfCustomers; i++) {
            String name, acType;
            float interestRate, balance;
            System.out.printf("Enter details for customer %d: \n", i);
            System.out.println("Name: ");
            name = in.readLine();
            System.out.println("Account Type " + ((i % 2 == 0) ? "(Current): " : "(Savings/Current): "));
            acType = in.readLine();
            System.out.println("Interest Rate: ");
            interestRate = Float.parseFloat(in.readLine());
            System.out.println("Balance: Rs.");
            balance = Float.parseFloat(in.readLine());

            c[i - 1] = new Customer(name, acType, interestRate, balance);
            c[i - 1].accountType = (acType.equalsIgnoreCase("saving") || acType.equalsIgnoreCase("savings")) ? "Saving"
                    : "Current";
            c[i - 1].interestRate = interestRate;
            c[i - 1].balance = balance;
            System.out.println();
        }

        for (int i = 0; i < noOfCustomers; i++) {
            System.out.printf("Name: %s, %s = %.1f, Updated Balance = %.1f",
                    c[i].acHolder,
                    ((c[i].accountType.equals("Saving")) ? "Simple Interest" : "Compound Interest"),
                    ((c[i].accountType.equals("Saving")) ? c[i].getSimpleInterest() : c[i].getCompoundInterest()),
                    c[i].balance);
            System.out.println();
        }

        System.out.println("\nUpdated Balances:");
        for (int i = 0; i < noOfCustomers; i++) {
            System.out.printf("Name: %s, Account Type: %s,Balance = %.1f",
                    c[i].acHolder,
                    c[i].accountType,
                    c[i].balance);
            System.out.println();
        }

        BankingInterface bi = new BankingInterface();
        bi.bsort(c);

        System.out.println("\nAfter sorting by balance:\n");
        for (int i = 0; i < noOfCustomers; i++) {
            System.out.printf("Name: %s, Account Type: %s, Balance: %.1f",
                    c[i].acHolder,
                    c[i].accountType,
                    c[i].balance);
            System.out.println("\n");
        }

        String highestSavingName = "";
        String lowestCurrentName = "";
        float highestSavingBalance = -1;
        float lowestCurrentBalance = Float.MAX_VALUE;

        for (int i = 0; i < noOfCustomers; i++) {
            if (c[i].accountType.equals("Saving") && c[i].balance > highestSavingBalance) {
                highestSavingBalance = c[i].balance;
                highestSavingName = c[i].acHolder;
            }
            if (c[i].accountType.equals("Current") && c[i].balance < lowestCurrentBalance) {
                lowestCurrentBalance = c[i].balance;
                lowestCurrentName = c[i].acHolder;
            }
        }

        if (highestSavingName.length() > 0) {
            System.out.printf("Highest Balance in Saving Account: %s - Balance = %.2f", highestSavingName,
                    highestSavingBalance);
            System.out.println();
        }

        if (lowestCurrentName.length() > 0) {
            System.out.printf("Lowest Balance in Current Account: %s - Balance = %.2f", lowestCurrentName,
                    lowestCurrentBalance);
            System.out.println();
        }

    }

    /** Sorts customers in ascending order of balance using bubble sort. */
    void bsort(Customer[] c) {
        int n = c.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (c[j].balance > c[j + 1].balance) {
                    Customer temp = c[j];
                    c[j] = c[j + 1];
                    c[j + 1] = temp;
                }
            }
        }
    }
}
