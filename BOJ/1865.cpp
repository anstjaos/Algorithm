#include <stdio.h>
#define INF 2123456789
typedef struct Edge {
	int from;
	int to;
	int cost;
}Edge;

int N, M, W, tc;
int cost[501];
Edge edgeArr[5500];

int min(int a, int b) { return (a < b ? a : b); }
int max(int a, int b) { return (a > b ? a : b); }

bool bellmanFord()
{
	cost[1] = 0;
	for (register int i = 0; i < N; i++) {
		for (register int j = 0; j < 2*M+W; j++) {
			if (cost[edgeArr[j].from] == INF) continue;
			
			cost[edgeArr[j].to] = min(cost[edgeArr[j].to], cost[edgeArr[j].from] + edgeArr[j].cost);
		}
	}

	for (register int j = 0; j < 2 * M + W; j++) {
		if (cost[edgeArr[j].from] == INF) continue;

		if (cost[edgeArr[j].to] > cost[edgeArr[j].from] + edgeArr[j].cost) return false;
	}

	return true;
}

int main()
{
	scanf("%d", &tc);
	while (tc--)
	{
		scanf("%d %d %d", &N, &M, &W);
		for (register int i = 0; i <= N; i++) {
			cost[i] = INF;
		}

		int s, e, t;
		for (register int i = 0; i < M; i++) {
			scanf("%d %d %d", &s, &e, &t);
			edgeArr[i * 2] = { s,e,t };
			edgeArr[i * 2 + 1] = { e,s,t };
		}

		for (register int i = 2*M; i < 2*M+W; i++) {
			scanf("%d %d %d", &s, &e, &t);
			edgeArr[i] = { s,e,-t };
		}

		bellmanFord() ? printf("NO\n") : printf("YES\n");
	}

	return 0;
}