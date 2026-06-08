#include <stdio.h>
#include <stdlib.h>
/**
* @brief  Library Password System
* @author Omkar Anil Gajare
* @date 21-11-2025
*/
int checkLength(char str[]);
int isStrong(char str[]);
void toLowerCase(char str[]);
int main()
{
    printf("\n2025300063 Omkar Anil Gajare\n\n");
    char password[100];
    printf("Enter a password: ");
    fgets(password,100,stdin);
    //Calling checkLength function to find length of password
    int len = checkLength(password);
    printf("Password Length: %d",len);//Printing length of password
    //Calling and printing result of isStrong function
    if(isStrong(password))
        printf("\nStrong Password");
    else
        printf("\nWeak Password(must contain uppercase,lowercase & digit)");
    //Calling function to convert password
    toLowerCase(password);
    printf("\nPassword in lowercase: %s",password);

    printf("\n\n2025300063 Omkar Anil Gajare\n");
    return 0;
}
/**
* @brief Finds length of password
* @param password Password
* @returns len Length of Password
* @author Omkar Anil Gajare
* @date 21-11-2025
*/
int checkLength(char password[])
{
    int len=0;
    for(int i=0; password[i]!='\n' && password[i]!='\0'; i++)
        len++;
    return len;
}
/**
* @brief Checks the strength of the password
* @param password Password
* @returns 1 if Password is strong else 0
* @author Omkar Anil Gajare
* @date 21-11-2025
*/
int isStrong(char password[])
{
    int uCase=0,lCase=0,dCount=0;//Assignment of counter variables of uppercase,lowercase and digits
    for(int i=0; password[i]!='\n' && password[i]!='\0'; i++)
    {
        if(password[i]>='A' && password[i]<='Z')//If uppercase, increment counter of uppercase
            uCase++;
        else if(password[i]>='a' && password[i]<='z')//If lowercase, increment counter of lowercase
            lCase++;
        else if(password[i]>='1' && password[i]<='9')//If digits, increment counter of digits
            dCount++;
    }
    return ((uCase>0&&lCase>0&&dCount>0)?1:0);//Returns truthy value(1) if all counters>0 else falsy value(0)
}
/**
* @brief Converts all uppercase characters to lowercase
* @param password Password
* @returns N/A(Modifies password such that uppercase letters get converted to lowercase)
* @author Omkar Anil Gajare
* @date 21-11-2025
*/
void toLowerCase(char password[])
{
    for(int i=0; password[i]!='\n' && password[i]!='\0'; i++)
        if(password[i]>='A' && password[i]<='Z')//If uppercase, +32 converts it to lowercase
            password[i]+=32;
}
