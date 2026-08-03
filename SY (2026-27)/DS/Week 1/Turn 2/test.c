#include <stdio.h>
#include <stdlib.h>
#include <time.h>

typedef struct {
  int *arr;
  int front, rear, size;
} Queue;

void initQueue(Queue *q, int size) {
  q->arr = malloc(size * sizeof(int));
  q->front = -1;
  q->rear = -1;
  q->size = size;
}

int isFull(Queue *q) { return q->rear == q->size - 1; }
int isEmpty(Queue *q) { return q->front == -1; }

void enqueue(Queue *q, int value) {
  if (isFull(q))
    return;
  if (isEmpty(q))
    q->front = 0;
  q->arr[++q->rear] = value;
}

int dequeue(Queue *q) {
  if (isEmpty(q))
    return -1;
  int value = q->arr[q->front];
  if (q->front == q->rear) {
    q->front = -1;
    q->rear = -1;
  } else {
    q->front++;
  }
  return value;
}

// Runs N/2 random enqueue/dequeue ops on a fresh queue of given size, returns
// time in ms
double runTrial(int N) {
  Queue q;
  initQueue(&q, N);
  int ops = N / 2;

  clock_t start = clock();
  for (int i = 0; i < ops; i++) {
    if (rand() % 2 == 0 && !isFull(&q))
      enqueue(&q, rand() % 1000);
    else if (!isEmpty(&q))
      dequeue(&q);
  }
  clock_t end = clock();

  free(q.arr);
  return ((double)(end - start)) / CLOCKS_PER_SEC * 1000.0;
}

int main() {
  int T = 100;
  srand((unsigned)time(NULL));

  printf("N,AvgTime(ms)\n");
  for (int N = 1000; N <= 100000; N += 1000) {
    double total = 0;
    for (int t = 0; t < T; t++)
      total += runTrial(N);
    printf("%d,%.6f\n", N, total / T);
  }

  return 0;
}
