#include <stdio.h>
#include <stdlib.h>
/**
 * @brief Bank Account Management System
 * @author Omkar Anil Gajare
 * @date 15-12-2025
 */

// Structure to represent an address
/**
 * @struct Address
 */
struct Address
{
    char city[50];
    char state[50];
    int pincode;
};

// Structure to represent a bank account
/**
 * @struct BankAddress
 */
struct BankAccount
{
    int account_no;
    char name[50];
    float balance;
    struct Address Address;
};
/*Function Prototypes*/
void createAccount(struct BankAccount *b);
void deposit(struct BankAccount *b, float amt);
void withdraw(struct BankAccount *b, float amt);
void transfer(struct BankAccount *from, struct BankAccount *to, float amt);
void displayAccount(struct BankAccount b);
void searchAccount(struct BankAccount b[], int n, int acc_no);
int findAccount(struct BankAccount b[], int n, int acc_no);
/**
 * @brief Creates a new bank account by prompting user for account details
 * @param b Pointer to the BankAccount structure to initialize with user input
 * @returns void
 * @author Omkar Anil Gajare
 * @date 15-12-2025
 */
void createAccount(struct BankAccount *b)
{
    // Prompt user for account number
    printf("Enter Account No.: ");
    scanf("%d", &b->account_no);
    // Prompt user for name
    printf("Enter Name: ");
    scanf("%s", b->name);
    // Prompt user for address details (city, state, pincode)
    printf("Enter City, State and Pincode: ");
    scanf("%s %s %d", b->Address.city, b->Address.state, &b->Address.pincode);
    // Initilize bank balance to 0
    b->balance = 0.0f;
    // Display success message
    printf("Account Created Succesfully!");
}
/**
 * @brief Deposits a specified amount into the bank account if the amount is valid
 * @param b Pointer to the BankAccount structure
 * @param amt Amount to deposit (must be positive)
 * @returns void
 * @author Omkar Anil Gajare
 * @date 15-12-2025
 */
void deposit(struct BankAccount *b, float amt)
{
    // Check if deposit amount is valid (must be positive)
    if (amt <= 0)
    {
        printf("Deposit amount can't be negative or zero!");
        return;
    }
    else
    {
        // Add the amount to the account balance
        b->balance += amt;
        // Display deposit confirmation with new balance
        printf("Deposited: %.2f, New Balance: %.2f", amt, b->balance);
    }
}
/**
 * @brief Withdraws a specified amount from the bank account if sufficient balance exists
 * @param b Pointer to the BankAccount structure
 * @param amt Amount to withdraw (must be positive and <= balance)
 * @returns void
 * @author Omkar Anil Gajare
 * @date 15-12-2025
 */
void withdraw(struct BankAccount *b, float amt)
{
    // Check if withdrawal amount is valid (must be positive)
    if (amt <= 0)
    {
        printf("Withdrawl amount can't be negative or zero!");
        return;
    }
    // Check if sufficient balance exists for withdrawal
    if (amt > b->balance)
    {
        printf("Withdrawl amount can't be or more than current balance");
        return;
    }
    else
    {
        // Deduct the amount from the account balance
        b->balance -= amt;
        // Display withdrawal confirmation with new balance
        printf("Withdrew: %.2f, New Balance: %.2f", amt, b->balance);
    }
}
/**
 * @brief Transfers a specified amount from one account to another if possible
 * @param from Pointer to the source BankAccount structure
 * @param to Pointer to the destination BankAccount structure
 * @param amt Amount to transfer (must be positive and <= source balance)
 * @returns void
 * @author Omkar Anil Gajare
 * @date 15-12-2025
 */
void transfer(struct BankAccount *from, struct BankAccount *to, float amt)
{
    // Check if transfer amount is valid (must be positive)
    if (amt <= 0)
    {
        printf("Transfer amount can't be negative or zero!");
        return;
    }
    // Check if source account has sufficient balance
    if (amt > from->balance)
    {
        printf("Insufficient balance for transfer!");
        return;
    }
    // Deduct from source account
    from->balance -= amt;
    // Add to destination account
    to->balance += amt;
    // Display transfer confirmation
    printf("Transfer of %.2f complete from Account No.%d to Account No.%d", amt, from->account_no, to->account_no);
}
/**
 * @brief Displays the details of a bank account
 * @param b The BankAccount structure to display
 * @returns void
 * @author Omkar Anil Gajare
 * @date 15-12-2025
 */
void displayAccount(struct BankAccount b)
{
    // Display account number
    printf("Account Number: %d\n", b.account_no);
    // Display account holder name
    printf("Name: %s\n", b.name);
    // Display current balance
    printf("Balance: %.2f\n", b.balance);
    // Display address details
    printf("Address: %s, %s, %d\n\n", b.Address.city, b.Address.state, b.Address.pincode);
}
/**
 * @brief Searches for an account by account number and displays its details if found
 * @param b Array of BankAccount structures
 * @param n Number of accounts in the array
 * @param acc_no Account number to search for
 * @returns void
 * @author Omkar Anil Gajare
 * @date 15-12-2025
 */
