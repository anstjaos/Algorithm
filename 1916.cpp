#include <iostream>
using namespace std;

#define MAX_WEIGHT 2123456789
#define QUEUE_SIZE 1000001


int n, m, queue[QUEUE_SIZE], front,rear;
bool inQ[1001];
int map[1001][1001];
int dist[1001];

void push(int item)
{
	rear = (rear + 1) % QUEUE_SIZE;
	queue[rear] = item;
}

void pop()
{
	front = (front + 1) % QUEUE_SIZE;
}

int getFront()
{
	int temp = (front + 1) % QUEUE_SIZE;
	return queue[temp];
}

void solve(int start)
{
	front = rear = -1;
	dist[start] = 0;
	inQ[start] = true;
	push(start);

	int cur;

	while (front != rear)
	{
		cur = getFront();
		pop();
		inQ[cur] = false;

		for (int i = 1; i <= n; i++)
		{
			if (map[cur][i] == MAX_WEIGHT) continue;

			if (dist[cur] + map[cur][i] < dist[i])
			{
				dist[i] = dist[cur] + map[cur][i];
				if (inQ[i] == false) push(i);
			}
		}
	}
}

int main()
{
	cin >> n >> m;
	
	int from, to, weight ,start, desti;
	for (int i = 1; i <= n; i++)
	{
		for (int j = 1; j <= n; j++) map[i][j] = MAX_WEIGHT;
		dist[i] = MAX_WEIGHT;
	}

	for (int i = 0; i < m; i++)
	{
		cin >> from >> to >> weight;
		if(map[from][to] > weight) map[from][to] = weight;
	}

	cin >> start >> desti;

	solve(start);

	cout << dist[desti] << '\n';
	return 0;
}