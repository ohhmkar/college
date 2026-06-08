#include <stdio.h>
#include <stdlib.h>
/**
 * @brief  Student Result Management System
 * @author Omkar Anil Gajare
 * @date 12-12-2025
 */
/* Student struct */
struct Student
{
    int roll_no;
    char name[30];
    int marks[5];
    int total;
    float percentage;
    char grade;
};
/*Function Prototypes*/
void calculateResult(struct Student *s);
void displayStudents(struct Student s[], int n);
void searchByRoll(struct Student s[], int n, int roll);
void inputStudents(struct Student s[], int n);
void highestScorer(struct Student s[], int n);

/**
 * @brief Read details of n students.
 * @param s[] Array of struct Students
 * @param n Number of students
 * @returns N/A(Takes input of all students data)
 * @author Omkar Anil Gajare
 * @date 12-12-2025
 */
void inputStudents(struct Student s[], int n)
{
    for (int i = 0; i < n; i++)
    {
        printf("Enter Roll No. and Name: ");
        scanf("%d", &s[i].roll_no); // Data entry of roll number of student
        scanf("%s", s[i].name);     // Data entry of name of student
        printf("Enter marks in 5 subjects: ");
        for (int j = 0; j < 5; j++)
        {
            scanf("%d", &s[i].marks[j]); // Data entry of marks in each subject
        }
        calculateResult(&s[i]); // Calling to store values of total,percentage and grade
    }
};
/**
 * @brief Read details of n students.
 * @param *s Pointer to students data
 * @returns N/A(Calculates and stores student's total marks, percentage and grade)
 * @author Omkar Anil Gajare
 * @date 12-12-2025
 */
void calculateResult(struct Student *s)
{
    int sum = 0;
    float sp;
    for (int i = 0; i < 5; i++)
    {
        sum += s->marks[i];
    }
    s->total = sum;            // storing sum of marks in total
    s->percentage = sum / 5.0; // storing percentage of student in percentage
    sp = sum / 5.0;
    // Storing grade (A>B>C>F) in grade of student
    s->grade = (sp >= 75) ? 'A' : (sp >= 60) ? 'B'
                              : (sp >= 50)   ? 'C'
                                             : 'F';
};
/**
 * @brief Display all details in tabular form
 * @param s[] Array of struct Students
 * @param n Number of students
 * @returns N/A(Prints details of all students)
 * @author Omkar Anil Gajare
 * @date 12-12-2025
 */
void displayStudents(struct Student s[], int n)
{
    printf("\nRoll\tName\tTotal\tPercentage\tGrade"); // Prints menu structure
    for (int i = 0; i < n; i++)
    {
        printf("\n%d\t%s\t%d\t%.2f\t          %c", s[i].roll_no, s[i].name, s[i].total, s[i].percentage, s[i].grade); // Prints details of each student
    };
}
/**
 * @brief Searches student by roll number and displays details. .
 * @param s[] Array of struct Students
 * @param n Number of students
 * @param roll Roll Number to be searched
 * @returns N/A(Prints details of roll number if found else prints Not found)
 * @author Omkar Anil Gajare
 * @date 12-12-2025
 */
void searchByRoll(struct Student s[], int n, int roll)
{
    int found = -1; // initialising flag variable ( -1 by default )
    for (int i = 0; i < n; i++)
    {
        if (s[i].roll_no == roll)
        {
            found = i; // if roll number is found, save index in array to flag variable
            break;
        }
    }
    if (found != -1) // If flag is not -1, it means the roll number was found and data is printed
    {
        printf("\nFOUND! Roll No = %d, Name = %s, Total = %d, Percentage = %.2f, Grade = %c", s[found].roll_no, s[found].name, s[found].total, s[found].percentage, s[found].grade);
    }
    else // If flag is still -1, it means the roll number wasnt found and not found is printed
    {
        printf("\nNot found!");
    }
};
/**
 * @brief Find and display the topper.
 * @param s[] Array of struct Students
 * @param n Number of students
 * @returns N/A(Prints details of topper)
 * @author Omkar Anil Gajare
 * @date 12-12-2025
 */
void highestScorer(struct Student s[], int n)
{
    int mx = s[0].total; // initialising variable that stores the max marks of students, by default first students marks
    int topper = 0;      // initialising flag variable that will store index of topper
    for (int i = 1; i < n; i++)
    {
        if (s[i].total > mx) // if students marks are greater than the current max, the student is stored as topper and max marks are reassigned to their marks
        {
            topper = i;
            mx = s[i].total;
        }
    }
    // Printing details of topper
    printf("\nTopper:  Roll No = %d, Name = %s, Total = %d, Percentage = %.2f, Grade = %c",
           s[topper].roll_no, s[topper].name, s[topper].total, s[topper].percentage, s[topper].grade);
};

int main()
{
    printf("\n2025300063 Omkar Anil Gajare\n\n");
    int choice = 0;        // Assignment of switch variable
    int n = 0;             // Assignment of number of students variable
    struct Student s[100]; // Assignment of blank students only to be initilized when input is taken
    int rsearch;           // Assignment of roll number to be searched variable
    while (choice != 5)
    {
        // MENU SETUP
        printf("\n\n--- Student Result Management ---");
        printf("\n1. Input Students");
        printf("\n2. Display Students");
        printf("\n3. Search by Roll No.");
        printf("\n4. Show Topper");
        printf("\n5. Exit");
        printf("\nEnter Choice: ");
        scanf("%d", &choice); // Input of switch variable
        /*Switch Menu*/
        switch (choice)
        {
        case 1:
            printf("Enter number of students: ");
            scanf("%d", &n);     // Input of number of students
            inputStudents(s, n); // Calling to store data of n students
            break;
        case 2:
            displayStudents(s, n); // Calling to print data of all students
            break;
        case 3:
            printf("Enter Roll Number to be searched: ");
            scanf("%d", &rsearch);       // Data entry of roll number to be searched
            searchByRoll(s, n, rsearch); // Calling to print searched roll number function
            break;
        case 4:
            highestScorer(s, n); // Calling to print details of the topper
            break;
        case 5:
            break;
        }
    }
    printf("Exiting...");
    printf("\n\n2025300063 Omkar Anil Gajare\n");
    return 0;
}
