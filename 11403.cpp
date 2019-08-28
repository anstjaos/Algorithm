#include <stdio.h>

int map[101][101], N;

int main()
{
	scanf("%d", &N);
	for (register int i = 0; i < N; i++) {
		for (register int j = 0; j < N; j++) scanf("%d", &map[i][j]);
	}

	for (register int k = 0; k < N; k++) {
		for (register int i = 0; i < N; i++) {
			for (register int j = 0; j < N; j++) {
				if (map[i][k] == 1 && map[k][j] == 1) map[i][j] = 1;
			}
		}
	}

	for (register int i = 0; i < N; i++) {
		for (register int j = 0; j < N; j++) printf("%d ", map[i][j]);
		printf("\n");
	}
	
	return 0;
}