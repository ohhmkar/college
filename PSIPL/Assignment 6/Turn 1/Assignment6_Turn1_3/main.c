#include <stdio.h>
#include <string.h>
/**
* @brief  Concat Strings
* @author Omkar Anil Gajare
* @date   10-11-25
*/
int main()
{
    printf("\n2025300063 Omkar Anil Gajare\n\n");

    char str1[10];
    char str2[10];
    printf("Enter first string: ");
    fgets(str1,10,stdin);
    printf("Enter second string: ");
    gets(str2);
    int length1 = 0;
    int length2 = 0;//Length variable for first string starting at zero
    int i=0;
    //Iterating till '\n' is not reached for length of first string
    while(str1[i]!='\n'){
        length1++;
        i++;
    }
    i=0;
    //Iterating till '\n' is not reached for length of second string
    while(str2[i]!='\n'){
        length2++;
        i++;
    }
    //Assignment of answer array that has length of both inputs combined
    char ans[length1+length2];
    for(i=0;i<length1+length2;i++){
        if (i>=length1)//If i>=length1 you start appending second array
            ans[i] = str2[i-length1];
        else
            ans[i] = str1[i];
    }
    printf("Concatenated String: %s",ans);
    printf("\n\n2025300063 Omkar Anil Gajare\n");
    	return 0;
}
