#include <stdio.h>
#define INF 2123456789

typedef struct {
	int from;
	int cost;
}Vertex;

int N, M, map[1001][1001], cost[1005];
Vertex minHeap[1000005];
int heapSize, start, dest;

void push(Vertex item)
{
	minHeap[++heapSize] = item;

	int idx = heapSize;
	while (idx > 1)
	{
		if (minHeap[idx / 2].cost < minHeap[idx].cost) break;
		Vertex temp = minHeap[idx / 2];
		minHeap[idx / 2] = minHeap[idx];
		minHeap[idx] = temp;

		idx /= 2;
	}
}

Vertex pop()
{
	Vertex ret = minHeap[1];
	minHeap[1] = minHeap[heapSize--];

	int idx = 1;
	int child = 1;

	while (1)
	{
		if (idx * 2 > heapSize) break;
		
		if (idx * 2 == heapSize) {
			child = idx * 2;
		}
		else {
			if (minHeap[idx * 2].cost < minHeap[idx * 2 + 1].cost) child = idx * 2;
			else child = idx * 2 + 1;
		}

		if (minHeap[idx].cost < minHeap[child].cost) break;

		Vertex temp = minHeap[idx];
		minHeap[idx] = minHeap[child];
		minHeap[child] = temp;

		idx = child;
	}

	return ret;
}

int min(int a, int b) { return (a < b ? a : b); }

void dijkstra()
{
	cost[start] = 0;
	push({ start, 0 });

	while (heapSize > 0)
	{
		Vertex cur = pop();
		for (register int i = 1; i <= N; i++) {
			if (map[cur.from][i] == INF) continue;

			if (cost[i] > cost[cur.from] + map[cur.from][i]) {
				cost[i] = cost[cur.from] + map[cur.from][i];
				push({ i, cost[i] });
			}
		}
	}
}

int main()
{
	scanf("%d %d", &N, &M);
	for (register int i = 1; i <= N; i++) {
		cost[i] = INF;
		for (register int j = 1; j <= N; j++) map[i][j] = INF;
	}

	int s, e, w;
	for (register int i = 0; i < M; i++) {
		scanf("%d %d %d", &s, &e, &w);
		map[s][e] = min(map[s][e], w);
	}
	scanf("%d %d", &start, &dest);
	dijkstra();
	printf("%d\n", cost[dest]);
	return 0;
}