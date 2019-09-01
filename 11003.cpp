#include <stdio.h>
#define MAX_SIZE 5000003

typedef struct {
	int num;
	int idx;
}Data;

int arr[MAX_SIZE], front, rear;
Data queue[MAX_SIZE];
int N, L, res[MAX_SIZE];

void push(Data item)
{
	rear = (rear + 1) % MAX_SIZE;
	queue[rear] = item;
}

Data popFront()
{
	front = (front + 1) % MAX_SIZE;
	return queue[front];
}

Data popRear()
{
	Data ret = queue[rear];
	rear = (rear - 1 + MAX_SIZE) % MAX_SIZE;
	return ret;
}

Data getFront()
{
	int idx = (front + 1) % MAX_SIZE;
	return queue[idx];
}

Data getRear()
{
	return queue[rear];
}

int main()
{
	scanf("%d %d", &N, &L);
	for (register int i = 0; i < N; i++) scanf("%d", arr + i);

	for (register int i = 0; i < N; i++) {
		int cur = arr[i];
		if (front != rear && getFront().idx <= i - L) popFront();
		while (front != rear && getRear().num > cur) popRear();

		push({ cur, i });
		res[i] = getFront().num;
	}

	for (register int i = 0; i < N; i++) printf("%d ", res[i]);
	printf("\n");
	return 0;
}