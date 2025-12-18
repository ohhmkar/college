#include <stdio.h>
#include <stdlib.h>
#include <string.h>
/**
* @brief  Basic Union Declaration and Initialization
* @author Omkar Anil Gajare
* @date 15-12-2025
*/
/**
* @union data
* @author Omkar Anil Gajare
* @date 15-12-2025
*/
/*Union Data with members i,f,ch which are int,float and char respectively*/
union data{
    int i;
    float f;
    char ch;
}d;
int main()
{
    printf("\n2025300063 Omkar Anil Gajare\n\n");
    d.i = 10;//Initial Assignment of value
    printf("Integer : %d",d.i);
    d.f = 3.14;//Reassignment of value as float
    printf("\nFloat : %.2f",d.f);
    d.ch = 'A';//Reassignment of value as char
    printf("\nChar: %c",d.ch);
    printf("\nAfter last assignment, integer: %d",d.i);//Printing finally as int, value reassigned as char
    printf("\n\n2025300063 Omkar Anil Gajare\n");
    return 0;
}
