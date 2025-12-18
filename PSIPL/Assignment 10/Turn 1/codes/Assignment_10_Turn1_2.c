#include <stdio.h>
#include <stdlib.h>
#include <string.h>
/**
* @brief  Size of Structure vs Union
* @author Omkar Anil Gajare
* @date 15-12-2025
*/
/**
* @union datau
* @author Omkar Anil Gajare
* @date 15-12-2025
*/
/*Union DataU with members i,f,ch which are int,float and char respectively*/
union datau{
    int i;
    float f;
    char ch;
}du;
/**
* @struct datas
* @author Omkar Anil Gajare
* @date 15-12-2025
*/
/*Struct DataS with members i,f,ch which are int,float and char respectively*/
struct datas{
    int i;
    float f;
    char ch;
}ds;
int main()
{
    printf("\n2025300063 Omkar Anil Gajare\n\n");
    printf("Size of Structure: %d bytes",sizeof(ds));//Printint size of struct
    printf("\nSize of Union: %d bytes",sizeof(du));//Printing size of union in contrast
    printf("\n\n2025300063 Omkar Anil Gajare\n");
    return 0;
}
