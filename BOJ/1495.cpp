#include <iostream>
using namespace std;

#define QUEUE_SIZE 10000000
int queue[QUEUE_SIZE], front, rear;
int N, M, S, vol[102];

void push(int item)
{
	rear = (rear + 1) % QUEUE_SIZE;
	queue[rear] = item;
}

int pop()
{
	front = (front + 1) % QUEUE_SIZE;
	return queue[front];
}

bool isEmpty()
{
	return front == rear;
}

bool solve()
{
	front = rear = -1;
	push(S);

	for (int i = 0; i < N; i++)
	{
		if (isEmpty()) return false;
		int size = rear - front;

		for (int j = 0; j < size; j++)
		{
			int cur = pop();
			
			if (cur - vol[i] >= 0) push(cur - vol[i]);
			if (cur + vol[i] <= M) push(cur + vol[i]);
		}
	}

	return true;
}

int max(int a, int b) { return (a > b ? a : b); }

int main()
{
	scanf("%d %d %d", &N, &S, &M);
	for (int i = 0; i < N; i++) scanf("%d", vol + i);

	if (!solve()) printf("-1\n");
	else
	{
		int result = -1;
		for (int i = front + 1; i <= rear; i++) result = max(result, queue[i]);

		printf("%d\n", result);
	}
	return 0;
}