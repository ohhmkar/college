#include <stdio.h>
#include <stdlib.h>
#include <string.h>
/**
* @brief  Storing Multiple Data Types
* @author Omkar Anil Gajare
* @date 15-12-2025
*/
/**
* @union Number
* @author Omkar Anil Gajare
* @date 15-12-2025
*/
/*Union Number with members integer,decimal and str which are int,float and char respectively*/
union Number{
    int integer;
    float decimal;
    char str[20];
}num;
int main()
{
    printf("\n2025300063 Omkar Anil Gajare\n\n");
    num.integer = 100;//Assignment of value of integer
    printf("Integer: %d",num.integer);//Printing value as int
    num.decimal = 12.34;//Reassignment of value as float
    printf("\nFloat: %.2f",num.decimal);//Printing value as float
    sprintf(num.str,"Hello",num.str);//Assignment of value as string, using sprintf
    printf("\nString: %s",num.str);//Printing value as string
    printf("\n\n2025300063 Omkar Anil Gajare\n");
    return 0;
}
