#include <stdio.h>
/**
* @brief  Check Palindrome
* @author Omkar Anil Gajare
* @date   10-11-25
*/
int main()
{
    printf("\n2025300063 Omkar Anil Gajare\n\n");
    //User Input of string
    printf("Enter string: ");
    char str[10];
    gets(str);
    int len = 0;
    //Find Length of string
    for(int i=0;str[i]!='\0';i++)
        len++;
    //Assign flag variable (true by default)
    char flag = 'Y';
    //Iterate through pairs of indexs like (0,len-1) (1,len-2) (2,len-3) and so on
    for(int i=0;i<len/2;i++){
        if(str[i]!=str[len-i-1]){
            flag = 'N';//If the pairs are not equal, set flag to false and break
            break;
        }
    }
    //Printing Result
    if(flag == 'Y')
        printf("Palindrome");
    else
        printf("Not Palindrome");
    printf("\n\n2025300063 Omkar Anil Gajare\n");
    	return 0;
}
