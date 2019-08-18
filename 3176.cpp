#include <stdio.h>
#define MAX_COUNT 100001
typedef struct Edge {
	int to;
	int cost;
	Edge* next;
}Edge;

Edge edgePool[MAX_COUNT * 2];
int edgeCnt;
Edge* edge[MAX_COUNT];
int N, M, parent[MAX_COUNT][18], minLen[MAX_COUNT][18], maxLen[MAX_COUNT][18];
int minAns, maxAns, queue[MAX_COUNT], front, rear, depth[MAX_COUNT];

void push(int item)
{
	rear = (rear + 1) % MAX_COUNT;
	queue[rear] = item;
}

int pop()
{
	front = (front + 1) % MAX_COUNT;
	return queue[front];
}

void insertEdge(int from, int to, int cost)
{
	edgePool[edgeCnt] = { to, cost, 0 };
	Edge* newNode = &edgePool[edgeCnt++];

	if (edge[from] == 0) edge[from] = newNode;
	else {
		newNode->next = edge[from];
		edge[from] = newNode;
	}
}

int min(int a, int b) { return (a < b ? a : b); }
int max(int a, int b) { return (a > b ? a : b); }

void bfs()
{
	front = rear = -1;
	push(1);
	depth[1] = 1;

	while (front != rear)
	{
		int cur = pop();
		Edge* ptr = edge[cur];
		while (ptr != 0)
		{
			if (depth[ptr->to] == 0)
			{
				depth[ptr->to] = depth[cur] + 1;
				minLen[ptr->to][0] = ptr->cost;
				maxLen[ptr->to][0] = ptr->cost;
				parent[ptr->to][0] = cur;
				push(ptr->to);
			}
			ptr = ptr->next;
		}
	}

	for (register int j = 1; j < 18; j++) {
		for (register int i = 1; i <= N; i++) {
			if (parent[i][j - 1] != 0) {
				parent[i][j] = parent[parent[i][j - 1]][j - 1];
				minLen[i][j] = minLen[i][j - 1];
				maxLen[i][j] = maxLen[i][j - 1];

				if (parent[parent[i][j - 1]][j - 1] != 0) {
					minLen[i][j] = min(minLen[i][j-1], minLen[parent[i][j-1]][j-1]);
					maxLen[i][j] = max(maxLen[i][j - 1], maxLen[parent[i][j - 1]][j - 1]);
				}
			}
		}
	}
}

void findLCA(int u, int v)
{
	if (depth[u] < depth[v]) {
		int temp = u;
		u = v;
		v = temp;
	}

	minAns = 2123456789;
	maxAns = 0;
 	int diff = depth[u] - depth[v];
	for (register int i = 0; diff; i++) {
		if (diff % 2) {
			minAns = min(minAns, minLen[u][i]);
			maxAns = max(maxAns, maxLen[u][i]);
			u = parent[u][i];
		}
		diff /= 2;
	}

	if (u == v) return;

	for (register int i = 17; i >= 0; i--) {
		if (parent[u][i] != 0 && parent[u][i] != parent[v][i]) {
			minAns = min(minAns, minLen[u][i]);
			maxAns = max(maxAns, maxLen[u][i]);
			u = parent[u][i];

			minAns = min(minAns, minLen[v][i]);
			maxAns = max(maxAns, maxLen[v][i]);
			v = parent[v][i];
		}
	}

	minAns = min(minAns, min(minLen[v][0], minLen[u][0]));
	maxAns = max(maxAns, max(maxLen[u][0], maxLen[v][0]));
}

int main()
{
	scanf("%d ", &N);

	int a, b, c;
	for (register int i = 0; i < N - 1; i++)
	{
		scanf("%d %d %d", &a, &b, &c);
		insertEdge(a, b, c);
		insertEdge(b, a, c);
	}

	bfs();
	scanf("%d", &M);
	for (register int i = 0; i < M; i++)
	{
		scanf("%d %d", &a, &b);
		findLCA(a, b);
		printf("%d %d\n", minAns, maxAns);
	}
	return 0;
}