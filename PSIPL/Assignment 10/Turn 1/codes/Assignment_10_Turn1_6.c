#include <stdio.h>
#include <stdlib.h>
#include <string.h>
/**
* @brief  Array of union variab
* @author Omkar Anil Gajare
* @date 15-12-2025
*/
/**
* @union Test
* @author Omkar Anil Gajare
* @date 15-12-2025
*/
union Test{
    int x;//integer
    char y;//character
};

int main()
{
    printf("\n2025300063 Omkar Anil Gajare\n\n");
    union Test t[5];//Assignment of array of Test of size 5
    for(int i=1;i<=5;i++)t[i-1].x = (i*10);//Assignment of all values as 10,20,30..
    for(int i=1;i<=5;i++)t[i-1].y = ('A'+(i-1));//Reassignment to overwrite initial values
    for(int i=0;i<5;i++)printf("arr[%d] after overwrite: x = %d,y = %c\n",i,t[i].x,t[i].y);//Printing values after overwrite
    printf("\n\n2025300063 Omkar Anil Gajare\n");
    return 0;
}
