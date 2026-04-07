/**
 * Stores customer account details and provides interest calculations.
 *
 * @author Omkar Anil Gajare
 * @version 1/4/26
 */
public class Customer implements SavingAccount, CurrentAccount {
    String acHolder;
    String accountType;
    float interestRate;
    float balance;

    /** Creates an empty customer record. */
    Customer() {
    }
    
    /** Creates a customer with account metadata and starting balance values. */
    Customer(String acHolder, String acType, float interestRate, float balance) {
        // Core account details are initialized once during customer creation.
        this.acHolder = acHolder;
        // Normalize user input to one of the two expected account categories.
        accountType = (acType.toLowerCase() == "saving" ? "Saving" : "Current");
        interestRate = this.interestRate;
        balance = this.balance;
    }

    @Override
    public float getSimpleInterest() {
        // Simple interest updates balance by one period using rate percentage.
        float si = balance * (interestRate / 100);
        balance += balance * (interestRate) / 100;
        // Return only the computed interest component for display logic.
        return si;
    }

    @Override
    public float getCompoundInterest() {
        // Compound path computes growth factor first, then accumulates it.
        float ci = balance * (1 + (interestRate / 100)) - balance;
        balance += ci;
        // Caller receives the computed compound amount used in reporting.
        return ci;
    }
}
