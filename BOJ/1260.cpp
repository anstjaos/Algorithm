#include <stdio.h>
#define QUEUE_SIZE 10006

int N, M, V, arr[1005][1005];
int queue[QUEUE_SIZE], front, rear;
bool visit[1005];

void push(int item)
{
	queue[++rear] = item;
}

int pop()
{
	return queue[++front];
}

void bfs()
{
	front = rear = -1;
	push(V);
	visit[V] = true;

	while (front != rear)
	{
		int cur = pop();
		printf("%d ", cur);
		for (register int i = 1; i <= N; i++) {
			if (arr[cur][i] == 1 && !visit[i]) {
				visit[i] = true;
				push(i);
			}
		}
	}
	printf("\n");
}

void dfs(int cur)
{
	visit[cur] = true;
	printf("%d ", cur);
	for (register int i = 1; i <= N; i++)
	{
		if (arr[cur][i] == 1 && !visit[i]) {
			visit[i] = true;
			dfs(i);
		}
	}
}

int main()
{
	scanf("%d %d %d", &N, &M, &V);
	int a, b;
	for (register int i = 0; i < M; i++) {
		scanf("%d %d", &a, &b);
		arr[a][b] = 1;
		arr[b][a] = 1;
	}

	dfs(V);
	printf("\n");
	for (register int i = 1; i <= N; i++) visit[i] = false;

	bfs();
	
	return 0;
}