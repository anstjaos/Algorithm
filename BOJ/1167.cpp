#include <iostream>
#include <vector>
#include <queue>
using namespace std;

#define INF 2123456789
typedef struct a{
	int to;
	int wei;
	a() {}
	a(int t, int w) {
		to = t;
		wei = w;
	}
}Edge;
int V, from, to, wei, cost[100001];
vector<Edge> edgeVec[100001];

int bfs(int start)
{
	for (register int i = 1; i <= V; i++) cost[i] = INF;
	queue<int> q;
	q.push(start);
	cost[start] = 0;
	while (!q.empty())
	{
		int cur = q.front();
		q.pop();

		for (Edge next : edgeVec[cur])
		{
			if (cost[next.to] != INF) continue;

			cost[next.to] = cost[cur] + next.wei;
			q.push(next.to);
		}
	}
	int index = 1;
	for (register int i = 1; i <= V; i++) {
		if (cost[index] < cost[i]) index = i;
	}
	return index;
}

int main()
{
	scanf("%d", &V);
	for (register int i = 0; i < V; i++)
	{
		scanf("%d", &from);
		while (1)
		{
			scanf("%d", &to);
			if (to == -1) break;
			scanf("%d", &wei);
			edgeVec[from].push_back({ to, wei });
		}
	}

	int y = bfs(1);
	int z = bfs(y);

	printf("%d\n", cost[z]);
	return 0;
}