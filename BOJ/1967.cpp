#include <stdio.h>
#define MAX_NUM 20005
#define INF 2123456789

typedef struct Edge{
	int to;
	int weight;
	Edge* next;
}Edge;

int queue[MAX_NUM];
int front, rear, cost[MAX_NUM];
Edge edgePool[MAX_NUM];
int poolCnt, n, from, to, wei;
Edge *tree[MAX_NUM];
bool inQ[MAX_NUM];

void push(int item)
{
	rear = (rear + 1) % MAX_NUM;
	queue[rear] = item;
}

int pop()
{
	front = (front + 1) % MAX_NUM;
	return queue[front];
}

int bfs(int start)
{
	front = rear = -1;
	for (register int i = 1; i <= n; i++)
	{
		cost[i] = INF;
		inQ[i] = false;
	}
	push(start);
	inQ[start] = true;
	cost[start] = 0;

	while (front != rear)
	{
		int cur = pop();
		inQ[cur] = false;
		Edge *ptr = tree[cur];

		while (ptr != 0)
		{
			if (cost[cur] + ptr->weight < cost[ptr->to])
			{
				cost[ptr->to] = cost[cur] + ptr->weight;
				if (!inQ[ptr->to])
				{
					push(ptr->to);
					inQ[ptr->to] = true;
				}
			}
			ptr = ptr->next;
		}
	}
	int index = 1;
	for (register int i = 1; i <= n; i++) {
		if (cost[index] < cost[i]) index = i;
	}
	return index;
}

int main()
{
	scanf("%d", &n);
	for (register int i = 0; i < n; i++) {
		scanf("%d %d %d", &from, &to, &wei);
		edgePool[poolCnt] = { to, wei, tree[from]};
		
		tree[from] = &edgePool[poolCnt];
		poolCnt++;

		edgePool[poolCnt] = { from, wei, tree[to] };
		tree[to] = &edgePool[poolCnt++];
	}
	int y = bfs(1);
	int z = bfs(y);

	printf("%d\n", cost[z]);
	return 0;
}