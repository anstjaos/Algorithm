#include <iostream>
using namespace std;

int N, M, start;
int map[1002][1002];
int queue[1000002];
int front, rear;
bool check[1002];

void push(int index)
{
	rear = (rear + 1) % 1000002;
	queue[rear] = index;
}

void pop()
{
	front = (front + 1) % 1000002;
}

int getFront()
{
	int temp = (front + 1) % 1000002;
	return queue[temp];
}

bool isEmpty()
{
	if (front == rear) return true;
	else return false;
}

void dfs(int start)
{
	check[start] = true;
	cout << start << " ";
	for (int i = 1; i <= N; i++)
	{
		if (map[start][i] == 1 && check[i] == false)
		{
			check[i] = true;
			dfs(i);
		}
	}
}

void bfs(int start)
{
	push(start);
	check[start] = true;
	int cur;
	while (!isEmpty())
	{
		cur = getFront();
		pop();
		cout << cur << " ";
		

		for (int i = 1; i <= N; i++)
		{
			if (map[cur][i] == 1 && check[i] == false)
			{
				push(i);
				check[i] = true;
			}
		}
	}
}

int main()
{
	cin >> N >> M >> start;
	for (int i = 0; i < M; i++)
	{
		int from, to;
		cin >> from >> to;
		map[from][to] = 1;
		map[to][from] = 1;
	}

	dfs(start);
	cout << endl;
	for (int i = 1; i <= N; i++) check[i] = false;
	bfs(start);
	cout << endl;
}