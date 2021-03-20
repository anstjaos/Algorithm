#include <stdio.h>
#define MAX_SIZE 1001

int inEdge[MAX_SIZE], N, M, map[MAX_SIZE][MAX_SIZE];
int queue[MAX_SIZE * 10], front , rear, res[MAX_SIZE];
bool visit[MAX_SIZE];

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
	for (register int i = 1; i <= N; i++) {
		if (inEdge[i] == 0) push(i);
	}
	int cnt = 0;

	while (front != rear)
	{
		int cur = pop();
		res[cnt++] = cur;

		for (register int i = 1; i <= N; i++) {
			if (map[cur][i] != 0) {
				inEdge[i]-= map[cur][i];
				if (inEdge[i] == 0 && !visit[i]) {
					visit[i] = true;
					push(i);
				}
			}
		}
	}

	if (cnt != N) printf("0\n");
	else {
		for (register int i = 0; i < cnt; i++) printf("%d\n", res[i]);
	}
}

int main()
{
	scanf("%d %d", &N, &M);
	int cnt, before, cur;

	for (register int i = 0; i < M; i++) {
		scanf("%d %d", &cnt, &before);
		for (register int j = 1; j < cnt; j++) {
			scanf("%d", &cur);
			inEdge[cur]++;
			map[before][cur]++;
			before = cur;
		}
	}

	bfs();
	return 0;
}