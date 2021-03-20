#include <stdio.h>

int N, map[25][25];
bool unUsed[25][25];

int main()
{
	scanf("%d", &N);
	for (register int i = 0; i < N; i++) {
		for (register int j = 0; j < N; j++) scanf("%d", &map[i][j]);
	}

	for (register int k = 0; k < N; k++) {
		for (register int i = 0; i < N; i++) {
			if (i == k) continue;
			for (register int j = 0; j < N; j++) {
				if (j == k || j == i) continue;

				if (map[i][j] > map[i][k] + map[k][j]) {
					printf("-1\n");
					return 0;
				}

				if (map[i][j] == map[i][k] + map[k][j]) {
					unUsed[i][j] = true;
				}
			}
		}
	}

	int ret = 0;
	for (register int i = 0; i < N; i++) {
		for (register int j = i; j < N; j++) {
			if (!unUsed[i][j]) ret += map[i][j];
		}
	}

	printf("%d\n", ret);
	return 0;
}