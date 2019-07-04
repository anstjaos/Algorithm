#include <cstdio>

int N, M, arr[1030][1030], pSum[1030][1030],x1, y1, x2, y2;

int main()
{
	scanf("%d %d", &N, &M);
	for (register int i = 1; i <= N; i++) {
		for (register int j = 1; j <= N; j++) {
			scanf("%d", &arr[i][j]);
			pSum[i][j] = pSum[i - 1][j] + pSum[i][j - 1] - pSum[i - 1][j - 1] + arr[i][j];
		}
	}

	for (register int i = 0; i < M; i++) {
		scanf("%d %d %d %d", &x1, &y1, &x2, &y2);
		printf("%d\n", pSum[x2][y2] - pSum[x2][y1 - 1] - pSum[x1 - 1][y2] + pSum[x1 - 1][y1 - 1]);
	}
	return 0;
}