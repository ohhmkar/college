#include <stdio.h>
#include <stdlib.h>

int main()
{
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
        //EXIT CASE
        case 5:
            break;
        //Invalid Choice/Default Case
        default:
            printf("Enter a valid choice (1-5)!\n\n");
            continue;
        }
    }
}
