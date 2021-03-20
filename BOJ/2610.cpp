#include <iostream>
#include <algorithm>
using namespace std;

int queue[100001], front, rear, from, to;
int graph[101][101], cnt, M, result[101], resultCnt;
bool visit[101];

int min(int a, int b) { return (a < b ? a : b); }
void push(int item)
{
	rear = (rear + 1) % 100001;
	queue[rear] = item;
}

void pop()
{
	front = (front + 1) % 100001;
}

int getFront()
{
	int temp = (front + 1) % 100001;
	return queue[temp];
}

int solve(int start)
{
	int arr[101], cur = start;
	bool check[101];
	for (int i = 1; i <= cnt; i++)
	{
		arr[i] = 2123456789;
		check[i] = false;
	}
	arr[start] = 0;
	check[start] = true;
	int max = -1, minIndex = cur, minNum = 2123456789;

	while (1)
	{
		check[cur] = true;
		for (int i = 1; i <= cnt; i++)
		{
			if (i == start) continue;

			if (graph[cur][i] == 1)
			{
				arr[i] = min(arr[i], arr[cur] + 1);
				if (arr[i] > max) max = arr[i];
				
			}
		}

		for (int i = 1; i <= cnt; i++)
		{
			if (arr[i] < minNum && check[i] == false)
			{
				minNum = arr[i];
				minIndex = i;
			}
		}

		if (minIndex == cur) break;
		cur = minIndex;
		minNum = 2123456789;
	}

	return max;
}

void bfs(int start)
{
	bool check[101];
	for (int i = 1; i <= cnt; i++) check[i] = false;
	front = rear = -1;
	push(start);
	int cur;

	while (front != rear)
	{
		cur = getFront();
		pop();

		if (visit[cur] == true) continue;
		visit[cur] = true;
		check[cur] = true;

		for (int i = 1; i <= cnt; i++)
		{
			if (i == cur) continue;

			if (graph[cur][i] == 1) push(i);
		}
	}

	int minNum = 2123456789;
	int index;
	
	for (int i = 1; i <= cnt; i++)
	{
		if (check[i] == true)
		{
			int temp = solve(i);
			if (temp == -1)
			{
				index = i;
				break;
			}

			if (temp < minNum)
			{
				minNum = temp;
				index = i;
			}
		}
	}

	result[resultCnt++] = index;
}

int main()
{
	cin >> cnt >> M;
	for (int i = 0; i < M; i++)
	{
		cin >> from >> to;
		graph[from][to] = 1;
		graph[to][from] = 1;
	}

	for (int i = 1; i <= cnt; i++)
	{
		if (visit[i] == false) bfs(i);
	}
	
	sort(result, result + resultCnt);
	cout << resultCnt << '\n';
	for (int i = 0; i < resultCnt; i++)
	{
		cout << result[i] << '\n';
	}
	return 0;
}