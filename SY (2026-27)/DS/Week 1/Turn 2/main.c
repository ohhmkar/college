#include <math.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX 100

int queue[MAX];

// variable to store index of first and last element
int front = -1;
int rear = -1;

int isFull() { return rear == MAX - 1 ? 1 : 0; }

int isEmpty() { return front == -1 ? 1 : 0; }

void enqueue(int value) {
  if (isFull()) {
    printf("Queue Overflow!\n");
    return;
  }
  if (isEmpty()) {
    front = 0;
  }
  rear++;
  queue[rear] = value;
  printf("Element %d inserted succesfully\n", value);
}

int dequeue() {
  int value;

  if (isEmpty()) {
    printf("Queue is empty!\n");
    return -1;
  }

  value = queue[front];

  if (front == rear) {
    front = -1;
    rear = -1;
  } else {
    front++;
  }
  return value;
}

void peek() {
  if (isEmpty()) {
    printf("Queue is empty!\n");
    return;
  }
  printf("Next Task To be executed is: %d\n", queue[front]);
}

void display() {
  if (isEmpty()) {
    printf("Queue is empty!\n");
    return;
  }

  printf("Queue Elements: ");
  for (int i = front; i <= rear; i++) {
    printf("%d ", queue[i]);
  }
  printf("\n");
}

int main() {
  int n = 10;
  int x;
  printf("=== Omkar's Task Scheduler ===\n");
  do {
    printf("\n");
    printf("1. Add A New Task\n");
    printf("2. Execute Queued Task\n");
    printf("3. View Next Task\n");
    printf("4. View All Tasks\n");
    printf("0. Quit Program\n");
    printf("Enter your choice: ");
    scanf("%d", &n);

    switch (n) {
    case 1:
      printf("Enter the new task: ");
      scanf("%d", &x);
      enqueue(x);
      break;
    case 2:
      dequeue();
      break;
    case 3:
      peek();
      break;
    case 4:
      display();
      break;
    case 0:
      printf("Exiting program....");
      break;
    default:
      printf("Invalid Input! Try again");
      break;
    }
  } while (n != 0);
}
