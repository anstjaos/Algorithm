#include <iostream>
using namespace std;

int testCase, N, M;
int map[1001][1001];
bool visit[1001];
int cnt;
int from, to;
int queue[100001];
int front, rear;

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

bool isEmpty()
{
	if (front == rear) return true;
	else return false;
}

void bfs()
{
	bool flag = false;
	for (int i = 1; i <= N; i++)
	{
		for (int j = 1; j <= N; j++)
		{
			if (map[i][j] == 1)
			{
				push(i);
				visit[i] = true;
				flag = true;
				break;
			}
		}
		if (flag == true) break;
	}
	int cur;
	while (!isEmpty())
	{
		cur = getFront();
		pop();

		for (int i = 1; i <= N; i++)
		{
			if (map[cur][i] == 1 && visit[i] == false)
			{
				visit[i] = true;
				push(i);
				cnt++;
			}
		}
	}
}

int main()
{
	cin >> testCase;
	for (int i = 0; i < testCase; i++)
	{
		cin >> N >> M;
		cnt = 0;
		front = rear = -1;
		for (int j = 1; j <= N; j++)
		{
			for (int k = 1; k <= N; k++)
			{
				
				map[j][k] = 0;
			}
			visit[j] = false;
		}
		
		for (int j = 0; j < M; j++)
		{
			cin >> from >> to;
			map[from][to] = 1;
			map[to][from] = 1;
		}
		bfs();
		cout << cnt << endl;
	}
}