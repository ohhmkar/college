#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <string.h>
/**
* @brief    Prints length of string, by counting manually
* @author   Omkar Anil Gajare
* @date     10-11-25
*/
int main()
{
    printf("\n2025300063 Omkar Anil Gajare\n\n");
    char str[10]={};//Assignment of array
    printf("Enter string: ");
    gets(str);//Input of array
    int length = 0;//Length variable starting at zero
    int i=0;
    //Iterating till '\0' is not reached
    while(str[i]!='\0'){
        length++;
        i++;
    }
    printf("Length of string: %d",length);
    printf("\n\n2025300063 Omkar Anil Gajare\n");
    return 0;
}
