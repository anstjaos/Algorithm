#include <stdio.h>
#define INF 2123456789
int N, M, map[405][405];

int min(int a, int b) { return (a < b ? a : b); }

int main()
{
	scanf("%d %d", &N, &M);
	int s, e, c;
	for (register int i = 0; i < M; i++) {
		scanf("%d %d %d", &s, &e, &c);
		if (map[s][e] == 0 || map[s][e] > c) map[s][e] = c;
	}

	for (register int k = 1; k <= N; k++) {
		for (register int i = 1; i <= N; i++) {
			if (map[i][k] == 0) continue;
			for (register int j = 1; j <= N; j++) {
				if (map[k][j] == 0) continue;

				if (map[i][j] == 0 || map[i][j] > map[i][k] + map[k][j]) map[i][j] = map[i][k] + map[k][j];
			}
		}
	}

	int ret = INF;
	for (register int i = 1; i <= N; i++) {
		if (map[i][i] == 0) continue;
		ret = min(ret, map[i][i]);
	}

	if (ret == INF) ret = -1;
	printf("%d\n", ret);
	return 0;
}