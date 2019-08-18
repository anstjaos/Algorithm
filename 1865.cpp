#include <iostream>
#include <queue>
using namespace std;

#define INF 2123456789
int tc, N, M, W, from, to, wei;
int edge[501][501], warmhall[501][501], cost[501], check[501];
bool inQ[501];

bool solve()
{
	queue<int> q;
	for (register int i = 1; i <= N; i++) inQ[i] = false;

	for (register int i = 2; i <= N; i++) {
		if (warmhall[1][i] != INF)
		{
			cost[i] = -warmhall[1][i];
			q.push(i);
			inQ[i] = true;
		}
		else if(edge[1][i] != INF)
		{
			cost[i] = edge[1][i];
			q.push(i);
			inQ[i] = true;
		}
	}

	while (!q.empty())
	{
		int cur = q.front();
		q.pop();
		inQ[cur] = false;
		check[cur]++;
		if (check[cur] >= N) return false;

		for (register int i = 1; i <= N; i++)
		{
			if (warmhall[cur][i] != INF)
			{
				if (cost[i] > cost[cur] - warmhall[cur][i])
				{
					cost[i] = cost[cur] - warmhall[cur][i];
					if (inQ[i] == false) {
						q.push(i);
						inQ[i] = true;
					}
				}
			}
			else if (edge[cur][i] != INF)
			{
				if (cost[i] > cost[cur] + edge[cur][i])
				{
					cost[i] = cost[cur] + edge[cur][i];
					if (inQ[i] == false) {
						q.push(i);
						inQ[i] = true;
					}
				}
			}
		}
	}

	return true;
}

int main()
{
	scanf("%d", &tc);
	while (tc--)
	{
		scanf("%d%d%d", &N, &M, &W);
		for (register int i = 1; i <= N; i++)
		{
			cost[i] = INF;
			check[i] = 0;
			for (register int j = 1; j <= N; j++) {
				edge[i][j] = INF;
				warmhall[i][j] = INF;
			}
		}
		for (register int i = 0; i < M; i++)
		{
			scanf("%d%d%d", &from, &to, &wei);
			if(edge[from][to] == INF || edge[from][to] > wei) edge[from][to] = wei;
			if (edge[to][from] == INF || edge[to][from] > wei) edge[to][from] = wei;
		}
		for (register int i = 0; i < W; i++)
		{
			scanf("%d%d%d", &from, &to, &wei);
			if (warmhall[from][to] == INF || warmhall[from][to] < wei) warmhall[from][to] = wei;
			
		}
		
		if (!solve()) printf("YES\n");
		else printf("NO\n");
	}
	return 0;
}