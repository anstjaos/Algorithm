#include <stdio.h>
#define MAX_COUNT 100001
typedef struct Edge{
	int to;
	Edge *next;
}Edge;

Edge edgePool[MAX_COUNT*2];
int edgeCnt;
Edge *edge[MAX_COUNT];

int N, M, tin[MAX_COUNT], tout[MAX_COUNT], check, parent[MAX_COUNT][18], height;

void insertEdge(int from, int to)
{
	edgePool[edgeCnt] = { to, 0 };
	Edge *newEdge = &edgePool[edgeCnt++];
	
	if (edge[from] == 0) edge[from] = newEdge;
	else {
		newEdge->next = edge[from];
		edge[from] = newEdge;
	}
}

void dfs(int cur, int p)
{
	tin[cur] = ++check;
	parent[cur][0] = p;
	for (register int i = 1; i <= height; i++) {
		parent[cur][i] = parent[parent[cur][i - 1]][i - 1];
	}

	Edge *ptr = edge[cur];
	while (ptr != 0)
	{
		if (ptr->to == p) {
			ptr = ptr->next;
			continue;
		}

		dfs(ptr->to, cur);
		ptr = ptr->next;
	}
	tout[cur] = ++check;
}

bool upper(int a, int b)
{
	return (tin[a] <= tin[b] && tout[a] >= tout[b]);
}

int findLCA(int a, int b)
{
	if (upper(a, b)) return a;
	if (upper(b, a)) return b;

	for (register int i = height; i >= 0; i--) {
		if (!upper(parent[a][i], b)) {
			a = parent[a][i];
		}
	}

	return parent[a][0];
}

int main()
{
	scanf("%d", &N);
	for (height = 1; (1 << height) <= N; height++);
	height -= 1;

	int a, b, c;
	for (register int i = 0; i < N - 1; i++)
	{
		scanf("%d %d", &a, &b);
		insertEdge(a, b);
		insertEdge(b, a);
	}

	dfs(1, 1);
	scanf("%d", &M);
	for (register int i = 0; i < M; i++)
	{
		scanf("%d %d ", &a, &b);
		printf("%d\n", findLCA(a, b));
	}

	return 0;
}