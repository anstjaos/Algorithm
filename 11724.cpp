#include <stdio.h>
#define MAX_SIZE 100005

int N, M, map[1005][1005];
int queue[MAX_SIZE], front, rear;
bool visit[1005];

void push(int item)
{
	queue[++rear] = item;
}

int pop()
{
	return queue[++front];
}

void bfs(int start)
{
	front = rear = -1;
	push(start);
	visit[start] = true;

	while (front != rear)
	{
		int cur = pop();
		for (register int i = 1; i <= N; i++) {
			if (map[cur][i] == 1 && !visit[i]) {
				visit[i] = true;
				push(i);
			}
		}
	}
}

int main()
{
	scanf("%d %d", &N, &M);
	int a, b;
	for (register int i = 0; i < M; i++) {
		scanf("%d %d", &a, &b);
		map[a][b] = 1;
		map[b][a] = 1;
	}

	int cnt = 0;
	for (register int i = 1; i <= N; i++) {
		if (!visit[i]) {
			bfs(i);
			cnt++;
		}
	}
	printf("%d\n", cnt);
	return 0;
}