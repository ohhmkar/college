#include <stdio.h>
#include <stdlib.h>
#include <string.h>
/**
* @brief    Copy string
* @author   Omkar Anil Gajare
* @date     10-11-25
*/
int main()
{
    printf("\n2025300063 Omkar Anil Gajare\n\n");
    char str[20]={};//Assignment of array
    printf("Enter string: ");
    gets(str);//Input of array
    int length = 0;//Length variable starting at zero
    int i=0;
    //Iterating till '\0' is not reached
    while(str[i]!='\0'){
        length++;
        i++;
    }
    //Assignment of empty array which has a length of the original string
    char str_copy[length+1];
    //Copying each element in the corresponding index
    for(int i=0;i<length;i++){
        str_copy[i] = str[i];
    }
    printf("Copied String: %s",str_copy);
    printf("\n\n2025300063 Omkar Anil Gajare\n");
    return 0;
}
