#include <stdio.h>
#include <string.h>
/**
* @brief Count Vowels and Consonants
* @author Omkar Anil Gajare
* @date 10-11-2025
*/
int main()
{
    printf("\n2025300063 Omkar Anil Gajare\n\n");
    //Take User Input of string
    printf("Enter string: ");
    char str[100];
    fgets(str,100,stdin);
    //Initialise 4 variables for number of vowels,consonants,digits & spaces
    int vowels = 0;
    int consonants = 0;
    int digits = 0;
    int spaces = 0;
    int c;
    for(int i=0;str[i]!='\0';i++){
        c = (int)str[i];//Typecast char to int so it converts into the ASCII value of the character
        if(c==65||c==69||c==73||c==79||c==85||c==97||c==101||c==105||c==111||c==117)//Checking if C is equal to any vowel, Capital and small
            vowels++;
        else if((c>64 && c<91) || (c>96 && c<123))//If not vowel but letter you increment consonants
            consonants++;
        else if(c>47 && c<58)//if C is a number case
            digits++;
        else if(c==32)//if C is a blank space case
            spaces++;
    }
    printf("Vowels : %d\n",vowels);
    printf("Consonants : %d\n",consonants);
    printf("Digits : %d\n",digits);
    printf("Spaces : %d\n",spaces);
    printf("\n\n2025300063 Omkar Anil Gajare\n");
    return 0;
}
