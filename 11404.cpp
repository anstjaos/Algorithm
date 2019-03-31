#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

#define QUEUE_SIZE 100002

typedef struct {
	int to, cost;
}road;

int n, m, a, b, c;
int queue[QUEUE_SIZE];
int front, rear;
bool inqueue[101];
int arr[101][101];
int result[101][101];

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

void floydWarshall(int start)
{
	rear = front = -1;
	for (int i = 1; i <= n; i++)
	{
		if (arr[start][i] != 0)
		{
			result[start][i] = arr[start][i];
			push(i);
			inqueue[i] = true;
		}
	}

	while (!isEmpty())
	{
		int cur = pop();
		inqueue[cur] = false;

		for (int i = 1; i <= n; i++)
		{
			if (i == start || i == cur || arr[cur][i] == 0) continue;

			if (result[start][cur] + arr[cur][i] < result[start][i] || result[start][i] == 0)
			{
				result[start][i] = result[start][cur] + arr[cur][i];
				if (inqueue[i] == false)
				{
					inqueue[i] = true;
					push(i);
				}
			}
		}
	}
}

int main()
{
	scanf("%d %d", &n, &m);

	for (int i = 0; i < m; i++)
	{
		scanf("%d %d %d", &a, &b, &c);
		if (arr[a][b] == 0 || arr[a][b] > c)
		{
			arr[a][b] = c;
		}
	}

	for (int i = 1; i <= n; i++) floydWarshall(i);

	for (int i = 1; i <= n; i++)
	{
		for (int j = 1; j <= n; j++) printf("%d ", result[i][j]);

		printf("\n");
	}
}