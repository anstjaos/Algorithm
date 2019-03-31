#include <iostream>
#include <queue>
using namespace std;

#define MAX_INT 2123456789
int map[801][801], check1, check2, vertex, edge;
bool visit[801];

int dijkstra(int start, int desti)
{
	queue<int> q;
	int dist[801];
	bool inQ[801];

	for (int i = 1; i <= vertex; i++)
	{
		if (i == start) dist[i] = 0;
		else dist[i] = MAX_INT;

		inQ[i] = false;
	}

	q.push(start);
	inQ[start] = true;
	while (!q.empty())
	{
		int cur = q.front();
		q.pop();
		inQ[cur] = false;

		for (int i = 1; i <= vertex; i++)
		{
			if (i == cur || map[cur][i] == 0) continue;

			if (dist[i] > map[cur][i] + dist[cur])
			{
				dist[i] = map[cur][i] + dist[cur];

				if (inQ[i] == false)
				{
					q.push(i);
					inQ[i] = true;
				}
			}
		}
	}
	return dist[desti];
}
	
int findRoot(int start, int visit1, int visit2, int desti)
{
	int a = dijkstra(start, visit1);
	int b = dijkstra(visit1, visit2);
	int c = dijkstra(visit2, desti);

	if (a == MAX_INT || b == MAX_INT || c == MAX_INT) return -1;

	return (a + b + c);
}

int main()
{
	cin >> vertex >> edge;
	for (int i = 0; i < edge; i++)
	{
		int from, to, weight;

		cin >> from >> to >> weight;
		map[from][to] = weight;
		map[to][from] = weight;
	}

	cin >> check1 >> check2;

	int root1= findRoot(1, check1, check2, vertex);
	int root2 = findRoot(1, check2, check1, vertex);

	int result;

	if (root1 == -1 && root2 != -1) result = root2;
	else if (root1 != -1 && root2 == -1) result = root1;
	else if (root1 == -1 && root2 == -1) result = -1;
	else result = (root1 < root2 ? root1 : root2);

	std::cout << result << endl;
	return 0;
}