#include <stdio.h>
#include <stdlib.h>
#include <string.h>
/**
* @brief Union as a Variant Data Type
* @author Omkar Anil Gajare
* @date 15-12-2025
*/
/**
* @union Number
* @author Omkar Anil Gajare
* @date 15-12-2025
*/
/*Union Number with members integer,decimal and ch which are int,float and char respectively*/
union Number
{
    int integer;
    float decimal;
    char ch;
} num;
int main()
{
    printf("\n2025300063 Omkar Anil Gajare\n\n");
    int tag;
    printf("Enter Type (1:Int,2:Float,3:Char): ");
    scanf("%d",&tag);//Switch variable tag
    switch(tag)
    {
    case 1://Integer input case
    {
        printf("Enter an integer: ");
        scanf("%d",&num.integer);//Take integer input
        printf("You Entered Integer: %d",num.integer);//Print integer input
        break;
    }
    case 2://Float Input case
    {
        printf("Enter a float: ");
        scanf("%f",&num.decimal);//Take float input
        printf("You Entered float: %.2f",num.decimal);//Print float input
        break;
    }
    case 3://Character Input Case
    {
        printf("Enter a char: ");
        scanf("%c",&num.ch);//Take character input
        printf("You Entered character: %c",num.ch);//Print charactr in0put
        break;

    }

    }
    printf("\n\n2025300063 Omkar Anil Gajare\n");
    return 0;
}
