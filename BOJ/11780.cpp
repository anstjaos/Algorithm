#include <stdio.h>
#define INF 2123456789

int N, M, map[101][101], next[101][101], stack[101], top;

int min(int a, int b) { return (a < b ? a : b); }

void printPath(int from, int to)
{
	top = -1;
	while (from != INF)
	{
		stack[++top] = from;
		from = next[from][to];
	}

	printf("%d ", top + 1);
	for (register int i = 0; i <= top; i++) printf("%d ", stack[i]);
	printf("\n");
}

int main()
{
	scanf("%d %d", &N, &M);
	for (register int i = 1; i <= N; i++) {
		for (register int j = 1; j <= N; j++) {
			next[i][j] = map[i][j] = INF;
		}
	}

	for (register int i = 0; i < M; i++) {
		int s, e, c;
		scanf("%d %d %d", &s, &e, &c);
		map[s][e] = min(map[s][e], c);
		next[s][e] = e;
	}

	for (register int k = 1; k <= N; k++) {
		for (register int i = 1; i <= N; i++) {
			if (map[i][k] == INF) continue;
			for (register int j = 1; j <= N; j++) {
				if (map[k][j] == INF || i == j) continue;

				if (map[i][j] > map[i][k] + map[k][j]) {
					map[i][j] = map[i][k] + map[k][j];
					next[i][j] = next[i][k];
				}
			}
		}
	}

	for (register int i = 1; i <= N; i++) {
		for (register int j = 1; j <= N; j++) {
			if (map[i][j] == INF || i == j) printf("0 ");
			else printf("%d ", map[i][j]);
		}
		printf("\n");
	}

	for (register int i = 1; i <= N; i++) {
		for (register int j = 1; j <= N; j++) {
			if (i == j) {
				printf("0\n");
				continue;
			}
			printPath(i, j);
		}
	}
}