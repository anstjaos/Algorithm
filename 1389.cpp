#include <iostream>
using namespace std;

int friends[101][101], visit[101];
int N, M, queue[100001], front, rear;
int minCnt = 2123456789, minNum;
void push(int index)
{
	rear = (rear + 1) % 100001;
	queue[rear] = index;
}

void pop()
{
	front = (front + 1) % 100001;
}

int getFront()
{
	int temp = (front + 1) % 100001;
	return	queue[temp];
}

int bfs(int start)
{
	front = rear = -1;
	for (int i = 1; i <= N; i++) visit[i] = 0;
	push(start);
	int cur;

	while (front != rear)
	{
		cur = getFront();
		pop();

		for (int i = 1; i <= N; i++)
		{
			if (i == cur) continue;

			if (visit[i] == 0 && friends[cur][i] == 1)
			{
				push(i);
				visit[i] = visit[cur] + 1;
			}
		}
	}
	int result = 0;
	for (int i = 1; i <= N; i++)
	{
		result = result + visit[i];
	}
	return result;
}

int main()
{
	cin >> N >> M;
	int from, to;

	for (int i = 0; i < M; i++)
	{
		cin >> from >> to;
		friends[from][to] = 1;
		friends[to][from] = 1;
	}
	int result;
	for (int i = 1; i <= N; i++)
	{
		result = bfs(i);
		if (result < minCnt)
		{
			minCnt = result;
			minNum = i;
		}
	}

	cout << minNum << endl;
	return 0;
}