#include <stdio.h>
#include <string.h>
/**
* @brief  Text Message Analyzer
* @author Omkar Anil Gajare
* @date   14-11-2025
*/
int main()
{
    printf("\n2025300063 Omkar Anil Gajare\n\n");
    char msg[240];
    printf("Enter a message: ");
    fgets(msg,sizeof(msg),stdin);

    int words=1,vowels=0,consonants=0,digits=0,spaces=0;//Assignment of counters for words,vowels,consonants,digits and spaces
    int c,length=0;
    //Finding length of message
    for(int i=0;msg[i]!='\n';i++)
        length++;
    int temp;//Assigning temp variable for swapping characters
    /*Swapping chars at 'i' and 'length-i-1' index for reversing the message in place*/
    for(int i=0;i<length/2;i++){
        temp = msg[i];
        msg[i] = msg[length-i-1];
        msg[length-i-1] = temp;
    }
    /*Reversing the reversed message to return to the original*/
    printf("\nReversed Message: %s",msg);
    for(int i=0;i<length/2;i++){
        temp = msg[i];
        msg[i] = msg[length-i-1];
        msg[length-i-1] = temp;
    }
    //Counting character types and words in message
    for(int i=0;msg[i]!='\n' && msg[i]!='\0';i++){
        c = (int)msg[i];//Typecast char to int so it converts into the ASCII value of the character
        if(c==65||c==69||c==73||c==79||c==85||c==97||c==101||c==105||c==111||c==117)//Checking if C is equal to any vowel, Capital and small
            vowels++;
        else if((c>64 && c<91) || (c>96 && c<123))//If not vowel but letter you increment consonants
            consonants++;
        else if(c>47 && c<58)//if C is a number case
            digits++;
        else if(c==32)//if C is a blank space case
            spaces++;
        if(msg[i]==' ' && msg[i+1]!=' '){
            words++;
        }
    }
    /*Printing message analysis*/
    printf("\nMessage Analysis:");
    printf("\nWords      : %d",words);
    printf("\nVowels     : %d",vowels);
    printf("\nConsonants : %d",consonants);
    printf("\nDigits     : %d",digits);
    printf("\nSpaces     : %d",spaces);

    //Printing cleaned message, with multiple spaces being reduced to a single space
    printf("\n\nCleaned Message (extra spaces removed): ");
    for(int i=0;msg[i]!='\n' && msg[i]!='\0';i++){
        if(msg[i]==' ' && msg[i+1]==' '){
                continue;
        }
        else{
            printf("%c",msg[i]);
        }
    }
    printf("\n\n2025300063 Omkar Anil Gajare\n");
    return 0;
}
