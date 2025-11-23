#include <stdio.h>
#include <string.h>
/**
* @brief  Username Validator
* @author Omkar Anil Gajare
* @date 14-11-2025
*/
int main()
{
    printf("\n2025300063 Omkar Anil Gajare\n\n");
    printf("Enter a username: ");
    char username[100];//Assignment of username string
    char flag = 'Y';//Assigning flag variable for username validation
    fgets(username,100,stdin);//Input of Username
    /*Finding length of string*/
    int length = 0;
    for(int i=0;username[i]!='\n';i++)
        length++;
    //If len<6 or len>15 then username fails validation
    if(length>15 || length<6)
        flag = 'N';
    int c;
    char username_processed[length+1];//Assigment of blank string of length equal to original string to store processed username
    for(int i=0;i<length;i++){
        c = username[i];
        //Letter is capital case
        if(64<c && c<91){
            username_processed[i] = username[i]+32;//Capital letter + 32 = Same letter in small case
        }
        else if(96<c && c<123){
            username_processed[i] = c;//If letter is already small, dont change
        }
        else if(47<c && 58>c){
            username_processed[i] = c;//If character is a digit, dont change
        }
        else{
            //if character is not letter or digit, fail validation and dont change
            flag = 'N';
            username_processed[i] = c;
        }
    };
    username_processed[length] = '\0';
    /*Printing processed username and Valid check*/
    printf("Processed Username: %s",username_processed);
    printf((flag=='Y')?"\nUsername is Valid.":"\nUsername is Invalid.");-
    printf("\n\n2025300063 Omkar Anil Gajare\n");
    return 0;
}
