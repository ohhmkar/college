#include <stdio.h>
#include <stdlib.h>
#include <string.h>
/**
 * @brief  Menu-driven Demo of Structure vs Union
 * @author Omkar Anil Gajare
 * @date 15-12-2025
 */

/**
 * @union datau
 * @author Omkar Anil Gajare
 * @date 15-12-2025
 */
/*Union DataU with members i,f,ch which are int,float and char respectively*/
typedef union datau
{
    int i;
    float f;
    char ch;
} dataUnion;

/**
 * @struct datas
 * @author Omkar Anil Gajare
 * @date 15-12-2025
 */
/*Struct DataS with members i,f,ch which are int,float and char respectively*/
typedef struct datas
{
    int i;
    float f;
    char ch;
} dataStruct;

int main()
{
    printf("\n2025300063 Omkar Anil Gajare\n\n");

    int s = 0;     // Menu choice
    dataUnion du;  // Union variable
    dataStruct ds; // Structure variable

    while (s != 5)
    {
        // Menu Setup
        printf("\n--- Menu ---\n");
        printf("1.Enter Structure Values\n");
        printf("2.Enter Union Values\n");
        printf("3.Display Structure Values\n");
        printf("4.Display Union Values\n");
        printf("5.Exit\n");
        printf("Enter choice: ");
        scanf("%d", &s);
        // Switch case
        switch (s)
        {
        case 1:
            // Structure stores all values correctly
            printf("Enter int, float, char: ");
            scanf("%d %f %c", &ds.i, &ds.f, &ds.ch);
            break;

        case 2:
            // Union stores only the last assigned value
            printf("Enter int, float, char: ");
            scanf("%d %f", &du.i, &du.f);
            scanf(" %c", &du.ch);
            break;

        case 3:
            // Display structure values
            printf("\n Structure -> Int: %d Float: %.2f Char: %c",
                   ds.i, ds.f, ds.ch);
            break;

        case 4:
            // Display union values
            printf("\n Union -> Int: %d Float: %.2f Char: %c",
                   du.i, du.f, du.ch);
            break;

        case 5:
            // Exit program
            break;

        default:
            printf("Invalid Input! Please Enter Value between 1-5");
        }
    }

    printf("\n\n2025300063 Omkar Anil Gajare\n");
    return 0;
}
