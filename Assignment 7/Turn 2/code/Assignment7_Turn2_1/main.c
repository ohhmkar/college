#include <stdio.h>
#include <stdlib.h>
/**
* @brief  Student Marks Analyzer
* @author Omkar Anil Gajare
* @date   21-11-2025
*/
int totalMarks(int arr[], int n);
float averageMarks(int total,int n);
void findMinMax(int arr[],int n,int *min,int *max);
int main()
{
    printf("\n2025300063 Omkar Anil Gajare\n\n");
    int n;
    printf("Enter number of students: ");
    scanf("%d",&n);//Data Entry of number of students
    int marks[n];
    printf("Enter marks of %d students: ",n);
    for(int i=0; i<n; i++)
        scanf("%d",&marks[i]);//Data Entry of Marks
    int total = totalMarks(marks, n);//Calling totalMarks function to store total of marks
    printf("\nTotal Marks = %d",total);//Printing total marks
    printf("\nAverage Marks = %.2f",averageMarks(total,n));//Calling averageMarks function to store average of marks
    int min,max;//Defining max and min
    findMinMax(marks,n,&min,&max);//Calling findMinMax function, to modify max and min variable to store maximum and minimum value
    /*Printing Result*/
    printf("\nLowest Marks = %d",min);
    printf("\nHighest Marks = %d",max);
    printf("\n\n2025300063 Omkar Anil Gajare\n");
    return 0;
}
/**
* @brief Finds total marks of all students
* @param marks[] Array of Marks
* @param n Number of Students
* @returns Total Marks of all Students
* @author Omkar Anil Gajare
* @date 21-11-2025
*/
int totalMarks(int marks[], int n)
{
    int total=0;
    //Adding all marks by iterating through the array and adding all elements to a total variable
    for(int i=0; i<n; i++)
        total+=marks[i];
    return total;
}
/**
* @brief Finds average marks of all students
* @param  total Total of Marks
* @param  n Number of students
* @returns Average Marks
* @author Omkar Anil Gajare
* @date 21-11-2025
*/
float averageMarks(int total, int n)
{
    return (float)total/n;//Returns total/n as average marks
}

/**
* @brief Finds the maximum and minimum marks of students
* @param marks[] Array of Marks
* @param n Number of Students
* @param *min Pointer for minimum marks
* @param *max Pointer for maximum marks
* @returns N/A(Modifies max and min to store maximum and minimum value)
* @author Omkar Anil Gajare
* @date 21-11-2025
*/
void findMinMax(int marks[],int n, int *min, int *max)
{
    //Defining max and min by default as first elements of the array
    *min = marks[0];
    *max = marks[0];
    for(int i=0; i<n; i++)
    {
        //marks[i]>max replace max with marks[i]
        if(marks[i]>(*max))
        {
            *max = marks[i];
        }//marks[i]<min replace min with marks[i]
        else if(marks[i]<(*min))
        {
            *min = marks[i];
        }
    }
}
