#include <math.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>

int *queue = NULL;

// variable to store index of first and last element
int front, rear;
int N;

int isFull() { return rear == N - 1 ? 1 : 0; }

int isEmpty() { return front == -1 ? 1 : 0; }

void enqueue(int value) {
  if (isFull()) {
    // printf("Queue Overflow!\n");
    return;
  }
  if (isEmpty()) {
    front = 0;
  }
  rear++;
  queue[rear] = value;
  // printf("Element %d inserted succesfully\n", value);
}

int dequeue() {
  int value;
  if (isEmpty()) {
    // printf("Queue is empty!\n");
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

int peek() {
  if (isEmpty()) {
    // printf("Queue is empty!\n");
    return -1;
  }
  return queue[front];
  // printf("Next Task To be executed is: %d\n", queue[front]);
}

// changed display to not printing to reduce I/O overhead but to add them to a
// variable, still O(n)
long display() {
  long x = 0;
  if (isEmpty())
    return x;
  for (int i = front; i <= rear; i++) {
    x += queue[i];
  }
  return x;
}

int main() {
  srand((unsigned int)time(NULL));

  int T = 100;

  int N_values[] = {1000,   5000,   10000,  20000,  30000,  40000,
                    50000,  60000,  70000,  80000,  90000,  100000,
                    110000, 120000, 140000, 160000, 180000, 200000};
  int num_N = sizeof(N_values) / sizeof(N_values[0]);

  FILE *fp = fopen("results.csv", "w");
  if (!fp) {
    printf("error opening file\n");
    return 0;
  }
  fprintf(fp, "Run,N,Enqueue,Dequeue,Peek,IsEmpty,IsFull,Display\n");

  for (int n_idx = 0; n_idx < num_N; n_idx++) {
    N = N_values[n_idx];

    for (int iter = 1; iter <= T; iter++) {
      queue = (int *)malloc(N * sizeof(int));
      if (queue == NULL) {
        printf("malloc failed on iter %d", iter);
        break;
      }
      front = -1;
      rear = -1;

      clock_t start, end;
      double avgEnqueue, avgDequeue, avgPeek, avgIsEmpty, avgIsFull, avgDisplay;

      // Enqueue N times, populates the queue
      start = clock();
      for (int i = 0; i < N; i++) {
        enqueue(i);
      }
      end = clock();
      avgEnqueue = ((double)(end - start) / CLOCKS_PER_SEC) / N;

      // Display N times,
      start = clock();
      display();
      end = clock();
      avgDisplay = ((double)(end - start)) / CLOCKS_PER_SEC;

      // Peek N times,
      start = clock();
      for (int i = 0; i < N; i++)
        peek();
      end = clock();
      avgPeek = ((double)(end - start) / CLOCKS_PER_SEC) / N;

      // isEmpty N times
      start = clock();
      for (int i = 0; i < N; i++)
        isEmpty();
      end = clock();
      avgIsEmpty = ((double)(end - start) / CLOCKS_PER_SEC) / N;

      // isFull N times
      start = clock();
      for (int i = 0; i < N; i++)
        isFull();
      end = clock();
      avgIsFull = ((double)(end - start) / CLOCKS_PER_SEC) / N;

      // dequeue N items
      start = clock();
      for (int i = 0; i < N; i++)
        dequeue();
      end = clock();
      avgDequeue = ((double)(end - start) / CLOCKS_PER_SEC) / N;

      fprintf(fp, "%d,%d,%.9f,%.9f,%.9f,%.9f,%.9f,%.9f\n", iter, N, avgEnqueue,
              avgDequeue, avgPeek, avgIsEmpty, avgIsFull, avgDisplay);
      free(queue);
      queue = NULL;

      printf("Run %3d/%d done (N=%6d)\n", iter, T, N);
    }
  }
  fclose(fp);
  printf("\nAll runs complete. Results written to results.csv\n");
}
