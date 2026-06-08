#include <stdio.h>
/**
* @brief This program simulates an ATM,
  it starts out with an initial balance of 10000,
  and can perform various operations like depositing money,
  withdrawing money,
  and printing out your most recent (atmost) 5 transactions.

* @author Omkar Anil Gajare
* @date 27-10-25
*/

int main()
{
    //UID AND NAME
    printf("2025300063 Omkar Gajare \n\n");
    //Initial Assignment of Variables
    int balance = 10000;
    int s = 0;
    int deposit=0;
    int withdraw=0;
    //MENU SETUP
    printf("==== ATM MENU ====\n");
    printf("1.Check Balance\n");
    printf("2.Deposit Money\n");
    printf("3.Withdraw Money\n");
    printf("4.Print Last 5 Transactions\n");
    printf("5.Exit\n");
    //Assignment of Default Arrays with Null Identifiers
    char transactiontype[5]={'N','N','N','N','N'};
    int  transactionamt[5]={0,0,0,0,0};
    while(s!=5){
        printf("Enter Choice: ");
        scanf("%d",&s);
        switch(s){
        //Check Balance Case
        case 1:
            printf("Current Balance = %.2f\n\n",(float)balance);
            break;
        //Depositing Money Case
        case 2:
            printf("Enter amount to be deposited: ");
            scanf("%d",&deposit);
            if (deposit>0){
                    balance+=deposit;
                    printf("Deposited %.2f . New Balance = %.2f\n\n",(float)deposit,(float)balance);
                    for(int i=0;i<4;i++){
                        transactionamt[i]=transactionamt[i+1];
                        transactiontype[i]=transactiontype[i+1];
                    }
                    transactionamt[4]=deposit;
                    transactiontype[4]='D';
            }
            else{
                //Deposit can't be negative
                printf("Invalid Amount. Deposit should be positive!\n\n");
            }
            break;
        case 3:
            //Withdrawing Money Case
            printf("Enter amount to be withdrawn: ");
            scanf("%d",&withdraw);
            //Insufficient Money Case
            if (withdraw>balance)
                printf("Insuffience Balance!\n");
            else{
                balance -= withdraw;
                printf("Withdrew %.2f. New Balance = %.2f\n\n",(float)withdraw,(float)balance);
                for(int i=0;i<4;i++){
                        transactionamt[i]=transactionamt[i+1];
                        transactiontype[i]=transactiontype[i+1];
                    }
                    transactionamt[4]=withdraw;
                    transactiontype[4]='W';
            }
            break;
        case 4:
            //Printing out most recent transactions
            printf("Last 5 transactions (most recent first)\n");
            printf("Type \t Amount\n");
            for(int i=4;i>-1;i--){
                //Check for NULL Case
                if(transactiontype[i]!='N')
                    printf("%c \t %d\n",transactiontype[i],transactionamt[i]);
                else
                    continue;
            }
            printf("\n");
            break;
        //EXIT CASE
        case 5:
            break;
        //Invalid Choice/Default Case
        default:
            printf("Enter a valid choice (1-5)!\n\n");
            continue;
        }
    }
    printf("Thank you for using the ATM! Goodbye!");
    //UID AND NAME
    printf("\n\n2025300063 Omkar Gajare\n\n");
}
