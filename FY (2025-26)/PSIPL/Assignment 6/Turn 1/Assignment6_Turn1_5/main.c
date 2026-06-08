#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <string.h>
/**
* @brief
* @author Omkar Anil Gajare
* @date
*/
int main()
{
    printf("\n2025300063 Omkar Anil Gajare\n\n");
    char str[100];
    printf("Enter a string: ");
    fgets(str,100,stdin);
    int length = 0;//Length variable for first string starting at zero
    int i=0;
    //Iterating till '\n' is not reached for length of first string
    while(str[i]!='\n'){
        length++;
        i++;
    }
    char reverse_str[length];
    for(i=0;i<length;i++)
        reverse_str[length-i-1] = str[i];
    printf("Reversed: %s",reverse_str);
    printf("\n\n2025300063 Omkar Anil Gajare\n");
    	return 0;
}
