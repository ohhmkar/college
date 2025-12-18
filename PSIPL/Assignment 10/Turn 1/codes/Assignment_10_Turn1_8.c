#include <stdio.h>
#include <stdlib.h>
#include <string.h>
/**
* @brief  Union with Typedef
* @author Omkar Anil Gajare
* @date 15-12-2025
*/
/**
* @union Result
* @author Omkar Anil Gajare
* @date 15-12-2025
*/
/* Using typedef to define union as Result*/
typedef union Result{
    int marks;
    char grade;
}Result;

int main()
{
    printf("\n2025300063 Omkar Anil Gajare\n\n");
    Result r1;
    r1.marks = 85;//Assignment of value of marks
    printf("Marks: %d",r1.marks);//Printing marks
    r1.grade = 'A';//Reassining value of marks to grade
    printf("\nGrade: %c\n",r1.grade);//Printing grade
    printf("\n2025300063 Omkar Anil Gajare\n");
    return 0;
}