void searchAccount(struct BankAccount b[], int n, int acc_no)
{
    // Variable to store the index of found account, initialized to -1 (not found)
    int flag = -1;
    // Loop through all accounts to find matching account number
    for (int i = 0; i < n; i++)
    {
        // Check if current account number matches the search number
        if (b[i].account_no == acc_no)
        {
            flag = i; // Store the index
            break;    // Exit loop once found
        }
    }
    // If account not found
    if (flag == -1)
    {
        printf("Account not found!\n");
    }
    else
    {
        // Display the found account details
        printf("Account Number: %d\n", b[flag].account_no);
        printf("Name: %s\n", b[flag].name);
        printf("Balance: %.2f\n", b[flag].balance);
        printf("Address: %s, %s, %d\n", b[flag].Address.city, b[flag].Address.state, b[flag].Address.pincode);
    }
}
/**
 * @brief Helper Function that finds the index of an account by account number
 * @param b Array of BankAccount structures
 * @param n Number of accounts in the array
 * @param acc_no Account number to find
 * @returns Index of the account if found, -1 otherwise
 * @author Omkar Anil Gajare
 * @date 15-12-2025
 */
int findAccount(struct BankAccount b[], int n, int acc_no)
{
    for (int i = 0; i < n; i++)
    {
        if (b[i].account_no == acc_no)
        {
            return i;
        }
    }
    return -1;
}

int main()
{
    // Display student ID and name
    printf("\n2025300063 Omkar Anil Gajare\n");
    // Array to store up to 50 bank accounts
    struct BankAccount b[50];
    // Variable to store user's menu choice
    int s = 0;
    // Counter for the number of accounts created
    int n = 0;
    // Variable for transaction amounts
    float amt;
    // Main menu loop, continues until exit condition is met
    while (s != 7)
    {
        // MENU SETUP
        printf("\n\n--- Bank Management System ---\n");
        printf("1.Create Account\n");
        printf("2.Deposit\n");
        printf("3.Withdraw\n");
        printf("4.Transfer\n");
        printf("5.Display All Accounts\n");
        printf("6.Search by Account No.\n");
        printf("7.Exit\n");
        // Prompt user for choice
        printf("Enter Choice: ");
        scanf("%d", &s);
        // Switch handling
        switch (s)
        {
        case 1: // Create new account
        {
            // Create account at the current index n
            createAccount(&b[n]);
            // Increment the account counter
            n++;
        }
        break;
        case 2: // Deposit money
        {
            // Local variable for deposit amount
            float amt;
            // Variable for account number
            int acc_no;
            // Prompt for account number
            printf("Enter Account Number: ");
            scanf("%d", &acc_no);
            // Find the account index
            int index = findAccount(b, n, acc_no);
            if (index != -1) // If account found
            {
                // Prompt for deposit amount
                printf("Enter Amount to Deposit: ");
                scanf("%f", &amt);

                // Perform the deposit
                deposit(&b[index], amt);
            }
            else // Account not found
            {
                printf("Account not found!\n");
            }
        }
        break;

        case 3: // Withdraw money
        {
            // Local variable for withdrawal amount
            float amt;
            // Variable for account number
            int acc_no;

            // Prompt for account number
            printf("Enter Account Number: ");
            scanf("%d", &acc_no);

            // Find the account index
            int index = findAccount(b, n, acc_no);

            if (index != -1) // If account found
            {
                // Prompt for withdrawal amount
                printf("Enter Amount to Withdraw: ");
                scanf("%f", &amt);

                // Perform the withdrawal
                withdraw(&b[index], amt);
            }
            else // Account not found
            {
                printf("Account not found!\n");
            }
        }
        break;

        case 4: // Transfer money between accounts
        {
            // Local variable for transfer amount
            float amt;
            // Variables for destination and source account numbers
            int to, from;

            // Prompt for transfer amount
            printf("Enter Amount to be transferred: ");
            scanf("%f", &amt);

            // Prompt for destination account number
            printf("Enter Account Number of Account to be transferred to: ");
            scanf("%d", &to);

            // Prompt for source account number
            printf("Enter Account Number of Account to be transferred from: ");
            scanf("%d", &from);

            // Find indices for both accounts
            int toIndex = findAccount(b, n, to);
            int fromIndex = findAccount(b, n, from);

            if (toIndex != -1 && fromIndex != -1) // Both accounts found
            {
                // Perform the transfer
                transfer(&b[fromIndex], &b[toIndex], amt);
            }
            else // One or both accounts not found
            {
                printf("Account not found!\n");
            }
        }
        break;

        case 5: // Display all accounts
        {
            // Loop through all created accounts and display them
            for (int i = 0; i < n; i++)
            {
                displayAccount(b[i]);
            }
        }
        break;

        case 6: // Search for account by number
        {
            // Variable for search account number
            int search;
            // Prompt for account number to search
            printf("Enter Account Number to be searched: ");
            scanf("%d", &search);

            // Perform the search and display results
            searchAccount(b, n, search);
        }
        break;

        case 7: // Exit the program
        {
            // Break out of the menu loop
            break;
        }

        default: // Invalid choice
            printf("Invalid Choice! Please select an option in the menu (1-7)");
        }
    }
    printf("Exiting....");
    printf("\n\n2025300063 Omkar Anil Gajare\n");
    return 0;
}
