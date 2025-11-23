#include <stdio.h>
#include <string.h>
/**
* @brief  Compare Two Strings
* @author Omkar Anil Gajare
* @date   10-11-2025
*/
int main()
{
    printf("\n2025300063 Omkar Anil Gajare\n\n");
    //Assignment of two arrays
    char str1[100];
    char str2[100];
    //DATA ENTRY
    printf("Enter first string: ");
    gets(str1);
    printf("Enter second string: ");
    gets(str2);
    //Assignment of flag variable ( true by default )
    char flag = 'Y';
    /*Iterating through both strings till either
      i) One string terminates
      ii) Not equal character is found
    */
    for(int i=0;str1[i]!='\0' || str2[i]!='\0';i++)
        if(str1[i]!=str2[i]){
            flag = 'N';
            break;
        }
    //If flag is still Y then the strings are equal else unequal
    if(flag == 'Y'){
        printf("Strings are equal");
    }
    else{
        printf("Strings are not equal");
    }
    printf("\n\n2025300063 Omkar Anil Gajare\n");
    return 0;
}
