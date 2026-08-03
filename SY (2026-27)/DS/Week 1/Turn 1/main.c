#include <stdio.h>
#include <stdlib.h>
#define MAX 100

int stack[MAX]; // initializing the stack to the MAX size set
int top = -1;   // initializing the stack top pointer

int main()
{
    int n = 10;
    // menu setup for the game
    printf("=== Dungeon Crawler! ===\n");
    do
    {
        printf("\n");
        printf("Potential Options: \n");
        printf("1. UP\n");
        printf("2. LEFT\n");
        printf("3. RIGHT\n");
        printf("4. DOWN\n");
        printf("5. DELETE PREVIOUS MOVE\n");
        printf("6. SHOW RECENT MOVE\n");
        printf("7. SHOW ALL MOVES\n");
        printf("0. EXIT\n");
        scanf("%d", &n);
        switch (n)
        {
        case 1:
            push(1); // move up case
            break;
        case 2:
            push(2); // move left case
            break;
        case 3:
            push(3); // move right case
            break;
        case 4:
            push(4); // move down case
            break;
        case 5:
            int x = pop(); // remove previous move case
            break;
        case 6:
            // peeking most recent move
            printf("Recent Move: ");
            peek();
            printf("\n");
            break;
        case 7:
            // displaying all moves
            display();
            break;
        case 0:
            // break case
            break;
        default:
            // default case
            printf("irregular input! exiting....");
            n = 0;
            break;
        }
    } while (n != 0);
}

/**
 * Function to check if stack is empty or not, returns 1 if empty else 0
 * Date : 27/6/26
 */
int isEmpty()
{
    return top == -1 ? 1 : 0;
}
/**
 * Function to check if stack is full or not, returns 1 if full else 0
 * Date : 27/6/26
 */
int isFull()
{
    return top == (MAX - 1) ? 1 : 0;
}

/**
 * Function to add value to the top of the stack
 * Input: Value to be pushed on the top of the stack
 * Date : 27/6/26
 */
void push(int x)
{
    if (isFull())
    {
        printf("Stack Overflow!");
        return;
    }
    top++;
    stack[top] = x;
}
/**
 * Function to remove topmost value of the stack
 * Returns: Value that is popped from the top of the stack
 * Date : 27/6/26
 */
int pop()
{
    int x;
    if (isEmpty())
    {
        printf("Nothing to be popped!");
        return;
    }
    x = stack[top];
    top--;

    return x;
}
/**
 * Helper function to convert moves from int to human interpretable language
 * Date: 27/6/26
 */
void interpret(int x)
{
    switch (x)
    {
    case 1:
        printf("Up");
        break;
    case 2:
        printf("Left");
        break;
    case 3:
        printf("Right");
        break;
    case 4:
        printf("Down");
        break;
    }
}

/**
 * Function to return element at the top of the stack
 * Returns: Element at the top of the stack, if stack is empty returns -1
 * Date : 27/6/26
 */
int peek()
{
    if (isEmpty())
    {
        printf("No moves done!");
        return -1;
    }
    interpret(stack[top]);
    return 0;
}
/**
 * Function to print all elements in the stack going topdown
 * Date : 27/6/26
 */
void display()
{
    if (isEmpty())
    {
        printf("Empty!");
    }
    for (int i = top; i >= 0; i--)
    {
        interpret(stack[i]);
        printf("\n");
    }
}
