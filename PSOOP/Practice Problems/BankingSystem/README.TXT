------------------------------------------------------------------------
This is the project README file. Here, you should describe your project.
Tell the reader (someone who does not know anything about this project)
all they need to know. The comments should usually include at least:
------------------------------------------------------------------------

PROJECT TITLE:
PURPOSE OF PROJECT:
VERSION or DATE:
HOW TO START THIS PROJECT:
AUTHORS:
USER INSTRUCTIONS:

PROJECT TITLE:
Banking System using Abstract Class and Exception Handling

PURPOSE OF PROJECT:
To demonstrate inheritance, abstraction, exception handling, and an interactive menu-driven banking program.

VERSION or DATE:
28 April 2026

HOW TO START THIS PROJECT:
Compile all Java files in the BankingSystem folder and run ATMTeller.

AUTHORS:
Omkar Gajare

USER INSTRUCTIONS:
1. Run ATMTeller.
2. Enter the number of savings accounts.
3. Enter account details for each account.
4. Use the menu to deposit, withdraw, transfer, add interest, or display accounts.

SAMPLE OUTPUTS:

1. Successful deposit
No of Accounts: 1
Enter details for Account 1
Enter Name: Riya
Enter Balance: Rs. 5000
Enter Interest Rate: 4
Enter Min Balance: Rs. 1000
Account created with Acc No.: 12345678901234

Choose option: 2
Enter Account Number: 12345678901234
Enter Deposit Amount: Rs. 1500
Transaction Successful. Rs.1500.0 deposited into Acc No.12345678901234
Updated Balance: Rs.6500.0

2. Failed withdrawal due to minimum balance rule
Choose option: 3
Enter Account Number: 12345678901234
Enter Withdrawal Amount: Rs. 6000
Transaction Failed! Reason: Balance cannot go below the minimum balance of Rs.1000.0.

3. Failed deposit due to negative amount
Choose option: 2
Enter Account Number: 12345678901234
Enter Deposit Amount: Rs. -200
Transaction Failed! Reason: Deposit amount must be greater than zero.

4. Transfer between accounts
Choose option: 4
Enter Account Number: 12345678901234
Enter Destination Account Number: 98765432109876
Enter Transfer Amount: Rs. 1000
Transaction Successful. Rs.1000.0 withdrawn from Acc No.12345678901234 and credited to Acc No.98765432109876
Updated Balance: Rs.5500.0
