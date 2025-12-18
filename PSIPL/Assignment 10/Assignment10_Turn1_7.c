#include <stdio.h>
#include <stdlib.h>
#include <string.h>
/**
* @brief  Passing Union to Function
* @author Omkar Anil Gajare
* @date 15-12-2025
*/
/**
* @union Value
* @author Omkar Anil Gajare
* @date 15-12-2025
*/
union Value{
    int i;
    float f;
};

/**
* @brief Displays value stored inside the union, if key == 1 then integer else if key == 2 then float else returns invalid case
* @param union Value v Union where data is stored
* @returns N/A (Prints value of data stored in union)
* @author Omkar Anil Gajare
* @date
*/

void display(union Value val,int key){
    if(key==1){
        printf("Integer: %d\n",val.i);
    }
    else if(key == 2){
        printf("Float: %.2f\n",val.f);
    }
    else{
        printf("Invalid case");
    }
}
int main()
{
    printf("\n2025300063 Omkar Anil Gajare\n\n");
    union Value v;
    v.i = 25;
    display(v,1);
    v.f = 9.81;
    display(v,2);
    printf("\n2025300063 Omkar Anil Gajare\n");
    return 0;
}
